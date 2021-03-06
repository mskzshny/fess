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

package jp.sf.fess.db.cbean.cq.bs;

import java.util.Collection;

import jp.sf.fess.db.allcommon.DBMetaInstanceHandler;
import jp.sf.fess.db.cbean.SearchFieldLogCB;
import jp.sf.fess.db.cbean.SearchLogCB;
import jp.sf.fess.db.cbean.cq.SearchFieldLogCQ;
import jp.sf.fess.db.cbean.cq.SearchLogCQ;

import org.seasar.dbflute.cbean.AbstractConditionQuery;
import org.seasar.dbflute.cbean.ConditionQuery;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.chelper.HpQDRFunction;
import org.seasar.dbflute.cbean.chelper.HpQDRSetupper;
import org.seasar.dbflute.cbean.chelper.HpSSQFunction;
import org.seasar.dbflute.cbean.chelper.HpSSQOption;
import org.seasar.dbflute.cbean.chelper.HpSSQSetupper;
import org.seasar.dbflute.cbean.ckey.ConditionKey;
import org.seasar.dbflute.cbean.coption.DerivedReferrerOption;
import org.seasar.dbflute.cbean.coption.LikeSearchOption;
import org.seasar.dbflute.cbean.coption.RangeOfOption;
import org.seasar.dbflute.cbean.cvalue.ConditionValue;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.dbflute.dbmeta.DBMetaProvider;

