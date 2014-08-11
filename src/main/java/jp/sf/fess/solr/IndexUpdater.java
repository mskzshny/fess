/*
 * Copyright 2009-2014 the CodeLibs Project and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package jp.sf.fess.solr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jp.sf.fess.Constants;
import jp.sf.fess.FessSystemException;
import jp.sf.fess.db.bsbhv.BsFavoriteLogBhv;
import jp.sf.fess.db.cbean.ClickLogCB;
import jp.sf.fess.db.exbhv.ClickLogBhv;
import jp.sf.fess.db.exbhv.FavoriteLogBhv;
import jp.sf.fess.db.exbhv.pmbean.FavoriteUrlCountPmb;
import jp.sf.fess.db.exentity.customize.FavoriteUrlCount;
import jp.sf.fess.helper.IntervalControlHelper;
import jp.sf.fess.helper.SystemHelper;
import jp.sf.fess.util.ComponentUtil;

import org.apache.solr.common.SolrInputDocument;
import org.codelibs.core.util.StringUtil;
import org.codelibs.solr.lib.SolrGroup;
import org.codelibs.solr.lib.exception.SolrLibException;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.framework.container.SingletonS2Container;
import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.annotation.tiger.BindingType;
import org.seasar.robot.S2Robot;
import org.seasar.robot.db.cbean.AccessResultCB;
import org.seasar.robot.db.exbhv.AccessResultBhv;
import org.seasar.robot.db.exbhv.AccessResultDataBhv;
import org.seasar.robot.db.exentity.AccessResult;
import org.seasar.robot.dbflute.cbean.PagingResultBean;
import org.seasar.robot.entity.AccessResultData;
import org.seasar.robot.service.DataService;
import org.seasar.robot.service.UrlFilterService;
import org.seasar.robot.service.UrlQueueService;
import org.seasar.robot.transformer.Transformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class IndexUpdater extends Thread {
    private static final Logger logger = LoggerFactory
            .getLogger(IndexUpdater.class);

    protected List<String> sessionIdList;

    protected SolrGroup solrGroup;

    @Resource
    protected DataService dataService;

    @Resource
    protected UrlQueueService urlQueueService;

    @Resource
    protected UrlFilterService urlFilterService;

    @Resource
    protected AccessResultBhv accessResultBhv;

    @Resource
    protected AccessResultDataBhv accessResultDataBhv;

    @Resource
    protected ClickLogBhv clickLogBhv;

    @Resource
    protected FavoriteLogBhv favoriteLogBhv;

    @Resource
    protected SystemHelper systemHelper;

    public int maxDocumentCacheSize = 5;

    protected boolean finishCrawling = false;

    public long updateInterval = 60000; // 1 min

    protected long executeTime;

    protected long documentSize;

    protected long commitPerCount = 0;

    protected int maxSolrErrorCount = 0;

    protected int maxErrorCount = 2;

    protected int unprocessedDocumentSize = 100;

    protected List<String> finishedSessionIdList = new ArrayList<String>();

    public long commitMarginTime = 10000; // 10ms

    public int maxEmptyListCount = 60; // 1hour

    public boolean threadDump = false;

    public boolean clickCountEnabled = true;

    public boolean favoriteCountEnabled = true;

    private final List<BoostDocumentRule> boostRuleList = new ArrayList<BoostDocumentRule>();

    private final Map<String, Object> docValueMap = new HashMap<String, Object>();

    private List<S2Robot> s2RobotList;
    
    private int prevSumAccessCount = 0;

    public IndexUpdater() {
        // nothing
    }

    public void addFinishedSessionId(final String sessionId) {
        synchronized (finishedSessionIdList) {
            finishedSessionIdList.add(sessionId);
        }
    }

    private void deleteBySessionId(final String sessionId) {
        try {
            urlFilterService.delete(sessionId);
        } catch (final Exception e) {
            logger.warn("Failed to delete url filters: " + sessionId, e);
        }
        try {
            urlQueueService.delete(sessionId);
        } catch (final Exception e) {
            logger.warn("Failed to delete url queues: " + sessionId, e);
        }
        try {
            dataService.delete(sessionId);
        } catch (final Exception e) {
            logger.warn("Failed to delete data: " + sessionId, e);
        }
    }

    @Override
    public void run() {
        if (dataService == null) {
            throw new FessSystemException("DataService is null.");
        }

        if (logger.isDebugEnabled()) {
            logger.debug("Starting indexUpdater.");
        }

        executeTime = 0;
        documentSize = 0;

        final IntervalControlHelper intervalControlHelper = ComponentUtil
                .getIntervalControlHelper();
        try {
            final AccessResultCB cb = new AccessResultCB();
            cb.setupSelect_AccessResultDataAsOne();
            cb.query().setSessionId_InScope(sessionIdList);
            cb.query().addOrderBy_CreateTime_Asc();
            cb.query().setStatus_Equal(org.seasar.robot.Constants.OK_STATUS);
            if (maxDocumentCacheSize <= 0) {
                maxDocumentCacheSize = 1;
            }
            cb.fetchFirst(maxDocumentCacheSize);
            cb.fetchPage(1);

            final List<SolrInputDocument> docList = new ArrayList<SolrInputDocument>();
            final List<org.seasar.robot.entity.AccessResult> accessResultList = new ArrayList<org.seasar.robot.entity.AccessResult>();
            final List<org.seasar.robot.db.exentity.AccessResultData> accessResultDataList = new ArrayList<org.seasar.robot.db.exentity.AccessResultData>();

            long updateTime = System.currentTimeMillis();
            int solrErrorCount = 0;
            int errorCount = 0;
            int emptyListCount = 0;
            while (!finishCrawling || !accessResultList.isEmpty()) {

                if (logger.isInfoEnabled()) {
                    logger.info("Access Result List : " + accessResultList.isEmpty());
                    logger.info("Access Result List : " + accessResultList.size());
                    logger.info("S2Robot size       : " + s2RobotList.size());
                }
                try {
                    final int sessionIdListSize = finishedSessionIdList.size();
                    intervalControlHelper.setCrawlerRunning(true);

                    updateTime = System.currentTimeMillis() - updateTime;

                    final long interval = updateInterval - updateTime;
                    if (interval > 0) {
                        // sleep
                        try {
                            Thread.sleep(interval); // 1 min (default)
                        } catch (final InterruptedException e) {
                            logger.warn("Interrupted index update.", e);
                        }
                    }

                    docList.clear();
                    accessResultList.clear();
                    accessResultDataList.clear();

                    intervalControlHelper.delayByRules();

                    if (logger.isDebugEnabled()) {
                        logger.debug("Processing documents in IndexUpdater queue.");
                    }

                    updateTime = System.currentTimeMillis();

                    PagingResultBean<AccessResult> arList = getAccessResultList(cb);
                    if (arList.isEmpty()) {
                        emptyListCount++;
                    } else {
                        emptyListCount = 0; // reset
                    }
                    //TODO: DELETE
                    if (logger.isInfoEnabled()) {
                        logger.info("Access Result List : " + arList.isEmpty());
                        logger.info("Access Result List : " + arList.size());
                    }

                    while (!arList.isEmpty()) {
                        processAccessResults(docList, accessResultList,
                                accessResultDataList, arList);

                        cleanupAccessResults(accessResultList,
                                accessResultDataList);

                        if (logger.isDebugEnabled()) {
                            logger.debug("Getting documents in IndexUpdater queue.");
                        }
                        arList = getAccessResultList(cb);
                    }

                    if (!docList.isEmpty()) {
                        sendDocuments(docList);
                    }

                    synchronized (finishedSessionIdList) {
                        if (sessionIdListSize != 0
                                && sessionIdListSize == finishedSessionIdList
                                        .size()) {
                            cleanupFinishedSessionData();
                        }
                    }
                    executeTime += System.currentTimeMillis() - updateTime;

                    if (logger.isDebugEnabled()) {
                        logger.debug("Processed documents in IndexUpdater queue.");
                    }

                    // reset count
                    solrErrorCount = 0;
                    errorCount = 0;
                } catch (final SolrLibException e) {
                    if (solrErrorCount > maxSolrErrorCount) {
                        throw e;
                    }
                    solrErrorCount++;
                    logger.warn(
                            "Failed to access a solr group. Retry to access.. "
                                    + solrErrorCount, e);
                } catch (final Exception e) {
                    if (errorCount > maxErrorCount) {
                        throw e;
                    }
                    errorCount++;
                    logger.warn("Failed to access data. Retry to access.. "
                            + errorCount, e);
                } finally {
                    if (systemHelper.isForceStop()) {
                        finishCrawling = true;
                        if (logger.isDebugEnabled()) {
                            logger.debug("Stopped indexUpdater.");
                        }
                    }
                }

                int sumAccessCount = 0;
                int sumMaxAccessCount = 0;
                int notYetCrawl = 0;
            	//まだクロールするデータがあれば終了させないようにする。
            	Iterator<S2Robot> i = s2RobotList.iterator();
            	while(i.hasNext()){
            		S2Robot r = i.next();
            		sumAccessCount += r.getRobotContext().getAccessCount();
            		sumMaxAccessCount += r.getRobotContext().getMaxAccessCount();
                    if (logger.isInfoEnabled()) {
                        logger.info("INFO: S2Robot is Runninng?        ... -> " + r.getRobotContext().isRunning() );
                        logger.info("INFO: S2Robot Access Count        ... -> " + r.getRobotContext().getAccessCount() + "/" + r.getRobotContext().getMaxAccessCount() );
                    }
                    if( r.getRobotContext().getAccessCount() <= 0 ){
                    	notYetCrawl++;
                    }
            	}
            	
                if (logger.isInfoEnabled()) {
                    logger.info("INFO: emptyListCount              ... -> " + emptyListCount );
                    logger.info("INFO: S2Robot sumAccessCount / prevSumAccessCount / maxAccessCount    ... -> " + sumAccessCount + "/" + prevSumAccessCount + "/" + sumMaxAccessCount );
                }
                
            	//前回よりもアクセス数が増えていない場合
            	if( sumAccessCount <= this.prevSumAccessCount  ){
            		//かつ、からの状態が続いている場合。
            		//停止判定
            		boolean doFinish = false;
            		// 規定のアクセス数を超えている。
            		if( sumAccessCount >= sumMaxAccessCount ){
            			doFinish = true;
            		}
            		// 空の状態(emptyListがカウントされている状態)がずっと続いている。(適切ではない。)
            		if( emptyListCount >= maxEmptyListCount ){
            			//　すくなくとも全部のフォルダー１つはクロールしている。
            			doFinish = true;
            			if( notYetCrawl >= 0){
            				doFinish = false;
            			}
            		}
            		
            		if( doFinish ){
	            		//その時に終了
	                    if (logger.isInfoEnabled()) {
	                        logger.info("Terminating indexUpdater. "
	                                + "emptyListCount is over " + maxEmptyListCount
	                                + ".");
	                    }
	                    // terminate crawling
	                    finishCrawling = true;
	                    forceStop();
	                    if (threadDump) {
	                        printThreadDump();
	                    }
            		}
            	}
            	else{
            		this.prevSumAccessCount = sumAccessCount;
            	}
            }

            if (logger.isDebugEnabled()) {
                logger.debug("Finished indexUpdater.");
            }
        } catch (final Throwable t) { // NOPMD
            logger.error("IndexUpdater is terminated.", t);
            forceStop();
        } finally {
            intervalControlHelper.setCrawlerRunning(true);
        }

        if (logger.isInfoEnabled()) {
            logger.info("[EXEC TIME] index update time: " + executeTime + "ms");
        }

    }

    private void printThreadDump() {
        for (final Map.Entry<Thread, StackTraceElement[]> entry : Thread
                .getAllStackTraces().entrySet()) {
            logger.info("Thread: " + entry.getKey());
            final StackTraceElement[] trace = entry.getValue();
            for (final StackTraceElement element : trace) {
                logger.info("\tat " + element);
            }
        }
    }

    private void processAccessResults(
            final List<SolrInputDocument> docList,
            final List<org.seasar.robot.entity.AccessResult> accessResultList,
            final List<org.seasar.robot.db.exentity.AccessResultData> accessResultDataList,
            final PagingResultBean<AccessResult> arList) {
        for (final AccessResult accessResult : arList) {
            if (logger.isDebugEnabled()) {
                logger.debug("Indexing " + accessResult.getUrl());
            }
            accessResult.setStatus(Constants.DONE_STATUS);
            accessResultList.add(accessResult);

            if (accessResult.getHttpStatusCode() != 200) {
                // invalid page
                if (logger.isDebugEnabled()) {
                    logger.debug("Skipped. The response code is "
                            + accessResult.getHttpStatusCode() + ".");
                }
                continue;
            }

            final AccessResultData accessResultData = accessResult
                    .getAccessResultData();
            if (accessResultData != null) {
                accessResult.setAccessResultData(null);
                accessResultDataList
                        .add((org.seasar.robot.db.exentity.AccessResultData) accessResultData);
                try {
                    final Transformer transformer = SingletonS2Container
                            .getComponent(accessResultData.getTransformerName());
                    if (transformer == null) {
                        // no transformer
                        logger.warn("No transformer: "
                                + accessResultData.getTransformerName());
                        continue;
                    }
                    @SuppressWarnings("unchecked")
                    final Map<String, Object> map = (Map<String, Object>) transformer
                            .getData(accessResultData);
                    if (map.isEmpty()) {
                        // no transformer
                        logger.warn("No data: " + accessResult.getUrl());
                        continue;
                    }

                    if (Constants.FALSE.equals(map
                            .get(Constants.INDEXING_TARGET))) {
                        if (logger.isDebugEnabled()) {
                            logger.debug("Skipped. "
                                    + "This document is not a index target. ");
                        }
                        continue;
                    } else {
                        map.remove(Constants.INDEXING_TARGET);
                    }

                    final SolrInputDocument doc = createSolrDocument(map);

                    docList.add(doc);
                    if (logger.isDebugEnabled()) {
                        logger.debug("Added the document. "
                                + "The number of a document cache is "
                                + docList.size() + ".");
                    }

                    if (docList.size() >= maxDocumentCacheSize) {
                        sendDocuments(docList);
                    }
                    documentSize++;
                    // commit
                    if (commitPerCount > 0
                            && documentSize % commitPerCount == 0) {
                        if (!docList.isEmpty()) {
                            sendDocuments(docList);
                        }
                        commitDocuments();
                    }
                    if (logger.isDebugEnabled()) {
                        logger.debug("The number of an added document is "
                                + documentSize + ".");
                    }
                } catch (final SolrLibException e) {
                    throw e;
                } catch (final Exception e) {
                    logger.warn(
                            "Could not add a doc: " + accessResult.getUrl(), e);
                }
            } else {
                if (logger.isDebugEnabled()) {
                    logger.debug("Skipped. No content. ");
                }
            }

        }
    }

    protected SolrInputDocument createSolrDocument(final Map<String, Object> map) {
        final SolrInputDocument doc = new SolrInputDocument();
        float documentBoost = 0.0f;
        // add data
        for (final Map.Entry<String, Object> entry : map.entrySet()) {
            if ("boost".equals(entry.getKey())) {
                // boost
                documentBoost = Float.valueOf(entry.getValue().toString());
            } else {
                doc.addField(entry.getKey(), entry.getValue());
            }
        }

        if (clickCountEnabled) {
            addClickCountField(map, doc);
        }

        if (favoriteCountEnabled) {
            addFavoriteCountField(map, doc);
        }

        // default values
        for (final Map.Entry<String, Object> entry : docValueMap.entrySet()) {
            final String key = entry.getKey();
            final Object obj = map.get(key);
            if (obj == null) {
                map.put(key, entry.getValue());
            }
        }

        for (final BoostDocumentRule rule : boostRuleList) {
            if (rule.match(map)) {
                documentBoost = rule.getValue(map);
                break;
            }
        }

        if (documentBoost > 0) {
            addBoostValue(map, documentBoost, doc);
        }

        if (!map.containsKey(Constants.DOC_ID)) {
            doc.addField(Constants.DOC_ID, systemHelper.generateDocId(map));
        }

        return doc;
    }

    protected void addBoostValue(final Map<String, Object> map,
            final float documentBoost, final SolrInputDocument doc) {
        doc.addField("boost", documentBoost);
        doc.setDocumentBoost(documentBoost);
        if (logger.isDebugEnabled()) {
            logger.debug("Set a document boost (" + documentBoost + ").");
        }
    }

    protected void addClickCountField(final Map<String, Object> map,
            final SolrInputDocument doc) {
        final String url = (String) map.get("url");
        if (StringUtil.isNotBlank(url)) {
            final ClickLogCB cb = new ClickLogCB();
            cb.query().setUrl_Equal(url);
            final int count = clickLogBhv.selectCount(cb);
            doc.addField(systemHelper.clickCountField, count);
            map.put(systemHelper.clickCountField, count);
            if (logger.isDebugEnabled()) {
                logger.debug("Click Count: " + count + ", url: " + url);
            }
        }
    }

    protected void addFavoriteCountField(final Map<String, Object> map,
            final SolrInputDocument doc) {
        final String url = (String) map.get("url");
        if (StringUtil.isNotBlank(url)) {
            final FavoriteUrlCountPmb pmb = new FavoriteUrlCountPmb();
            pmb.setUrl(url);
            final String path = BsFavoriteLogBhv.PATH_selectFavoriteUrlCount;
            final ListResultBean<FavoriteUrlCount> list = favoriteLogBhv
                    .outsideSql().selectList(path, pmb, FavoriteUrlCount.class);

            long count = 0;
            if (!list.isEmpty()) {
                count = list.get(0).getCnt().longValue();
            }

            doc.addField(systemHelper.favoriteCountField, count);
            map.put(systemHelper.favoriteCountField, count);
            if (logger.isDebugEnabled()) {
                logger.debug("Favorite Count: " + count + ", url: " + url);
            }
        }
    }

    private void cleanupAccessResults(
            final List<org.seasar.robot.entity.AccessResult> accessResultList,
            final List<org.seasar.robot.db.exentity.AccessResultData> accessResultDataList) {
        if (!accessResultList.isEmpty()) {
            final long execTime = System.currentTimeMillis();
            final int size = accessResultList.size();
            dataService.update(accessResultList);
            accessResultList.clear();
            if (logger.isDebugEnabled()) {
                logger.debug("Updated " + size
                        + " access results. The execution time is "
                        + (System.currentTimeMillis() - execTime) + "ms.");
            }
        }

        if (!accessResultDataList.isEmpty()) {
            final long execTime = System.currentTimeMillis();
            final int size = accessResultDataList.size();
            // clean up content
            accessResultDataBhv.batchDelete(accessResultDataList);
            accessResultDataList.clear();
            if (logger.isDebugEnabled()) {
                logger.debug("Deleted " + size
                        + " access result data. The execution time is "
                        + (System.currentTimeMillis() - execTime) + "ms.");
            }
        }
    }

    private PagingResultBean<AccessResult> getAccessResultList(
            final AccessResultCB cb) {
        final long execTime = System.currentTimeMillis();
        final PagingResultBean<AccessResult> arList = accessResultBhv.selectPage(cb);
        if (!arList.isEmpty()) {
            for (final AccessResult ar : arList.toArray(new AccessResult[arList
                    .size()])) {
                if (ar.getCreateTime().getTime() > execTime - commitMarginTime) {
                    arList.remove(ar);
                }
            }
        }
        if (logger.isInfoEnabled()) {
            logger.info("The number of a crawled document is "
                    + arList.getAllRecordCount() + ". The processing size is "
                    + arList.size() + ". The execution time is "
                    + (System.currentTimeMillis() - execTime) + "ms.");
        }
        if (arList.getAllRecordCount() > unprocessedDocumentSize) {
            if (logger.isInfoEnabled()) {
                logger.info("Stopped all crawler threads. " + " You have "
                        + arList.getAllRecordCount() + " (>"
                        + unprocessedDocumentSize + ") "
                        + " unprocessed documents.");
            }
            final IntervalControlHelper intervalControlHelper = ComponentUtil
                    .getIntervalControlHelper();
            intervalControlHelper.setCrawlerRunning(false);
        }
        return arList;
    }

    private void cleanupFinishedSessionData() {
        final long execTime = System.currentTimeMillis();
        // cleanup
        for (final String sessionId : finishedSessionIdList) {
            final long execTime2 = System.currentTimeMillis();
            if (logger.isDebugEnabled()) {
                logger.debug("Deleting document data: " + sessionId);
            }
            deleteBySessionId(sessionId);
            if (logger.isDebugEnabled()) {
                logger.debug("Deleted " + sessionId
                        + " documents. The execution time is "
                        + (System.currentTimeMillis() - execTime2) + "ms.");
            }
        }
        finishedSessionIdList.clear();

        if (logger.isInfoEnabled()) {
            logger.info("Deleted completed document data. "
                    + "The execution time is "
                    + (System.currentTimeMillis() - execTime) + "ms.");
        }
    }

    private void commitDocuments() {
        final long execTime = System.currentTimeMillis();
        if (logger.isInfoEnabled()) {
            logger.info("Committing documents. ");
        }
        synchronized (solrGroup) {
            solrGroup.commit(true, true, false, true);
        }
        if (logger.isInfoEnabled()) {
            logger.info("Committed documents. The execution time is "
                    + (System.currentTimeMillis() - execTime) + "ms.");
        }
    }

    private void sendDocuments(final List<SolrInputDocument> docList) {
        final long execTime = System.currentTimeMillis();
        if (logger.isInfoEnabled()) {
            logger.info("Sending " + docList.size() + " document to a server.");
        }
        synchronized (solrGroup) {
            solrGroup.add(docList);
        }
        if (logger.isInfoEnabled()) {
            logger.info("Sent " + docList.size()
                    + " documents. The execution time is "
                    + (System.currentTimeMillis() - execTime) + "ms.");
        }
        docList.clear();
    }

    private void forceStop() {
        systemHelper.setForceStop(true);
        for (final S2Robot s2Robot : s2RobotList) {
            s2Robot.stop();
        }
    }

    public long getExecuteTime() {
        return executeTime;
    }

    public List<String> getSessionIdList() {
        return sessionIdList;
    }

    public void setSessionIdList(final List<String> sessionIdList) {
        this.sessionIdList = sessionIdList;
    }

    public SolrGroup getSolrGroup() {
        return solrGroup;
    }

    public void setSolrGroup(final SolrGroup solrGroup) {
        this.solrGroup = solrGroup;
    }

    public void setFinishCrawling(final boolean finishCrawling) {
        this.finishCrawling = finishCrawling;
    }

    public long getDocumentSize() {
        return documentSize;
    }

    public void setCommitPerCount(final long commitPerCount) {
        this.commitPerCount = commitPerCount;
    }

    @Binding(bindingType = BindingType.MAY)
    @Override
    public void setUncaughtExceptionHandler(final UncaughtExceptionHandler eh) {
        super.setUncaughtExceptionHandler(eh);
    }

    @Binding(bindingType = BindingType.MAY)
    public static void setDefaultUncaughtExceptionHandler(
            final UncaughtExceptionHandler eh) {
        Thread.setDefaultUncaughtExceptionHandler(eh);
    }

    public void setMaxSolrErrorCount(final int maxSolrErrorCount) {
        this.maxSolrErrorCount = maxSolrErrorCount;
    }

    public void setUnprocessedDocumentSize(final int unprocessedDocumentSize) {
        this.unprocessedDocumentSize = unprocessedDocumentSize;
    }

    public void addBoostDocumentRule(final BoostDocumentRule rule) {
        boostRuleList.add(rule);
    }

    public void addDefaultDocValue(final String fieldName, final Object value) {
        docValueMap.put(fieldName, value);
    }

    public void setS2RobotList(final List<S2Robot> s2RobotList) {
        this.s2RobotList = s2RobotList;
    }
}
