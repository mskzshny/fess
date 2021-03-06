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

package jp.sf.fess.db.bsbhv;

import java.util.List;

import jp.sf.fess.db.bsentity.dbmeta.CrawlingSessionDbm;
import jp.sf.fess.db.cbean.CrawlingSessionCB;
import jp.sf.fess.db.cbean.CrawlingSessionInfoCB;
import jp.sf.fess.db.exbhv.CrawlingSessionBhv;
import jp.sf.fess.db.exbhv.CrawlingSessionInfoBhv;
import jp.sf.fess.db.exentity.CrawlingSession;
import jp.sf.fess.db.exentity.CrawlingSessionInfo;

import org.seasar.dbflute.Entity;
import org.seasar.dbflute.bhv.AbstractBehaviorWritable;
import org.seasar.dbflute.bhv.ConditionBeanSetupper;
import org.seasar.dbflute.bhv.DeleteOption;
import org.seasar.dbflute.bhv.InsertOption;
import org.seasar.dbflute.bhv.LoadReferrerOption;
import org.seasar.dbflute.bhv.QueryInsertSetupper;
import org.seasar.dbflute.bhv.UpdateOption;
import org.seasar.dbflute.cbean.ConditionBean;
import org.seasar.dbflute.cbean.EntityRowHandler;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.PagingResultBean;
import org.seasar.dbflute.cbean.SpecifyQuery;
import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.outsidesql.executor.OutsideSqlBasicExecutor;