/**
 * The abstract condition-query of SEARCH_FIELD_LOG.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsSearchFieldLogCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsSearchFieldLogCQ(final ConditionQuery childQuery,
            final SqlClause sqlClause, final String aliasName,
            final int nestLevel) {
        super(childQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                     DBMeta Provider
    //                                                                     ===============
    @Override
    protected DBMetaProvider xgetDBMetaProvider() {
        return DBMetaInstanceHandler.getProvider();
    }

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    @Override
    public String getTableDbName() {
        return "SEARCH_FIELD_LOG";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param id The value of id as equal. (NullAllowed: if null, no condition)
     */
    public void setId_Equal(final Long id) {
        doSetId_Equal(id);
    }

    protected void doSetId_Equal(final Long id) {
        regId(CK_EQ, id);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param id The value of id as notEqual. (NullAllowed: if null, no condition)
     */
    public void setId_NotEqual(final Long id) {
        doSetId_NotEqual(id);
    }

    protected void doSetId_NotEqual(final Long id) {
        regId(CK_NES, id);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param id The value of id as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setId_GreaterThan(final Long id) {
        regId(CK_GT, id);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param id The value of id as lessThan. (NullAllowed: if null, no condition)
     */
    public void setId_LessThan(final Long id) {
        regId(CK_LT, id);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param id The value of id as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setId_GreaterEqual(final Long id) {
        regId(CK_GE, id);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param id The value of id as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setId_LessEqual(final Long id) {
        regId(CK_LE, id);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param minNumber The min number of id. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of id. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setId_RangeOf(final Long minNumber, final Long maxNumber,
            final RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueId(), "ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param idList The collection of id as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setId_InScope(final Collection<Long> idList) {
        doSetId_InScope(idList);
    }

    protected void doSetId_InScope(final Collection<Long> idList) {
        regINS(CK_INS, cTL(idList), getCValueId(), "ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param idList The collection of id as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setId_NotInScope(final Collection<Long> idList) {
        doSetId_NotInScope(idList);
    }

    protected void doSetId_NotInScope(final Collection<Long> idList) {
        regINS(CK_NINS, cTL(idList), getCValueId(), "ID");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     */
    public void setId_IsNull() {
        regId(CK_ISN, DOBJ);
    }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     */
    public void setId_IsNotNull() {
        regId(CK_ISNN, DOBJ);
    }

    protected void regId(final ConditionKey k, final Object v) {
        regQ(k, v, getCValueId(), "ID");
    }

    abstract protected ConditionValue getCValueId();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * SEARCH_ID: {IX, NotNull, BIGINT(19), FK to SEARCH_LOG}
     * @param searchId The value of searchId as equal. (NullAllowed: if null, no condition)
     */
    public void setSearchId_Equal(final Long searchId) {
        doSetSearchId_Equal(searchId);
    }

    protected void doSetSearchId_Equal(final Long searchId) {
        regSearchId(CK_EQ, searchId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * SEARCH_ID: {IX, NotNull, BIGINT(19), FK to SEARCH_LOG}
     * @param searchId The value of searchId as notEqual. (NullAllowed: if null, no condition)
     */
    public void setSearchId_NotEqual(final Long searchId) {
        doSetSearchId_NotEqual(searchId);
    }

    protected void doSetSearchId_NotEqual(final Long searchId) {
        regSearchId(CK_NES, searchId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * SEARCH_ID: {IX, NotNull, BIGINT(19), FK to SEARCH_LOG}
     * @param searchId The value of searchId as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setSearchId_GreaterThan(final Long searchId) {
        regSearchId(CK_GT, searchId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * SEARCH_ID: {IX, NotNull, BIGINT(19), FK to SEARCH_LOG}
     * @param searchId The value of searchId as lessThan. (NullAllowed: if null, no condition)
     */
    public void setSearchId_LessThan(final Long searchId) {
        regSearchId(CK_LT, searchId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * SEARCH_ID: {IX, NotNull, BIGINT(19), FK to SEARCH_LOG}
     * @param searchId The value of searchId as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setSearchId_GreaterEqual(final Long searchId) {
        regSearchId(CK_GE, searchId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * SEARCH_ID: {IX, NotNull, BIGINT(19), FK to SEARCH_LOG}
     * @param searchId The value of searchId as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setSearchId_LessEqual(final Long searchId) {
        regSearchId(CK_LE, searchId);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * SEARCH_ID: {IX, NotNull, BIGINT(19), FK to SEARCH_LOG}
     * @param minNumber The min number of searchId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of searchId. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setSearchId_RangeOf(final Long minNumber, final Long maxNumber,
            final RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueSearchId(), "SEARCH_ID",
                rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * SEARCH_ID: {IX, NotNull, BIGINT(19), FK to SEARCH_LOG}
     * @param searchIdList The collection of searchId as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setSearchId_InScope(final Collection<Long> searchIdList) {
        doSetSearchId_InScope(searchIdList);
    }

    protected void doSetSearchId_InScope(final Collection<Long> searchIdList) {
        regINS(CK_INS, cTL(searchIdList), getCValueSearchId(), "SEARCH_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * SEARCH_ID: {IX, NotNull, BIGINT(19), FK to SEARCH_LOG}
     * @param searchIdList The collection of searchId as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setSearchId_NotInScope(final Collection<Long> searchIdList) {
        doSetSearchId_NotInScope(searchIdList);
    }

    protected void doSetSearchId_NotInScope(final Collection<Long> searchIdList) {
        regINS(CK_NINS, cTL(searchIdList), getCValueSearchId(), "SEARCH_ID");
    }

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select SEARCH_ID from SEARCH_LOG where ...)} <br />
     * SEARCH_LOG by my SEARCH_ID, named 'searchLog'.
     * @param subQuery The sub-query of SearchLog for 'in-scope'. (NotNull)
     */
    public void inScopeSearchLog(final SubQuery<SearchLogCB> subQuery) {
        assertObjectNotNull("subQuery<SearchLogCB>", subQuery);
        final SearchLogCB cb = new SearchLogCB();
        cb.xsetupForInScopeRelation(this);
        subQuery.query(cb);
        final String subQueryPropertyName = keepSearchId_InScopeRelation_SearchLog(cb
                .query()); // for saving query-value.
        registerInScopeRelation(cb.query(), "SEARCH_ID", "ID",
                subQueryPropertyName, "searchLog");
    }

    public abstract String keepSearchId_InScopeRelation_SearchLog(
            SearchLogCQ subQuery);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select SEARCH_ID from SEARCH_LOG where ...)} <br />
     * SEARCH_LOG by my SEARCH_ID, named 'searchLog'.
     * @param subQuery The sub-query of SearchLog for 'not in-scope'. (NotNull)
     */
    public void notInScopeSearchLog(final SubQuery<SearchLogCB> subQuery) {
        assertObjectNotNull("subQuery<SearchLogCB>", subQuery);
        final SearchLogCB cb = new SearchLogCB();
        cb.xsetupForInScopeRelation(this);
        subQuery.query(cb);
        final String subQueryPropertyName = keepSearchId_NotInScopeRelation_SearchLog(cb
                .query()); // for saving query-value.
        registerNotInScopeRelation(cb.query(), "SEARCH_ID", "ID",
                subQueryPropertyName, "searchLog");
    }

    public abstract String keepSearchId_NotInScopeRelation_SearchLog(
            SearchLogCQ subQuery);

    protected void regSearchId(final ConditionKey k, final Object v) {
        regQ(k, v, getCValueSearchId(), "SEARCH_ID");
    }

    abstract protected ConditionValue getCValueSearchId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * NAME: {IX, NotNull, VARCHAR(255)}
     * @param name The value of name as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setName_Equal(final String name) {
        doSetName_Equal(fRES(name));
    }

    protected void doSetName_Equal(final String name) {
        regName(CK_EQ, name);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * NAME: {IX, NotNull, VARCHAR(255)}
     * @param name The value of name as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setName_NotEqual(final String name) {
        doSetName_NotEqual(fRES(name));
    }

    protected void doSetName_NotEqual(final String name) {
        regName(CK_NES, name);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * NAME: {IX, NotNull, VARCHAR(255)}
     * @param name The value of name as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setName_GreaterThan(final String name) {
        regName(CK_GT, fRES(name));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * NAME: {IX, NotNull, VARCHAR(255)}
     * @param name The value of name as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setName_LessThan(final String name) {
        regName(CK_LT, fRES(name));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * NAME: {IX, NotNull, VARCHAR(255)}
     * @param name The value of name as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setName_GreaterEqual(final String name) {
        regName(CK_GE, fRES(name));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * NAME: {IX, NotNull, VARCHAR(255)}
     * @param name The value of name as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setName_LessEqual(final String name) {
        regName(CK_LE, fRES(name));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * NAME: {IX, NotNull, VARCHAR(255)}
     * @param nameList The collection of name as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setName_InScope(final Collection<String> nameList) {
        doSetName_InScope(nameList);
    }

    public void doSetName_InScope(final Collection<String> nameList) {
        regINS(CK_INS, cTL(nameList), getCValueName(), "NAME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * NAME: {IX, NotNull, VARCHAR(255)}
     * @param nameList The collection of name as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setName_NotInScope(final Collection<String> nameList) {
        doSetName_NotInScope(nameList);
    }

    public void doSetName_NotInScope(final Collection<String> nameList) {
        regINS(CK_NINS, cTL(nameList), getCValueName(), "NAME");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * NAME: {IX, NotNull, VARCHAR(255)}
     * @param name The value of name as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setName_PrefixSearch(final String name) {
        setName_LikeSearch(name, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * NAME: {IX, NotNull, VARCHAR(255)} <br />
     * <pre>e.g. setName_LikeSearch("xxx", new <span style="color: #FD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param name The value of name as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setName_LikeSearch(final String name,
            final LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(name), getCValueName(), "NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * NAME: {IX, NotNull, VARCHAR(255)}
     * @param name The value of name as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setName_NotLikeSearch(final String name,
            final LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(name), getCValueName(), "NAME", likeSearchOption);
    }

    protected void regName(final ConditionKey k, final Object v) {
        regQ(k, v, getCValueName(), "NAME");
    }

    abstract protected ConditionValue getCValueName();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * VALUE: {NotNull, VARCHAR(1000)}
     * @param value The value of value as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setValue_Equal(final String value) {
        doSetValue_Equal(fRES(value));
    }

    protected void doSetValue_Equal(final String value) {
        regValue(CK_EQ, value);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * VALUE: {NotNull, VARCHAR(1000)}
     * @param value The value of value as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setValue_NotEqual(final String value) {
        doSetValue_NotEqual(fRES(value));
    }

    protected void doSetValue_NotEqual(final String value) {
        regValue(CK_NES, value);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * VALUE: {NotNull, VARCHAR(1000)}
     * @param value The value of value as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setValue_GreaterThan(final String value) {
        regValue(CK_GT, fRES(value));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * VALUE: {NotNull, VARCHAR(1000)}
     * @param value The value of value as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setValue_LessThan(final String value) {
        regValue(CK_LT, fRES(value));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * VALUE: {NotNull, VARCHAR(1000)}
     * @param value The value of value as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setValue_GreaterEqual(final String value) {
        regValue(CK_GE, fRES(value));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * VALUE: {NotNull, VARCHAR(1000)}
     * @param value The value of value as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setValue_LessEqual(final String value) {
        regValue(CK_LE, fRES(value));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * VALUE: {NotNull, VARCHAR(1000)}
     * @param valueList The collection of value as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setValue_InScope(final Collection<String> valueList) {
        doSetValue_InScope(valueList);
    }

    public void doSetValue_InScope(final Collection<String> valueList) {
        regINS(CK_INS, cTL(valueList), getCValueValue(), "VALUE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * VALUE: {NotNull, VARCHAR(1000)}
     * @param valueList The collection of value as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setValue_NotInScope(final Collection<String> valueList) {
        doSetValue_NotInScope(valueList);
    }

    public void doSetValue_NotInScope(final Collection<String> valueList) {
        regINS(CK_NINS, cTL(valueList), getCValueValue(), "VALUE");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * VALUE: {NotNull, VARCHAR(1000)}
     * @param value The value of value as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setValue_PrefixSearch(final String value) {
        setValue_LikeSearch(value, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * VALUE: {NotNull, VARCHAR(1000)} <br />
     * <pre>e.g. setValue_LikeSearch("xxx", new <span style="color: #FD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param value The value of value as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setValue_LikeSearch(final String value,
            final LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(value), getCValueValue(), "VALUE", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * VALUE: {NotNull, VARCHAR(1000)}
     * @param value The value of value as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setValue_NotLikeSearch(final String value,
            final LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(value), getCValueValue(), "VALUE", likeSearchOption);
    }

    protected void regValue(final ConditionKey k, final Object v) {
        regQ(k, v, getCValueValue(), "VALUE");
    }

    abstract protected ConditionValue getCValueValue();

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO = (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_Equal()</span>.max(new SubQuery&lt;SearchFieldLogCB&gt;() {
     *     public void query(SearchFieldLogCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<SearchFieldLogCB> scalar_Equal() {
        return xcreateSSQFunction(CK_EQ.getOperand());
    }

    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO &lt;&gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_NotEqual()</span>.max(new SubQuery&lt;SearchFieldLogCB&gt;() {
     *     public void query(SearchFieldLogCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<SearchFieldLogCB> scalar_NotEqual() {
        return xcreateSSQFunction(CK_NES.getOperand());
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br />
     * {where FOO &gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_GreaterThan()</span>.max(new SubQuery&lt;SearchFieldLogCB&gt;() {
     *     public void query(SearchFieldLogCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<SearchFieldLogCB> scalar_GreaterThan() {
        return xcreateSSQFunction(CK_GT.getOperand());
    }

    /**
     * Prepare ScalarCondition as lessThan. <br />
     * {where FOO &lt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_LessThan()</span>.max(new SubQuery&lt;SearchFieldLogCB&gt;() {
     *     public void query(SearchFieldLogCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<SearchFieldLogCB> scalar_LessThan() {
        return xcreateSSQFunction(CK_LT.getOperand());
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br />
     * {where FOO &gt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_GreaterEqual()</span>.max(new SubQuery&lt;SearchFieldLogCB&gt;() {
     *     public void query(SearchFieldLogCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<SearchFieldLogCB> scalar_GreaterEqual() {
        return xcreateSSQFunction(CK_GE.getOperand());
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br />
     * {where FOO &lt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_LessEqual()</span>.max(new SubQuery&lt;SearchFieldLogCB&gt;() {
     *     public void query(SearchFieldLogCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<SearchFieldLogCB> scalar_LessEqual() {
        return xcreateSSQFunction(CK_LE.getOperand());
    }

    protected HpSSQFunction<SearchFieldLogCB> xcreateSSQFunction(
            final String operand) {
        return new HpSSQFunction<SearchFieldLogCB>(
                new HpSSQSetupper<SearchFieldLogCB>() {
                    @Override
                    public void setup(final String function,
                            final SubQuery<SearchFieldLogCB> subQuery,
                            final HpSSQOption<SearchFieldLogCB> option) {
                        xscalarCondition(function, subQuery, operand, option);
                    }
                });
    }

    protected void xscalarCondition(final String function,
            final SubQuery<SearchFieldLogCB> subQuery, final String operand,
            final HpSSQOption<SearchFieldLogCB> option) {
        assertObjectNotNull("subQuery<SearchFieldLogCB>", subQuery);
        final SearchFieldLogCB cb = xcreateScalarConditionCB();
        subQuery.query(cb);
        final String subQueryPropertyName = keepScalarCondition(cb.query()); // for saving query-value
        option.setPartitionByCBean(xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(function, cb.query(), subQueryPropertyName,
                operand, option);
    }

    public abstract String keepScalarCondition(SearchFieldLogCQ subQuery);

    protected SearchFieldLogCB xcreateScalarConditionCB() {
        final SearchFieldLogCB cb = new SearchFieldLogCB();
        cb.xsetupForScalarCondition(this);
        return cb;
    }

    protected SearchFieldLogCB xcreateScalarConditionPartitionByCB() {
        final SearchFieldLogCB cb = new SearchFieldLogCB();
        cb.xsetupForScalarConditionPartitionBy(this);
        return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(final String function,
            final SubQuery<SearchFieldLogCB> subQuery, final String aliasName,
            final DerivedReferrerOption option) {
        assertObjectNotNull("subQuery<SearchFieldLogCB>", subQuery);
        final SearchFieldLogCB cb = new SearchFieldLogCB();
        cb.xsetupForDerivedReferrer(this);
        subQuery.query(cb);
        final String subQueryPropertyName = keepSpecifyMyselfDerived(cb.query()); // for saving query-value.
        registerSpecifyMyselfDerived(function, cb.query(), "ID", "ID",
                subQueryPropertyName, "myselfDerived", aliasName, option);
    }

    public abstract String keepSpecifyMyselfDerived(SearchFieldLogCQ subQuery);

    /**
     * Prepare for (Query)MyselfDerived (SubQuery).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<SearchFieldLogCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived();
    }

    protected HpQDRFunction<SearchFieldLogCB> xcreateQDRFunctionMyselfDerived() {
        return new HpQDRFunction<SearchFieldLogCB>(
                new HpQDRSetupper<SearchFieldLogCB>() {
                    @Override
                    public void setup(final String function,
                            final SubQuery<SearchFieldLogCB> subQuery,
                            final String operand, final Object value,
                            final DerivedReferrerOption option) {
                        xqderiveMyselfDerived(function, subQuery, operand,
                                value, option);
                    }
                });
    }

    public void xqderiveMyselfDerived(final String function,
            final SubQuery<SearchFieldLogCB> subQuery, final String operand,
            final Object value, final DerivedReferrerOption option) {
        assertObjectNotNull("subQuery<SearchFieldLogCB>", subQuery);
        final SearchFieldLogCB cb = new SearchFieldLogCB();
        cb.xsetupForDerivedReferrer(this);
        subQuery.query(cb);
        final String subQueryPropertyName = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        final String parameterPropertyName = keepQueryMyselfDerivedParameter(value);
        registerQueryMyselfDerived(function, cb.query(), "ID", "ID",
                subQueryPropertyName, "myselfDerived", operand, value,
                parameterPropertyName, option);
    }

    public abstract String keepQueryMyselfDerived(SearchFieldLogCQ subQuery);

    public abstract String keepQueryMyselfDerivedParameter(Object parameterValue);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (SubQuery).
     * @param subQuery The implementation of sub query. (NotNull)
     */
    public void myselfExists(final SubQuery<SearchFieldLogCB> subQuery) {
        assertObjectNotNull("subQuery<SearchFieldLogCB>", subQuery);
        final SearchFieldLogCB cb = new SearchFieldLogCB();
        cb.xsetupForMyselfExists(this);
        subQuery.query(cb);
        final String subQueryPropertyName = keepMyselfExists(cb.query()); // for saving query-value.
        registerMyselfExists(cb.query(), subQueryPropertyName);
    }

    public abstract String keepMyselfExists(SearchFieldLogCQ subQuery);

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    /**
     * Prepare for MyselfInScope (SubQuery).
     * @param subQuery The implementation of sub query. (NotNull)
     */
    public void myselfInScope(final SubQuery<SearchFieldLogCB> subQuery) {
        assertObjectNotNull("subQuery<SearchFieldLogCB>", subQuery);
        final SearchFieldLogCB cb = new SearchFieldLogCB();
        cb.xsetupForMyselfInScope(this);
        subQuery.query(cb);
        final String subQueryPropertyName = keepMyselfInScope(cb.query()); // for saving query-value.
        registerMyselfInScope(cb.query(), subQueryPropertyName);
    }

    public abstract String keepMyselfInScope(SearchFieldLogCQ subQuery);

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabCB() {
        return SearchFieldLogCB.class.getName();
    }

    protected String xabCQ() {
        return SearchFieldLogCQ.class.getName();
    }

    protected String xabLSO() {
        return LikeSearchOption.class.getName();
    }

    protected String xabSSQS() {
        return HpSSQSetupper.class.getName();
    }
}