/**
 * The behavior of CRAWLING_SESSION as TABLE. <br />
 * <pre>
 * [primary key]
 *     ID
 *
 * [column]
 *     ID, SESSION_ID, NAME, EXPIRED_TIME, CREATED_TIME
 *
 * [sequence]
 *
 *
 * [identity]
 *     ID
 *
 * [version-no]
 *
 *
 * [foreign table]
 *
 *
 * [referrer table]
 *     CRAWLING_SESSION_INFO
 *
 * [foreign property]
 *
 *
 * [referrer property]
 *     crawlingSessionInfoList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsCrawlingSessionBhv extends AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    @Override
    public String getTableDbName() {
        return "CRAWLING_SESSION";
    }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** @return The instance of DBMeta. (NotNull) */
    @Override
    public DBMeta getDBMeta() {
        return CrawlingSessionDbm.getInstance();
    }

    /** @return The instance of DBMeta as my table type. (NotNull) */
    public CrawlingSessionDbm getMyDBMeta() {
        return CrawlingSessionDbm.getInstance();
    }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    @Override
    public Entity newEntity() {
        return newMyEntity();
    }

    /** {@inheritDoc} */
    @Override
    public ConditionBean newConditionBean() {
        return newMyConditionBean();
    }

    /** @return The instance of new entity as my table type. (NotNull) */
    public CrawlingSession newMyEntity() {
        return new CrawlingSession();
    }

    /** @return The instance of new condition-bean as my table type. (NotNull) */
    public CrawlingSessionCB newMyConditionBean() {
        return new CrawlingSessionCB();
    }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br />
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * CrawlingSessionCB cb = new CrawlingSessionCB();
     * cb.query().setFoo...(value);
     * int count = crawlingSessionBhv.<span style="color: #FD4747">selectCount</span>(cb);
     * </pre>
     * @param cb The condition-bean of CrawlingSession. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(final CrawlingSessionCB cb) {
        return doSelectCountUniquely(cb);
    }

    protected int doSelectCountUniquely(final CrawlingSessionCB cb) { // called by selectCount(cb)
        assertCBStateValid(cb);
        return delegateSelectCountUniquely(cb);
    }

    protected int doSelectCountPlainly(final CrawlingSessionCB cb) { // called by selectPage(cb)
        assertCBStateValid(cb);
        return delegateSelectCountPlainly(cb);
    }

    @Override
    protected int doReadCount(final ConditionBean cb) {
        return selectCount(downcast(cb));
    }

    // ===================================================================================
    //                                                                       Entity Select
    //                                                                       =============
    /**
     * Select the entity by the condition-bean.
     * <pre>
     * CrawlingSessionCB cb = new CrawlingSessionCB();
     * cb.query().setFoo...(value);
     * CrawlingSession crawlingSession = crawlingSessionBhv.<span style="color: #FD4747">selectEntity</span>(cb);
     * if (crawlingSession != null) {
     *     ... = crawlingSession.get...();
     * } else {
     *     ...
     * }
     * </pre>
     * @param cb The condition-bean of CrawlingSession. (NotNull)
     * @return The entity selected by the condition. (NullAllowed: if no data, it returns null)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public CrawlingSession selectEntity(final CrawlingSessionCB cb) {
        return doSelectEntity(cb, CrawlingSession.class);
    }

    protected <ENTITY extends CrawlingSession> ENTITY doSelectEntity(
            final CrawlingSessionCB cb, final Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        return helpSelectEntityInternally(cb, entityType,
                new InternalSelectEntityCallback<ENTITY, CrawlingSessionCB>() {
                    @Override
                    public List<ENTITY> callbackSelectList(
                            final CrawlingSessionCB cb,
                            final Class<ENTITY> entityType) {
                        return doSelectList(cb, entityType);
                    }
                });
    }

    @Override
    protected Entity doReadEntity(final ConditionBean cb) {
        return selectEntity(downcast(cb));
    }

    /**
     * Select the entity by the condition-bean with deleted check.
     * <pre>
     * CrawlingSessionCB cb = new CrawlingSessionCB();
     * cb.query().setFoo...(value);
     * CrawlingSession crawlingSession = crawlingSessionBhv.<span style="color: #FD4747">selectEntityWithDeletedCheck</span>(cb);
     * ... = crawlingSession.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cb The condition-bean of CrawlingSession. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public CrawlingSession selectEntityWithDeletedCheck(
            final CrawlingSessionCB cb) {
        return doSelectEntityWithDeletedCheck(cb, CrawlingSession.class);
    }

    protected <ENTITY extends CrawlingSession> ENTITY doSelectEntityWithDeletedCheck(
            final CrawlingSessionCB cb, final Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        return helpSelectEntityWithDeletedCheckInternally(
                cb,
                entityType,
                new InternalSelectEntityWithDeletedCheckCallback<ENTITY, CrawlingSessionCB>() {
                    @Override
                    public List<ENTITY> callbackSelectList(
                            final CrawlingSessionCB cb,
                            final Class<ENTITY> entityType) {
                        return doSelectList(cb, entityType);
                    }
                });
    }

    @Override
    protected Entity doReadEntityWithDeletedCheck(final ConditionBean cb) {
        return selectEntityWithDeletedCheck(downcast(cb));
    }

    /**
     * Select the entity by the primary-key value.
     * @param id The one of primary key. (NotNull)
     * @return The entity selected by the PK. (NullAllowed: if no data, it returns null)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public CrawlingSession selectByPKValue(final Long id) {
        return doSelectByPKValue(id, CrawlingSession.class);
    }

    protected <ENTITY extends CrawlingSession> ENTITY doSelectByPKValue(
            final Long id, final Class<ENTITY> entityType) {
        return doSelectEntity(buildPKCB(id), entityType);
    }

    /**
     * Select the entity by the primary-key value with deleted check.
     * @param id The one of primary key. (NotNull)
     * @return The entity selected by the PK. (NotNull: if no data, throws exception)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public CrawlingSession selectByPKValueWithDeletedCheck(final Long id) {
        return doSelectByPKValueWithDeletedCheck(id, CrawlingSession.class);
    }

    protected <ENTITY extends CrawlingSession> ENTITY doSelectByPKValueWithDeletedCheck(
            final Long id, final Class<ENTITY> entityType) {
        return doSelectEntityWithDeletedCheck(buildPKCB(id), entityType);
    }

    private CrawlingSessionCB buildPKCB(final Long id) {
        assertObjectNotNull("id", id);
        final CrawlingSessionCB cb = newMyConditionBean();
        cb.query().setId_Equal(id);
        return cb;
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * CrawlingSessionCB cb = new CrawlingSessionCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * ListResultBean&lt;CrawlingSession&gt; crawlingSessionList = crawlingSessionBhv.<span style="color: #FD4747">selectList</span>(cb);
     * for (CrawlingSession crawlingSession : crawlingSessionList) {
     *     ... = crawlingSession.get...();
     * }
     * </pre>
     * @param cb The condition-bean of CrawlingSession. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @exception org.seasar.dbflute.exception.DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<CrawlingSession> selectList(final CrawlingSessionCB cb) {
        return doSelectList(cb, CrawlingSession.class);
    }

    protected <ENTITY extends CrawlingSession> ListResultBean<ENTITY> doSelectList(
            final CrawlingSessionCB cb, final Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        assertObjectNotNull("entityType", entityType);
        assertSpecifyDerivedReferrerEntityProperty(cb, entityType);
        return helpSelectListInternally(cb, entityType,
                new InternalSelectListCallback<ENTITY, CrawlingSessionCB>() {
                    @Override
                    public List<ENTITY> callbackSelectList(
                            final CrawlingSessionCB cb,
                            final Class<ENTITY> entityType) {
                        return delegateSelectList(cb, entityType);
                    }
                });
    }

    @Override
    protected ListResultBean<? extends Entity> doReadList(final ConditionBean cb) {
        return selectList(downcast(cb));
    }

    // ===================================================================================
    //                                                                         Page Select
    //                                                                         ===========
    /**
     * Select the page as result bean. <br />
     * (both count-select and paging-select are executed)
     * <pre>
     * CrawlingSessionCB cb = new CrawlingSessionCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * cb.<span style="color: #FD4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * PagingResultBean&lt;CrawlingSession&gt; page = crawlingSessionBhv.<span style="color: #FD4747">selectPage</span>(cb);
     * int allRecordCount = page.getAllRecordCount();
     * int allPageCount = page.getAllPageCount();
     * boolean isExistPrePage = page.isExistPrePage();
     * boolean isExistNextPage = page.isExistNextPage();
     * ...
     * for (CrawlingSession crawlingSession : page) {
     *     ... = crawlingSession.get...();
     * }
     * </pre>
     * @param cb The condition-bean of CrawlingSession. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @exception org.seasar.dbflute.exception.DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<CrawlingSession> selectPage(
            final CrawlingSessionCB cb) {
        return doSelectPage(cb, CrawlingSession.class);
    }

    protected <ENTITY extends CrawlingSession> PagingResultBean<ENTITY> doSelectPage(
            final CrawlingSessionCB cb, final Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        assertObjectNotNull("entityType", entityType);
        return helpSelectPageInternally(cb, entityType,
                new InternalSelectPageCallback<ENTITY, CrawlingSessionCB>() {
                    @Override
                    public int callbackSelectCount(final CrawlingSessionCB cb) {
                        return doSelectCountPlainly(cb);
                    }

                    @Override
                    public List<ENTITY> callbackSelectList(
                            final CrawlingSessionCB cb,
                            final Class<ENTITY> entityType) {
                        return doSelectList(cb, entityType);
                    }
                });
    }

    @Override
    protected PagingResultBean<? extends Entity> doReadPage(
            final ConditionBean cb) {
        return selectPage(downcast(cb));
    }

    // ===================================================================================
    //                                                                       Cursor Select
    //                                                                       =============
    /**
     * Select the cursor by the condition-bean.
     * <pre>
     * CrawlingSessionCB cb = new CrawlingSessionCB();
     * cb.query().setFoo...(value);
     * crawlingSessionBhv.<span style="color: #FD4747">selectCursor</span>(cb, new EntityRowHandler&lt;CrawlingSession&gt;() {
     *     public void handle(CrawlingSession entity) {
     *         ... = entity.getFoo...();
     *     }
     * });
     * </pre>
     * @param cb The condition-bean of CrawlingSession. (NotNull)
     * @param entityRowHandler The handler of entity row of CrawlingSession. (NotNull)
     */
    public void selectCursor(final CrawlingSessionCB cb,
            final EntityRowHandler<CrawlingSession> entityRowHandler) {
        doSelectCursor(cb, entityRowHandler, CrawlingSession.class);
    }

    protected <ENTITY extends CrawlingSession> void doSelectCursor(
            final CrawlingSessionCB cb,
            final EntityRowHandler<ENTITY> entityRowHandler,
            final Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        assertObjectNotNull("entityRowHandler<CrawlingSession>",
                entityRowHandler);
        assertObjectNotNull("entityType", entityType);
        assertSpecifyDerivedReferrerEntityProperty(cb, entityType);
        helpSelectCursorInternally(cb, entityRowHandler, entityType,
                new InternalSelectCursorCallback<ENTITY, CrawlingSessionCB>() {
                    @Override
                    public void callbackSelectCursor(
                            final CrawlingSessionCB cb,
                            final EntityRowHandler<ENTITY> entityRowHandler,
                            final Class<ENTITY> entityType) {
                        delegateSelectCursor(cb, entityRowHandler, entityType);
                    }

                    @Override
                    public List<ENTITY> callbackSelectList(
                            final CrawlingSessionCB cb,
                            final Class<ENTITY> entityType) {
                        return doSelectList(cb, entityType);
                    }
                });
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br />
     * You should call a function method after this method called like as follows:
     * <pre>
     * crawlingSessionBhv.<span style="color: #FD4747">scalarSelect</span>(Date.class).max(new ScalarQuery() {
     *     public void query(CrawlingSessionCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooDatetime()</span>; <span style="color: #3F7E5E">// required for a function</span>
     *         cb.query().setBarName_PrefixSearch("S");
     *     }
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar value derived by a function. (NullAllowed)
     */
    public <RESULT> SLFunction<CrawlingSessionCB, RESULT> scalarSelect(
            final Class<RESULT> resultType) {
        return doScalarSelect(resultType, newMyConditionBean());
    }

    protected <RESULT, CB extends CrawlingSessionCB> SLFunction<CB, RESULT> doScalarSelect(
            final Class<RESULT> resultType, final CB cb) {
        assertObjectNotNull("resultType", resultType);
        assertCBStateValid(cb);
        cb.xsetupForScalarSelect();
        cb.getSqlClause().disableSelectIndex(); // for when you use union
        return new SLFunction<CB, RESULT>(cb, resultType);
    }

    // ===================================================================================
    //                                                                            Sequence
    //                                                                            ========
    @Override
    protected Number doReadNextVal() {
        final String msg = "This table is NOT related to sequence: "
                + getTableDbName();
        throw new UnsupportedOperationException(msg);
    }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    /**
     * {Refer to overload method that has an argument of the list of entity.}
     * @param crawlingSession The entity of crawlingSession. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     */
    public void loadCrawlingSessionInfoList(
            final CrawlingSession crawlingSession,
            final ConditionBeanSetupper<CrawlingSessionInfoCB> conditionBeanSetupper) {
        xassLRArg(crawlingSession, conditionBeanSetupper);
        loadCrawlingSessionInfoList(xnewLRLs(crawlingSession),
                conditionBeanSetupper);
    }

    /**
     * Load referrer of crawlingSessionInfoList with the set-upper for condition-bean of referrer. <br />
     * CRAWLING_SESSION_INFO by CRAWLING_SESSION_ID, named 'crawlingSessionInfoList'.
     * <pre>
     * crawlingSessionBhv.<span style="color: #FD4747">loadCrawlingSessionInfoList</span>(crawlingSessionList, new ConditionBeanSetupper&lt;CrawlingSessionInfoCB&gt;() {
     *     public void setup(CrawlingSessionInfoCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...(); <span style="color: #3F7E5E">// basically you should order referrer list</span>
     *     }
     * });
     * for (CrawlingSession crawlingSession : crawlingSessionList) {
     *     ... = crawlingSession.<span style="color: #FD4747">getCrawlingSessionInfoList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key(and others too) is treated as case-insensitive. <br />
     * The condition-bean that the set-upper provides have settings before you touch it. It is as follows:
     * <pre>
     * cb.query().setCrawlingSessionId_InScope(pkList);
     * cb.query().addOrderBy_CrawlingSessionId_Asc();
     * </pre>
     * @param crawlingSessionList The entity list of crawlingSession. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     */
    public void loadCrawlingSessionInfoList(
            final List<CrawlingSession> crawlingSessionList,
            final ConditionBeanSetupper<CrawlingSessionInfoCB> conditionBeanSetupper) {
        xassLRArg(crawlingSessionList, conditionBeanSetupper);
        loadCrawlingSessionInfoList(
                crawlingSessionList,
                new LoadReferrerOption<CrawlingSessionInfoCB, CrawlingSessionInfo>()
                        .xinit(conditionBeanSetupper));
    }

    /**
     * {Refer to overload method that has an argument of the list of entity.}
     * @param crawlingSession The entity of crawlingSession. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     */
    public void loadCrawlingSessionInfoList(
            final CrawlingSession crawlingSession,
            final LoadReferrerOption<CrawlingSessionInfoCB, CrawlingSessionInfo> loadReferrerOption) {
        xassLRArg(crawlingSession, loadReferrerOption);
        loadCrawlingSessionInfoList(xnewLRLs(crawlingSession),
                loadReferrerOption);
    }

    /**
     * {Refer to overload method that has an argument of condition-bean setupper.}
     * @param crawlingSessionList The entity list of crawlingSession. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     */
    public void loadCrawlingSessionInfoList(
            final List<CrawlingSession> crawlingSessionList,
            final LoadReferrerOption<CrawlingSessionInfoCB, CrawlingSessionInfo> loadReferrerOption) {
        xassLRArg(crawlingSessionList, loadReferrerOption);
        if (crawlingSessionList.isEmpty()) {
            return;
        }
        final CrawlingSessionInfoBhv referrerBhv = xgetBSFLR().select(
                CrawlingSessionInfoBhv.class);
        helpLoadReferrerInternally(
                crawlingSessionList,
                loadReferrerOption,
                new InternalLoadReferrerCallback<CrawlingSession, Long, CrawlingSessionInfoCB, CrawlingSessionInfo>() {
                    @Override
                    public Long getPKVal(final CrawlingSession e) {
                        return e.getId();
                    }

                    @Override
                    public void setRfLs(final CrawlingSession e,
                            final List<CrawlingSessionInfo> ls) {
                        e.setCrawlingSessionInfoList(ls);
                    }

                    @Override
                    public CrawlingSessionInfoCB newMyCB() {
                        return referrerBhv.newMyConditionBean();
                    }

                    @Override
                    public void qyFKIn(final CrawlingSessionInfoCB cb,
                            final List<Long> ls) {
                        cb.query().setCrawlingSessionId_InScope(ls);
                    }

                    @Override
                    public void qyOdFKAsc(final CrawlingSessionInfoCB cb) {
                        cb.query().addOrderBy_CrawlingSessionId_Asc();
                    }

                    @Override
                    public void spFKCol(final CrawlingSessionInfoCB cb) {
                        cb.specify().columnCrawlingSessionId();
                    }

                    @Override
                    public List<CrawlingSessionInfo> selRfLs(
                            final CrawlingSessionInfoCB cb) {
                        return referrerBhv.selectList(cb);
                    }

                    @Override
                    public Long getFKVal(final CrawlingSessionInfo e) {
                        return e.getCrawlingSessionId();
                    }

                    @Override
                    public void setlcEt(final CrawlingSessionInfo re,
                            final CrawlingSession le) {
                        re.setCrawlingSession(le);
                    }

                    @Override
                    public String getRfPrNm() {
                        return "crawlingSessionInfoList";
                    }
                });
    }

    // ===================================================================================
    //                                                                   Pull out Relation
    //                                                                   =================

    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key id.
     * @param crawlingSessionList The list of crawlingSession. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Long> extractIdList(
            final List<CrawlingSession> crawlingSessionList) {
        return helpExtractListInternally(crawlingSessionList,
                new InternalExtractCallback<CrawlingSession, Long>() {
                    @Override
                    public Long getCV(final CrawlingSession e) {
                        return e.getId();
                    }
                });
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity. (DefaultConstraintsEnabled)
     * <pre>
     * CrawlingSession crawlingSession = new CrawlingSession();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * crawlingSession.setFoo...(value);
     * crawlingSession.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//crawlingSession.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//crawlingSession.set...;</span>
     * crawlingSessionBhv.<span style="color: #FD4747">insert</span>(crawlingSession);
     * ... = crawlingSession.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param crawlingSession The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(final CrawlingSession crawlingSession) {
        doInsert(crawlingSession, null);
    }

    protected void doInsert(final CrawlingSession crawlingSession,
            final InsertOption<CrawlingSessionCB> option) {
        assertObjectNotNull("crawlingSession", crawlingSession);
        prepareInsertOption(option);
        delegateInsert(crawlingSession, option);
    }

    protected void prepareInsertOption(
            final InsertOption<CrawlingSessionCB> option) {
        if (option == null) {
            return;
        }
        assertInsertOptionStatus(option);
    }

    @Override
    protected void doCreate(final Entity entity,
            final InsertOption<? extends ConditionBean> option) {
        if (option == null) {
            insert(downcast(entity));
        } else {
            varyingInsert(downcast(entity), downcast(option));
        }
    }

    /**
     * Update the entity modified-only. (ZeroUpdateException, NonExclusiveControl)
     * <pre>
     * CrawlingSession crawlingSession = new CrawlingSession();
     * crawlingSession.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * crawlingSession.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//crawlingSession.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//crawlingSession.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * crawlingSession.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     crawlingSessionBhv.<span style="color: #FD4747">update</span>(crawlingSession);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param crawlingSession The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(final CrawlingSession crawlingSession) {
        doUpdate(crawlingSession, null);
    }

    protected void doUpdate(final CrawlingSession crawlingSession,
            final UpdateOption<CrawlingSessionCB> option) {
        assertObjectNotNull("crawlingSession", crawlingSession);
        prepareUpdateOption(option);
        helpUpdateInternally(crawlingSession,
                new InternalUpdateCallback<CrawlingSession>() {
                    @Override
                    public int callbackDelegateUpdate(
                            final CrawlingSession entity) {
                        return delegateUpdate(entity, option);
                    }
                });
    }

    protected void prepareUpdateOption(
            final UpdateOption<CrawlingSessionCB> option) {
        if (option == null) {
            return;
        }
        assertUpdateOptionStatus(option);
        if (option.hasSelfSpecification()) {
            option.resolveSelfSpecification(createCBForVaryingUpdate());
        }
        if (option.hasSpecifiedUpdateColumn()) {
            option.resolveUpdateColumnSpecification(createCBForSpecifiedUpdate());
        }
    }

    protected CrawlingSessionCB createCBForVaryingUpdate() {
        final CrawlingSessionCB cb = newMyConditionBean();
        cb.xsetupForVaryingUpdate();
        return cb;
    }

    protected CrawlingSessionCB createCBForSpecifiedUpdate() {
        final CrawlingSessionCB cb = newMyConditionBean();
        cb.xsetupForSpecifiedUpdate();
        return cb;
    }

    @Override
    protected void doModify(final Entity entity,
            final UpdateOption<? extends ConditionBean> option) {
        if (option == null) {
            update(downcast(entity));
        } else {
            varyingUpdate(downcast(entity), downcast(option));
        }
    }

    @Override
    protected void doModifyNonstrict(final Entity entity,
            final UpdateOption<? extends ConditionBean> option) {
        doModify(entity, option);
    }

    /**
     * Insert or update the entity modified-only. (DefaultConstraintsEnabled, NonExclusiveControl) <br />
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() } <br />
     * <p><span style="color: #FD4747; font-size: 120%">Attention, you cannot update by unique keys instead of PK.</span></p>
     * @param crawlingSession The entity of insert or update target. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(final CrawlingSession crawlingSession) {
        doInesrtOrUpdate(crawlingSession, null, null);
    }

    protected void doInesrtOrUpdate(final CrawlingSession crawlingSession,
            final InsertOption<CrawlingSessionCB> insertOption,
            final UpdateOption<CrawlingSessionCB> updateOption) {
        helpInsertOrUpdateInternally(
                crawlingSession,
                new InternalInsertOrUpdateCallback<CrawlingSession, CrawlingSessionCB>() {
                    @Override
                    public void callbackInsert(final CrawlingSession entity) {
                        doInsert(entity, insertOption);
                    }

                    @Override
                    public void callbackUpdate(final CrawlingSession entity) {
                        doUpdate(entity, updateOption);
                    }

                    @Override
                    public CrawlingSessionCB callbackNewMyConditionBean() {
                        return newMyConditionBean();
                    }

                    @Override
                    public int callbackSelectCount(final CrawlingSessionCB cb) {
                        return selectCount(cb);
                    }
                });
    }

    @Override
    protected void doCreateOrModify(final Entity entity,
            InsertOption<? extends ConditionBean> insertOption,
            UpdateOption<? extends ConditionBean> updateOption) {
        if (insertOption == null && updateOption == null) {
            insertOrUpdate(downcast(entity));
        } else {
            insertOption = insertOption == null ? new InsertOption<CrawlingSessionCB>()
                    : insertOption;
            updateOption = updateOption == null ? new UpdateOption<CrawlingSessionCB>()
                    : updateOption;
            varyingInsertOrUpdate(downcast(entity), downcast(insertOption),
                    downcast(updateOption));
        }
    }

    @Override
    protected void doCreateOrModifyNonstrict(final Entity entity,
            final InsertOption<? extends ConditionBean> insertOption,
            final UpdateOption<? extends ConditionBean> updateOption) {
        doCreateOrModify(entity, insertOption, updateOption);
    }

    /**
     * Delete the entity. (ZeroUpdateException, NonExclusiveControl)
     * <pre>
     * CrawlingSession crawlingSession = new CrawlingSession();
     * crawlingSession.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * crawlingSession.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     crawlingSessionBhv.<span style="color: #FD4747">delete</span>(crawlingSession);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param crawlingSession The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(final CrawlingSession crawlingSession) {
        doDelete(crawlingSession, null);
    }

    protected void doDelete(final CrawlingSession crawlingSession,
            final DeleteOption<CrawlingSessionCB> option) {
        assertObjectNotNull("crawlingSession", crawlingSession);
        prepareDeleteOption(option);
        helpDeleteInternally(crawlingSession,
                new InternalDeleteCallback<CrawlingSession>() {
                    @Override
                    public int callbackDelegateDelete(
                            final CrawlingSession entity) {
                        return delegateDelete(entity, option);
                    }
                });
    }

    protected void prepareDeleteOption(
            final DeleteOption<CrawlingSessionCB> option) {
        if (option == null) {
            return;
        }
        assertDeleteOptionStatus(option);
    }

    @Override
    protected void doRemove(final Entity entity,
            final DeleteOption<? extends ConditionBean> option) {
        if (option == null) {
            delete(downcast(entity));
        } else {
            varyingDelete(downcast(entity), downcast(option));
        }
    }

    @Override
    protected void doRemoveNonstrict(final Entity entity,
            final DeleteOption<? extends ConditionBean> option) {
        doRemove(entity, option);
    }

    // ===================================================================================
    //                                                                        Batch Update
    //                                                                        ============
    /**
     * Batch-insert the entity list. (DefaultConstraintsDisabled) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <p><span style="color: #FD4747; font-size: 120%">Attention, all columns are insert target. (so default constraints are not available)</span></p>
     * And if the table has an identity, entities after the process don't have incremented values.
     * When you use the (normal) insert(), an entity after the process has an incremented value.
     * @param crawlingSessionList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(final List<CrawlingSession> crawlingSessionList) {
        return doBatchInsert(crawlingSessionList, null);
    }

    protected int[] doBatchInsert(
            final List<CrawlingSession> crawlingSessionList,
            final InsertOption<CrawlingSessionCB> option) {
        assertObjectNotNull("crawlingSessionList", crawlingSessionList);
        prepareInsertOption(option);
        return delegateBatchInsert(crawlingSessionList, option);
    }

    @Override
    protected int[] doLumpCreate(final List<Entity> ls,
            final InsertOption<? extends ConditionBean> option) {
        if (option == null) {
            return batchInsert(downcast(ls));
        } else {
            return varyingBatchInsert(downcast(ls), downcast(option));
        }
    }

    /**
     * Batch-update the entity list. (AllColumnsUpdated, NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <span style="color: #FD4747; font-size: 140%">Attention, all columns are update target. {NOT modified only}</span> <br />
     * So you should the other batchUpdate() (overload) method for performace,
     * which you can specify update columns like this:
     * <pre>
     * crawlingSessionBhv.<span style="color: #FD4747">batchUpdate</span>(crawlingSessionList, new SpecifyQuery<CrawlingSessionCB>() {
     *     public void specify(CrawlingSessionCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #FD4747">columnFooStatusCode()</span>;
     *         cb.specify().<span style="color: #FD4747">columnBarDate()</span>;
     *     }
     * });
     * </pre>
     * @param crawlingSessionList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(final List<CrawlingSession> crawlingSessionList) {
        return doBatchUpdate(crawlingSessionList, null);
    }

    protected int[] doBatchUpdate(
            final List<CrawlingSession> crawlingSessionList,
            final UpdateOption<CrawlingSessionCB> option) {
        assertObjectNotNull("crawlingSessionList", crawlingSessionList);
        prepareBatchUpdateOption(crawlingSessionList, option);
        return delegateBatchUpdate(crawlingSessionList, option);
    }

    protected void prepareBatchUpdateOption(
            final List<CrawlingSession> crawlingSessionList,
            final UpdateOption<CrawlingSessionCB> option) {
        if (option == null) {
            return;
        }
        prepareUpdateOption(option);
        // under review
        //if (option.hasSpecifiedUpdateColumn()) {
        //    option.xgatherUpdateColumnModifiedProperties(crawlingSessionList);
        //}
    }

    @Override
    protected int[] doLumpModify(final List<Entity> ls,
            final UpdateOption<? extends ConditionBean> option) {
        if (option == null) {
            return batchUpdate(downcast(ls));
        } else {
            return varyingBatchUpdate(downcast(ls), downcast(option));
        }
    }

    /**
     * Batch-update the entity list. (SpecifiedColumnsUpdated, NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <pre>
     * <span style="color: #3F7E5E">// e.g. update two columns only</span>
     * crawlingSessionBhv.<span style="color: #FD4747">batchUpdate</span>(crawlingSessionList, new SpecifyQuery<CrawlingSessionCB>() {
     *     public void specify(CrawlingSessionCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #FD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #FD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span>
     * crawlingSessionBhv.<span style="color: #FD4747">batchUpdate</span>(crawlingSessionList, new SpecifyQuery<CrawlingSessionCB>() {
     *     public void specify(CrawlingSessionCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #FD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).
     * But if you specify every column, it has no check.</p>
     * @param crawlingSessionList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(final List<CrawlingSession> crawlingSessionList,
            final SpecifyQuery<CrawlingSessionCB> updateColumnSpec) {
        return doBatchUpdate(crawlingSessionList,
                createSpecifiedUpdateOption(updateColumnSpec));
    }

    @Override
    protected int[] doLumpModifyNonstrict(final List<Entity> ls,
            final UpdateOption<? extends ConditionBean> option) {
        return doLumpModify(ls, option);
    }

    /**
     * Batch-delete the entity list. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param crawlingSessionList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDelete(final List<CrawlingSession> crawlingSessionList) {
        return doBatchDelete(crawlingSessionList, null);
    }

    protected int[] doBatchDelete(
            final List<CrawlingSession> crawlingSessionList,
            final DeleteOption<CrawlingSessionCB> option) {
        assertObjectNotNull("crawlingSessionList", crawlingSessionList);
        prepareDeleteOption(option);
        return delegateBatchDelete(crawlingSessionList, option);
    }

    @Override
    protected int[] doLumpRemove(final List<Entity> ls,
            final DeleteOption<? extends ConditionBean> option) {
        if (option == null) {
            return batchDelete(downcast(ls));
        } else {
            return varyingBatchDelete(downcast(ls), downcast(option));
        }
    }

    @Override
    protected int[] doLumpRemoveNonstrict(final List<Entity> ls,
            final DeleteOption<? extends ConditionBean> option) {
        return doLumpRemove(ls, option);
    }

    // ===================================================================================
    //                                                                        Query Update
    //                                                                        ============
    /**
     * Insert the several entities by query (modified-only for fixed value).
     * <pre>
     * crawlingSessionBhv.<span style="color: #FD4747">queryInsert</span>(new QueryInsertSetupper&lt;CrawlingSession, CrawlingSessionCB&gt;() {
     *     public ConditionBean setup(crawlingSession entity, CrawlingSessionCB intoCB) {
     *         FooCB cb = FooCB();
     *         cb.setupSelect_Bar();
     *
     *         <span style="color: #3F7E5E">// mapping</span>
     *         intoCB.specify().columnMyName().mappedFrom(cb.specify().columnFooName());
     *         intoCB.specify().columnMyCount().mappedFrom(cb.specify().columnFooCount());
     *         intoCB.specify().columnMyDate().mappedFrom(cb.specify().specifyBar().columnBarDate());
     *         entity.setMyFixedValue("foo"); <span style="color: #3F7E5E">// fixed value</span>
     *         <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     *         <span style="color: #3F7E5E">//entity.setRegisterUser(value);</span>
     *         <span style="color: #3F7E5E">//entity.set...;</span>
     *         <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     *         <span style="color: #3F7E5E">//entity.setVersionNo(value);</span>
     *
     *         return cb;
     *     }
     * });
     * </pre>
     * @param setupper The setup-per of query-insert. (NotNull)
     * @return The inserted count.
     */
    public int queryInsert(
            final QueryInsertSetupper<CrawlingSession, CrawlingSessionCB> setupper) {
        return doQueryInsert(setupper, null);
    }

    protected int doQueryInsert(
            final QueryInsertSetupper<CrawlingSession, CrawlingSessionCB> setupper,
            final InsertOption<CrawlingSessionCB> option) {
        assertObjectNotNull("setupper", setupper);
        prepareInsertOption(option);
        final CrawlingSession entity = new CrawlingSession();
        final CrawlingSessionCB intoCB = createCBForQueryInsert();
        final ConditionBean resourceCB = setupper.setup(entity, intoCB);
        return delegateQueryInsert(entity, intoCB, resourceCB, option);
    }

    protected CrawlingSessionCB createCBForQueryInsert() {
        final CrawlingSessionCB cb = newMyConditionBean();
        cb.xsetupForQueryInsert();
        return cb;
    }

    @Override
    protected int doRangeCreate(
            final QueryInsertSetupper<? extends Entity, ? extends ConditionBean> setupper,
            final InsertOption<? extends ConditionBean> option) {
        if (option == null) {
            return queryInsert(downcast(setupper));
        } else {
            return varyingQueryInsert(downcast(setupper), downcast(option));
        }
    }

    /**
     * Update the several entities by query non-strictly modified-only. (NonExclusiveControl)
     * <pre>
     * CrawlingSession crawlingSession = new CrawlingSession();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//crawlingSession.setPK...(value);</span>
     * crawlingSession.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//crawlingSession.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//crawlingSession.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//crawlingSession.setVersionNo(value);</span>
     * CrawlingSessionCB cb = new CrawlingSessionCB();
     * cb.query().setFoo...(value);
     * crawlingSessionBhv.<span style="color: #FD4747">queryUpdate</span>(crawlingSession, cb);
     * </pre>
     * @param crawlingSession The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of CrawlingSession. (NotNull)
     * @return The updated count.
     * @exception org.seasar.dbflute.exception.NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(final CrawlingSession crawlingSession,
            final CrawlingSessionCB cb) {
        return doQueryUpdate(crawlingSession, cb, null);
    }

    protected int doQueryUpdate(final CrawlingSession crawlingSession,
            final CrawlingSessionCB cb,
            final UpdateOption<CrawlingSessionCB> option) {
        assertObjectNotNull("crawlingSession", crawlingSession);
        assertCBStateValid(cb);
        prepareUpdateOption(option);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryUpdate(
                crawlingSession, cb, option) : 0;
    }

    @Override
    protected int doRangeModify(final Entity entity, final ConditionBean cb,
            final UpdateOption<? extends ConditionBean> option) {
        if (option == null) {
            return queryUpdate(downcast(entity), (CrawlingSessionCB) cb);
        } else {
            return varyingQueryUpdate(downcast(entity), (CrawlingSessionCB) cb,
                    downcast(option));
        }
    }

    /**
     * Delete the several entities by query. (NonExclusiveControl)
     * <pre>
     * CrawlingSessionCB cb = new CrawlingSessionCB();
     * cb.query().setFoo...(value);
     * crawlingSessionBhv.<span style="color: #FD4747">queryDelete</span>(crawlingSession, cb);
     * </pre>
     * @param cb The condition-bean of CrawlingSession. (NotNull)
     * @return The deleted count.
     * @exception org.seasar.dbflute.exception.NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(final CrawlingSessionCB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(final CrawlingSessionCB cb,
            final DeleteOption<CrawlingSessionCB> option) {
        assertCBStateValid(cb);
        prepareDeleteOption(option);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryDelete(cb,
                option) : 0;
    }

    @Override
    protected int doRangeRemove(final ConditionBean cb,
            final DeleteOption<? extends ConditionBean> option) {
        if (option == null) {
            return queryDelete((CrawlingSessionCB) cb);
        } else {
            return varyingQueryDelete((CrawlingSessionCB) cb, downcast(option));
        }
    }

    // ===================================================================================
    //                                                                      Varying Update
    //                                                                      ==============
    // -----------------------------------------------------
    //                                         Entity Update
    //                                         -------------
    /**
     * Insert the entity with varying requests. <br />
     * For example, disableCommonColumnAutoSetup(), disablePrimaryKeyIdentity(). <br />
     * Other specifications are same as insert(entity).
     * <pre>
     * CrawlingSession crawlingSession = new CrawlingSession();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * crawlingSession.setFoo...(value);
     * crawlingSession.setBar...(value);
     * InsertOption<CrawlingSessionCB> option = new InsertOption<CrawlingSessionCB>();
     * <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     * option.disableCommonColumnAutoSetup();
     * crawlingSessionBhv.<span style="color: #FD4747">varyingInsert</span>(crawlingSession, option);
     * ... = crawlingSession.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param crawlingSession The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(final CrawlingSession crawlingSession,
            final InsertOption<CrawlingSessionCB> option) {
        assertInsertOptionNotNull(option);
        doInsert(crawlingSession, option);
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, NonExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as update(entity).
     * <pre>
     * CrawlingSession crawlingSession = new CrawlingSession();
     * crawlingSession.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * crawlingSession.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * crawlingSession.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;CrawlingSessionCB&gt; option = new UpdateOption&lt;CrawlingSessionCB&gt;();
     *     option.self(new SpecifyQuery&lt;CrawlingSessionCB&gt;() {
     *         public void specify(CrawlingSessionCB cb) {
     *             cb.specify().<span style="color: #FD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     crawlingSessionBhv.<span style="color: #FD4747">varyingUpdate</span>(crawlingSession, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param crawlingSession The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(final CrawlingSession crawlingSession,
            final UpdateOption<CrawlingSessionCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdate(crawlingSession, option);
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdate(entity).
     * @param crawlingSession The entity of insert or update target. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(final CrawlingSession crawlingSession,
            final InsertOption<CrawlingSessionCB> insertOption,
            final UpdateOption<CrawlingSessionCB> updateOption) {
        assertInsertOptionNotNull(insertOption);
        assertUpdateOptionNotNull(updateOption);
        doInesrtOrUpdate(crawlingSession, insertOption, updateOption);
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, NonExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as delete(entity).
     * @param crawlingSession The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(final CrawlingSession crawlingSession,
            final DeleteOption<CrawlingSessionCB> option) {
        assertDeleteOptionNotNull(option);
        doDelete(crawlingSession, option);
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br />
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br />
     * Other specifications are same as batchInsert(entityList).
     * @param crawlingSessionList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(
            final List<CrawlingSession> crawlingSessionList,
            final InsertOption<CrawlingSessionCB> option) {
        assertInsertOptionNotNull(option);
        return doBatchInsert(crawlingSessionList, option);
    }

    /**
     * Batch-update the list with varying requests. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdate(entityList).
     * @param crawlingSessionList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(
            final List<CrawlingSession> crawlingSessionList,
            final UpdateOption<CrawlingSessionCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdate(crawlingSessionList, option);
    }

    /**
     * Batch-delete the list with varying requests. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDelete(entityList).
     * @param crawlingSessionList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(
            final List<CrawlingSession> crawlingSessionList,
            final DeleteOption<CrawlingSessionCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDelete(crawlingSessionList, option);
    }

    // -----------------------------------------------------
    //                                          Query Update
    //                                          ------------
    /**
     * Insert the several entities by query with varying requests (modified-only for fixed value). <br />
     * For example, disableCommonColumnAutoSetup(), disablePrimaryKeyIdentity(). <br />
     * Other specifications are same as queryInsert(entity, setupper).
     * @param setupper The setup-per of query-insert. (NotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The inserted count.
     */
    public int varyingQueryInsert(
            final QueryInsertSetupper<CrawlingSession, CrawlingSessionCB> setupper,
            final InsertOption<CrawlingSessionCB> option) {
        assertInsertOptionNotNull(option);
        return doQueryInsert(setupper, option);
    }

    /**
     * Update the several entities by query with varying requests non-strictly modified-only. {NonExclusiveControl} <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), allowNonQueryUpdate(). <br />
     * Other specifications are same as queryUpdate(entity, cb).
     * <pre>
     * <span style="color: #3F7E5E">// ex) you can update by self calculation values</span>
     * CrawlingSession crawlingSession = new CrawlingSession();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//crawlingSession.setPK...(value);</span>
     * crawlingSession.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//crawlingSession.setVersionNo(value);</span>
     * CrawlingSessionCB cb = new CrawlingSessionCB();
     * cb.query().setFoo...(value);
     * UpdateOption&lt;CrawlingSessionCB&gt; option = new UpdateOption&lt;CrawlingSessionCB&gt;();
     * option.self(new SpecifyQuery&lt;CrawlingSessionCB&gt;() {
     *     public void specify(CrawlingSessionCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * crawlingSessionBhv.<span style="color: #FD4747">varyingQueryUpdate</span>(crawlingSession, cb, option);
     * </pre>
     * @param crawlingSession The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of CrawlingSession. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception org.seasar.dbflute.exception.NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(final CrawlingSession crawlingSession,
            final CrawlingSessionCB cb,
            final UpdateOption<CrawlingSessionCB> option) {
        assertUpdateOptionNotNull(option);
        return doQueryUpdate(crawlingSession, cb, option);
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br />
     * For example, allowNonQueryDelete(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param cb The condition-bean of CrawlingSession. (NotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @exception org.seasar.dbflute.exception.NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(final CrawlingSessionCB cb,
            final DeleteOption<CrawlingSessionCB> option) {
        assertDeleteOptionNotNull(option);
        return doQueryDelete(cb, option);
    }

    // ===================================================================================
    //                                                                          OutsideSql
    //                                                                          ==========
    /**
     * Prepare the basic executor of outside-SQL to execute it. <br />
     * The invoker of behavior command should be not null when you call this method.
     * <pre>
     * You can use the methods for outside-SQL are as follows:
     * {Basic}
     *   o selectList()
     *   o execute()
     *   o call()
     *
     * {Entity}
     *   o entityHandling().selectEntity()
     *   o entityHandling().selectEntityWithDeletedCheck()
     *
     * {Paging}
     *   o autoPaging().selectList()
     *   o autoPaging().selectPage()
     *   o manualPaging().selectList()
     *   o manualPaging().selectPage()
     *
     * {Cursor}
     *   o cursorHandling().selectCursor()
     *
     * {Option}
     *   o dynamicBinding().selectList()
     *   o removeBlockComment().selectList()
     *   o removeLineComment().selectList()
     *   o formatSql().selectList()
     * </pre>
     * @return The basic executor of outside-SQL. (NotNull)
     */
    public OutsideSqlBasicExecutor<CrawlingSessionBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                     Delegate Method
    //                                                                     ===============
    // [Behavior Command]
    // -----------------------------------------------------
    //                                                Select
    //                                                ------
    protected int delegateSelectCountUniquely(final CrawlingSessionCB cb) {
        return invoke(createSelectCountCBCommand(cb, true));
    }

    protected int delegateSelectCountPlainly(final CrawlingSessionCB cb) {
        return invoke(createSelectCountCBCommand(cb, false));
    }

    protected <ENTITY extends CrawlingSession> void delegateSelectCursor(
            final CrawlingSessionCB cb, final EntityRowHandler<ENTITY> erh,
            final Class<ENTITY> et) {
        invoke(createSelectCursorCBCommand(cb, erh, et));
    }

    protected <ENTITY extends CrawlingSession> List<ENTITY> delegateSelectList(
            final CrawlingSessionCB cb, final Class<ENTITY> et) {
        return invoke(createSelectListCBCommand(cb, et));
    }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(final CrawlingSession e,
            final InsertOption<CrawlingSessionCB> op) {
        if (!processBeforeInsert(e, op)) {
            return 0;
        }
        return invoke(createInsertEntityCommand(e, op));
    }

    protected int delegateUpdate(final CrawlingSession e,
            final UpdateOption<CrawlingSessionCB> op) {
        if (!processBeforeUpdate(e, op)) {
            return 0;
        }
        return delegateUpdateNonstrict(e, op);
    }

    protected int delegateUpdateNonstrict(final CrawlingSession e,
            final UpdateOption<CrawlingSessionCB> op) {
        if (!processBeforeUpdate(e, op)) {
            return 0;
        }
        return invoke(createUpdateNonstrictEntityCommand(e, op));
    }

    protected int delegateDelete(final CrawlingSession e,
            final DeleteOption<CrawlingSessionCB> op) {
        if (!processBeforeDelete(e, op)) {
            return 0;
        }
        return delegateDeleteNonstrict(e, op);
    }

    protected int delegateDeleteNonstrict(final CrawlingSession e,
            final DeleteOption<CrawlingSessionCB> op) {
        if (!processBeforeDelete(e, op)) {
            return 0;
        }
        return invoke(createDeleteNonstrictEntityCommand(e, op));
    }

    protected int[] delegateBatchInsert(final List<CrawlingSession> ls,
            final InsertOption<CrawlingSessionCB> op) {
        if (ls.isEmpty()) {
            return new int[] {};
        }
        return invoke(createBatchInsertCommand(processBatchInternally(ls, op),
                op));
    }

    protected int[] delegateBatchUpdate(final List<CrawlingSession> ls,
            final UpdateOption<CrawlingSessionCB> op) {
        if (ls.isEmpty()) {
            return new int[] {};
        }
        return delegateBatchUpdateNonstrict(ls, op);
    }

    protected int[] delegateBatchUpdateNonstrict(
            final List<CrawlingSession> ls,
            final UpdateOption<CrawlingSessionCB> op) {
        if (ls.isEmpty()) {
            return new int[] {};
        }
        return invoke(createBatchUpdateNonstrictCommand(
                processBatchInternally(ls, op, true), op));
    }

    protected int[] delegateBatchDelete(final List<CrawlingSession> ls,
            final DeleteOption<CrawlingSessionCB> op) {
        if (ls.isEmpty()) {
            return new int[] {};
        }
        return delegateBatchDeleteNonstrict(ls, op);
    }

    protected int[] delegateBatchDeleteNonstrict(
            final List<CrawlingSession> ls,
            final DeleteOption<CrawlingSessionCB> op) {
        if (ls.isEmpty()) {
            return new int[] {};
        }
        return invoke(createBatchDeleteNonstrictCommand(
                processBatchInternally(ls, op, true), op));
    }

    protected int delegateQueryInsert(final CrawlingSession e,
            final CrawlingSessionCB inCB, final ConditionBean resCB,
            final InsertOption<CrawlingSessionCB> op) {
        if (!processBeforeQueryInsert(e, inCB, resCB, op)) {
            return 0;
        }
        return invoke(createQueryInsertCBCommand(e, inCB, resCB, op));
    }

    protected int delegateQueryUpdate(final CrawlingSession e,
            final CrawlingSessionCB cb, final UpdateOption<CrawlingSessionCB> op) {
        if (!processBeforeQueryUpdate(e, cb, op)) {
            return 0;
        }
        return invoke(createQueryUpdateCBCommand(e, cb, op));
    }

    protected int delegateQueryDelete(final CrawlingSessionCB cb,
            final DeleteOption<CrawlingSessionCB> op) {
        if (!processBeforeQueryDelete(cb, op)) {
            return 0;
        }
        return invoke(createQueryDeleteCBCommand(cb, op));
    }

    // ===================================================================================
    //                                                                Optimistic Lock Info
    //                                                                ====================
    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean hasVersionNoValue(final Entity entity) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean hasUpdateDateValue(final Entity entity) {
        return false;
    }

    // ===================================================================================
    //                                                                     Downcast Helper
    //                                                                     ===============
    protected CrawlingSession downcast(final Entity entity) {
        return helpEntityDowncastInternally(entity, CrawlingSession.class);
    }

    protected CrawlingSessionCB downcast(final ConditionBean cb) {
        return helpConditionBeanDowncastInternally(cb, CrawlingSessionCB.class);
    }

    @SuppressWarnings("unchecked")
    protected List<CrawlingSession> downcast(
            final List<? extends Entity> entityList) {
        return (List<CrawlingSession>) entityList;
    }

    @SuppressWarnings("unchecked")
    protected InsertOption<CrawlingSessionCB> downcast(
            final InsertOption<? extends ConditionBean> option) {
        return (InsertOption<CrawlingSessionCB>) option;
    }

    @SuppressWarnings("unchecked")
    protected UpdateOption<CrawlingSessionCB> downcast(
            final UpdateOption<? extends ConditionBean> option) {
        return (UpdateOption<CrawlingSessionCB>) option;
    }

    @SuppressWarnings("unchecked")
    protected DeleteOption<CrawlingSessionCB> downcast(
            final DeleteOption<? extends ConditionBean> option) {
        return (DeleteOption<CrawlingSessionCB>) option;
    }

    @SuppressWarnings("unchecked")
    protected QueryInsertSetupper<CrawlingSession, CrawlingSessionCB> downcast(
            final QueryInsertSetupper<? extends Entity, ? extends ConditionBean> option) {
        return (QueryInsertSetupper<CrawlingSession, CrawlingSessionCB>) option;
    }
}
