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

import jp.sf.fess.db.bsentity.dbmeta.OverlappingHostDbm;
import jp.sf.fess.db.cbean.OverlappingHostCB;
import jp.sf.fess.db.exbhv.OverlappingHostBhv;
import jp.sf.fess.db.exentity.OverlappingHost;

import org.seasar.dbflute.Entity;
import org.seasar.dbflute.bhv.AbstractBehaviorWritable;
import org.seasar.dbflute.bhv.DeleteOption;
import org.seasar.dbflute.bhv.InsertOption;
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
 * The behavior of OVERLAPPING_HOST as TABLE. <br />
 * <pre>
 * [primary key]
 *     ID
 *
 * [column]
 *     ID, REGULAR_NAME, OVERLAPPING_NAME, SORT_ORDER, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME, DELETED_BY, DELETED_TIME, VERSION_NO
 *
 * [sequence]
 *
 *
 * [identity]
 *     ID
 *
 * [version-no]
 *     VERSION_NO
 *
 * [foreign table]
 *
 *
 * [referrer table]
 *
 *
 * [foreign property]
 *
 *
 * [referrer property]
 *
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsOverlappingHostBhv extends AbstractBehaviorWritable {

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
        return "OVERLAPPING_HOST";
    }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** @return The instance of DBMeta. (NotNull) */
    @Override
    public DBMeta getDBMeta() {
        return OverlappingHostDbm.getInstance();
    }

    /** @return The instance of DBMeta as my table type. (NotNull) */
    public OverlappingHostDbm getMyDBMeta() {
        return OverlappingHostDbm.getInstance();
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
    public OverlappingHost newMyEntity() {
        return new OverlappingHost();
    }

    /** @return The instance of new condition-bean as my table type. (NotNull) */
    public OverlappingHostCB newMyConditionBean() {
        return new OverlappingHostCB();
    }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br />
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * OverlappingHostCB cb = new OverlappingHostCB();
     * cb.query().setFoo...(value);
     * int count = overlappingHostBhv.<span style="color: #FD4747">selectCount</span>(cb);
     * </pre>
     * @param cb The condition-bean of OverlappingHost. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(final OverlappingHostCB cb) {
        return doSelectCountUniquely(cb);
    }

    protected int doSelectCountUniquely(final OverlappingHostCB cb) { // called by selectCount(cb)
        assertCBStateValid(cb);
        return delegateSelectCountUniquely(cb);
    }

    protected int doSelectCountPlainly(final OverlappingHostCB cb) { // called by selectPage(cb)
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
     * OverlappingHostCB cb = new OverlappingHostCB();
     * cb.query().setFoo...(value);
     * OverlappingHost overlappingHost = overlappingHostBhv.<span style="color: #FD4747">selectEntity</span>(cb);
     * if (overlappingHost != null) {
     *     ... = overlappingHost.get...();
     * } else {
     *     ...
     * }
     * </pre>
     * @param cb The condition-bean of OverlappingHost. (NotNull)
     * @return The entity selected by the condition. (NullAllowed: if no data, it returns null)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public OverlappingHost selectEntity(final OverlappingHostCB cb) {
        return doSelectEntity(cb, OverlappingHost.class);
    }

    protected <ENTITY extends OverlappingHost> ENTITY doSelectEntity(
            final OverlappingHostCB cb, final Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        return helpSelectEntityInternally(cb, entityType,
                new InternalSelectEntityCallback<ENTITY, OverlappingHostCB>() {
                    @Override
                    public List<ENTITY> callbackSelectList(
                            final OverlappingHostCB cb,
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
     * OverlappingHostCB cb = new OverlappingHostCB();
     * cb.query().setFoo...(value);
     * OverlappingHost overlappingHost = overlappingHostBhv.<span style="color: #FD4747">selectEntityWithDeletedCheck</span>(cb);
     * ... = overlappingHost.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cb The condition-bean of OverlappingHost. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public OverlappingHost selectEntityWithDeletedCheck(
            final OverlappingHostCB cb) {
        return doSelectEntityWithDeletedCheck(cb, OverlappingHost.class);
    }

    protected <ENTITY extends OverlappingHost> ENTITY doSelectEntityWithDeletedCheck(
            final OverlappingHostCB cb, final Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        return helpSelectEntityWithDeletedCheckInternally(
                cb,
                entityType,
                new InternalSelectEntityWithDeletedCheckCallback<ENTITY, OverlappingHostCB>() {
                    @Override
                    public List<ENTITY> callbackSelectList(
                            final OverlappingHostCB cb,
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
    public OverlappingHost selectByPKValue(final Long id) {
        return doSelectByPKValue(id, OverlappingHost.class);
    }

    protected <ENTITY extends OverlappingHost> ENTITY doSelectByPKValue(
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
    public OverlappingHost selectByPKValueWithDeletedCheck(final Long id) {
        return doSelectByPKValueWithDeletedCheck(id, OverlappingHost.class);
    }

    protected <ENTITY extends OverlappingHost> ENTITY doSelectByPKValueWithDeletedCheck(
            final Long id, final Class<ENTITY> entityType) {
        return doSelectEntityWithDeletedCheck(buildPKCB(id), entityType);
    }

    private OverlappingHostCB buildPKCB(final Long id) {
        assertObjectNotNull("id", id);
        final OverlappingHostCB cb = newMyConditionBean();
        cb.query().setId_Equal(id);
        return cb;
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * OverlappingHostCB cb = new OverlappingHostCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * ListResultBean&lt;OverlappingHost&gt; overlappingHostList = overlappingHostBhv.<span style="color: #FD4747">selectList</span>(cb);
     * for (OverlappingHost overlappingHost : overlappingHostList) {
     *     ... = overlappingHost.get...();
     * }
     * </pre>
     * @param cb The condition-bean of OverlappingHost. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @exception org.seasar.dbflute.exception.DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<OverlappingHost> selectList(final OverlappingHostCB cb) {
        return doSelectList(cb, OverlappingHost.class);
    }

    protected <ENTITY extends OverlappingHost> ListResultBean<ENTITY> doSelectList(
            final OverlappingHostCB cb, final Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        assertObjectNotNull("entityType", entityType);
        assertSpecifyDerivedReferrerEntityProperty(cb, entityType);
        return helpSelectListInternally(cb, entityType,
                new InternalSelectListCallback<ENTITY, OverlappingHostCB>() {
                    @Override
                    public List<ENTITY> callbackSelectList(
                            final OverlappingHostCB cb,
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
     * OverlappingHostCB cb = new OverlappingHostCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * cb.<span style="color: #FD4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * PagingResultBean&lt;OverlappingHost&gt; page = overlappingHostBhv.<span style="color: #FD4747">selectPage</span>(cb);
     * int allRecordCount = page.getAllRecordCount();
     * int allPageCount = page.getAllPageCount();
     * boolean isExistPrePage = page.isExistPrePage();
     * boolean isExistNextPage = page.isExistNextPage();
     * ...
     * for (OverlappingHost overlappingHost : page) {
     *     ... = overlappingHost.get...();
     * }
     * </pre>
     * @param cb The condition-bean of OverlappingHost. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @exception org.seasar.dbflute.exception.DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<OverlappingHost> selectPage(
            final OverlappingHostCB cb) {
        return doSelectPage(cb, OverlappingHost.class);
    }

    protected <ENTITY extends OverlappingHost> PagingResultBean<ENTITY> doSelectPage(
            final OverlappingHostCB cb, final Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        assertObjectNotNull("entityType", entityType);
        return helpSelectPageInternally(cb, entityType,
                new InternalSelectPageCallback<ENTITY, OverlappingHostCB>() {
                    @Override
                    public int callbackSelectCount(final OverlappingHostCB cb) {
                        return doSelectCountPlainly(cb);
                    }

                    @Override
                    public List<ENTITY> callbackSelectList(
                            final OverlappingHostCB cb,
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
     * OverlappingHostCB cb = new OverlappingHostCB();
     * cb.query().setFoo...(value);
     * overlappingHostBhv.<span style="color: #FD4747">selectCursor</span>(cb, new EntityRowHandler&lt;OverlappingHost&gt;() {
     *     public void handle(OverlappingHost entity) {
     *         ... = entity.getFoo...();
     *     }
     * });
     * </pre>
     * @param cb The condition-bean of OverlappingHost. (NotNull)
     * @param entityRowHandler The handler of entity row of OverlappingHost. (NotNull)
     */
    public void selectCursor(final OverlappingHostCB cb,
            final EntityRowHandler<OverlappingHost> entityRowHandler) {
        doSelectCursor(cb, entityRowHandler, OverlappingHost.class);
    }

    protected <ENTITY extends OverlappingHost> void doSelectCursor(
            final OverlappingHostCB cb,
            final EntityRowHandler<ENTITY> entityRowHandler,
            final Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        assertObjectNotNull("entityRowHandler<OverlappingHost>",
                entityRowHandler);
        assertObjectNotNull("entityType", entityType);
        assertSpecifyDerivedReferrerEntityProperty(cb, entityType);
        helpSelectCursorInternally(cb, entityRowHandler, entityType,
                new InternalSelectCursorCallback<ENTITY, OverlappingHostCB>() {
                    @Override
                    public void callbackSelectCursor(
                            final OverlappingHostCB cb,
                            final EntityRowHandler<ENTITY> entityRowHandler,
                            final Class<ENTITY> entityType) {
                        delegateSelectCursor(cb, entityRowHandler, entityType);
                    }

                    @Override
                    public List<ENTITY> callbackSelectList(
                            final OverlappingHostCB cb,
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
     * overlappingHostBhv.<span style="color: #FD4747">scalarSelect</span>(Date.class).max(new ScalarQuery() {
     *     public void query(OverlappingHostCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooDatetime()</span>; <span style="color: #3F7E5E">// required for a function</span>
     *         cb.query().setBarName_PrefixSearch("S");
     *     }
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar value derived by a function. (NullAllowed)
     */
    public <RESULT> SLFunction<OverlappingHostCB, RESULT> scalarSelect(
            final Class<RESULT> resultType) {
        return doScalarSelect(resultType, newMyConditionBean());
    }

    protected <RESULT, CB extends OverlappingHostCB> SLFunction<CB, RESULT> doScalarSelect(
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
    //                                                                   Pull out Relation
    //                                                                   =================

    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key id.
     * @param overlappingHostList The list of overlappingHost. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Long> extractIdList(
            final List<OverlappingHost> overlappingHostList) {
        return helpExtractListInternally(overlappingHostList,
                new InternalExtractCallback<OverlappingHost, Long>() {
                    @Override
                    public Long getCV(final OverlappingHost e) {
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
     * OverlappingHost overlappingHost = new OverlappingHost();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * overlappingHost.setFoo...(value);
     * overlappingHost.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//overlappingHost.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//overlappingHost.set...;</span>
     * overlappingHostBhv.<span style="color: #FD4747">insert</span>(overlappingHost);
     * ... = overlappingHost.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param overlappingHost The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(final OverlappingHost overlappingHost) {
        doInsert(overlappingHost, null);
    }

    protected void doInsert(final OverlappingHost overlappingHost,
            final InsertOption<OverlappingHostCB> option) {
        assertObjectNotNull("overlappingHost", overlappingHost);
        prepareInsertOption(option);
        delegateInsert(overlappingHost, option);
    }

    protected void prepareInsertOption(
            final InsertOption<OverlappingHostCB> option) {
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
     * Update the entity modified-only. (ZeroUpdateException, ExclusiveControl)
     * <pre>
     * OverlappingHost overlappingHost = new OverlappingHost();
     * overlappingHost.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * overlappingHost.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//overlappingHost.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//overlappingHost.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * overlappingHost.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     overlappingHostBhv.<span style="color: #FD4747">update</span>(overlappingHost);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param overlappingHost The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(final OverlappingHost overlappingHost) {
        doUpdate(overlappingHost, null);
    }

    protected void doUpdate(final OverlappingHost overlappingHost,
            final UpdateOption<OverlappingHostCB> option) {
        assertObjectNotNull("overlappingHost", overlappingHost);
        prepareUpdateOption(option);
        helpUpdateInternally(overlappingHost,
                new InternalUpdateCallback<OverlappingHost>() {
                    @Override
                    public int callbackDelegateUpdate(
                            final OverlappingHost entity) {
                        return delegateUpdate(entity, option);
                    }
                });
    }

    protected void prepareUpdateOption(
            final UpdateOption<OverlappingHostCB> option) {
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

    protected OverlappingHostCB createCBForVaryingUpdate() {
        final OverlappingHostCB cb = newMyConditionBean();
        cb.xsetupForVaryingUpdate();
        return cb;
    }

    protected OverlappingHostCB createCBForSpecifiedUpdate() {
        final OverlappingHostCB cb = newMyConditionBean();
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

    /**
     * Update the entity non-strictly modified-only. (ZeroUpdateException, NonExclusiveControl)
     * <pre>
     * OverlappingHost overlappingHost = new OverlappingHost();
     * overlappingHost.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * overlappingHost.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//overlappingHost.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//overlappingHost.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//overlappingHost.setVersionNo(value);</span>
     * overlappingHostBhv.<span style="color: #FD4747">updateNonstrict</span>(overlappingHost);
     * </pre>
     * @param overlappingHost The entity of update target. (NotNull, PrimaryKeyNotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void updateNonstrict(final OverlappingHost overlappingHost) {
        doUpdateNonstrict(overlappingHost, null);
    }

    protected void doUpdateNonstrict(final OverlappingHost overlappingHost,
            final UpdateOption<OverlappingHostCB> option) {
        assertObjectNotNull("overlappingHost", overlappingHost);
        prepareUpdateOption(option);
        helpUpdateNonstrictInternally(overlappingHost,
                new InternalUpdateNonstrictCallback<OverlappingHost>() {
                    @Override
                    public int callbackDelegateUpdateNonstrict(
                            final OverlappingHost entity) {
                        return delegateUpdateNonstrict(entity, option);
                    }
                });
    }

    @Override
    protected void doModifyNonstrict(final Entity entity,
            final UpdateOption<? extends ConditionBean> option) {
        if (option == null) {
            updateNonstrict(downcast(entity));
        } else {
            varyingUpdateNonstrict(downcast(entity), downcast(option));
        }
    }

    /**
     * Insert or update the entity modified-only. (DefaultConstraintsEnabled, ExclusiveControl) <br />
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() } <br />
     * <p><span style="color: #FD4747; font-size: 120%">Attention, you cannot update by unique keys instead of PK.</span></p>
     * @param overlappingHost The entity of insert or update target. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(final OverlappingHost overlappingHost) {
        doInesrtOrUpdate(overlappingHost, null, null);
    }

    protected void doInesrtOrUpdate(final OverlappingHost overlappingHost,
            final InsertOption<OverlappingHostCB> insertOption,
            final UpdateOption<OverlappingHostCB> updateOption) {
        helpInsertOrUpdateInternally(
                overlappingHost,
                new InternalInsertOrUpdateCallback<OverlappingHost, OverlappingHostCB>() {
                    @Override
                    public void callbackInsert(final OverlappingHost entity) {
                        doInsert(entity, insertOption);
                    }

                    @Override
                    public void callbackUpdate(final OverlappingHost entity) {
                        doUpdate(entity, updateOption);
                    }

                    @Override
                    public OverlappingHostCB callbackNewMyConditionBean() {
                        return newMyConditionBean();
                    }

                    @Override
                    public int callbackSelectCount(final OverlappingHostCB cb) {
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
            insertOption = insertOption == null ? new InsertOption<OverlappingHostCB>()
                    : insertOption;
            updateOption = updateOption == null ? new UpdateOption<OverlappingHostCB>()
                    : updateOption;
            varyingInsertOrUpdate(downcast(entity), downcast(insertOption),
                    downcast(updateOption));
        }
    }

    /**
     * Insert or update the entity non-strictly modified-only. (DefaultConstraintsEnabled, NonExclusiveControl) <br />
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() }
     * <p><span style="color: #FD4747; font-size: 120%">Attention, you cannot update by unique keys instead of PK.</span></p>
     * @param overlappingHost The entity of insert or update target. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdateNonstrict(final OverlappingHost overlappingHost) {
        doInesrtOrUpdateNonstrict(overlappingHost, null, null);
    }

    protected void doInesrtOrUpdateNonstrict(
            final OverlappingHost overlappingHost,
            final InsertOption<OverlappingHostCB> insertOption,
            final UpdateOption<OverlappingHostCB> updateOption) {
        helpInsertOrUpdateInternally(overlappingHost,
                new InternalInsertOrUpdateNonstrictCallback<OverlappingHost>() {
                    @Override
                    public void callbackInsert(final OverlappingHost entity) {
                        doInsert(entity, insertOption);
                    }

                    @Override
                    public void callbackUpdateNonstrict(
                            final OverlappingHost entity) {
                        doUpdateNonstrict(entity, updateOption);
                    }
                });
    }

    @Override
    protected void doCreateOrModifyNonstrict(final Entity entity,
            InsertOption<? extends ConditionBean> insertOption,
            UpdateOption<? extends ConditionBean> updateOption) {
        if (insertOption == null && updateOption == null) {
            insertOrUpdateNonstrict(downcast(entity));
        } else {
            insertOption = insertOption == null ? new InsertOption<OverlappingHostCB>()
                    : insertOption;
            updateOption = updateOption == null ? new UpdateOption<OverlappingHostCB>()
                    : updateOption;
            varyingInsertOrUpdateNonstrict(downcast(entity),
                    downcast(insertOption), downcast(updateOption));
        }
    }

    /**
     * Delete the entity. (ZeroUpdateException, ExclusiveControl)
     * <pre>
     * OverlappingHost overlappingHost = new OverlappingHost();
     * overlappingHost.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * overlappingHost.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     overlappingHostBhv.<span style="color: #FD4747">delete</span>(overlappingHost);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param overlappingHost The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(final OverlappingHost overlappingHost) {
        doDelete(overlappingHost, null);
    }

    protected void doDelete(final OverlappingHost overlappingHost,
            final DeleteOption<OverlappingHostCB> option) {
        assertObjectNotNull("overlappingHost", overlappingHost);
        prepareDeleteOption(option);
        helpDeleteInternally(overlappingHost,
                new InternalDeleteCallback<OverlappingHost>() {
                    @Override
                    public int callbackDelegateDelete(
                            final OverlappingHost entity) {
                        return delegateDelete(entity, option);
                    }
                });
    }

    protected void prepareDeleteOption(
            final DeleteOption<OverlappingHostCB> option) {
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

    /**
     * Delete the entity non-strictly. {ZeroUpdateException, NonExclusiveControl}
     * <pre>
     * OverlappingHost overlappingHost = new OverlappingHost();
     * overlappingHost.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//overlappingHost.setVersionNo(value);</span>
     * overlappingHostBhv.<span style="color: #FD4747">deleteNonstrict</span>(overlappingHost);
     * </pre>
     * @param overlappingHost The entity of delete target. (NotNull, PrimaryKeyNotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void deleteNonstrict(final OverlappingHost overlappingHost) {
        doDeleteNonstrict(overlappingHost, null);
    }

    protected void doDeleteNonstrict(final OverlappingHost overlappingHost,
            final DeleteOption<OverlappingHostCB> option) {
        assertObjectNotNull("overlappingHost", overlappingHost);
        prepareDeleteOption(option);
        helpDeleteNonstrictInternally(overlappingHost,
                new InternalDeleteNonstrictCallback<OverlappingHost>() {
                    @Override
                    public int callbackDelegateDeleteNonstrict(
                            final OverlappingHost entity) {
                        return delegateDeleteNonstrict(entity, option);
                    }
                });
    }

    /**
     * Delete the entity non-strictly ignoring deleted. {ZeroUpdateException, NonExclusiveControl}
     * <pre>
     * OverlappingHost overlappingHost = new OverlappingHost();
     * overlappingHost.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//overlappingHost.setVersionNo(value);</span>
     * overlappingHostBhv.<span style="color: #FD4747">deleteNonstrictIgnoreDeleted</span>(overlappingHost);
     * <span style="color: #3F7E5E">// if the target entity doesn't exist, no exception</span>
     * </pre>
     * @param overlappingHost The entity of delete target. (NotNull, PrimaryKeyNotNull)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void deleteNonstrictIgnoreDeleted(
            final OverlappingHost overlappingHost) {
        doDeleteNonstrictIgnoreDeleted(overlappingHost, null);
    }

    protected void doDeleteNonstrictIgnoreDeleted(
            final OverlappingHost overlappingHost,
            final DeleteOption<OverlappingHostCB> option) {
        assertObjectNotNull("overlappingHost", overlappingHost);
        prepareDeleteOption(option);
        helpDeleteNonstrictIgnoreDeletedInternally(
                overlappingHost,
                new InternalDeleteNonstrictIgnoreDeletedCallback<OverlappingHost>() {
                    @Override
                    public int callbackDelegateDeleteNonstrict(
                            final OverlappingHost entity) {
                        return delegateDeleteNonstrict(entity, option);
                    }
                });
    }

    @Override
    protected void doRemoveNonstrict(final Entity entity,
            final DeleteOption<? extends ConditionBean> option) {
        if (option == null) {
            deleteNonstrict(downcast(entity));
        } else {
            varyingDeleteNonstrict(downcast(entity), downcast(option));
        }
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
     * @param overlappingHostList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(final List<OverlappingHost> overlappingHostList) {
        return doBatchInsert(overlappingHostList, null);
    }

    protected int[] doBatchInsert(
            final List<OverlappingHost> overlappingHostList,
            final InsertOption<OverlappingHostCB> option) {
        assertObjectNotNull("overlappingHostList", overlappingHostList);
        prepareInsertOption(option);
        return delegateBatchInsert(overlappingHostList, option);
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
     * Batch-update the entity list. (AllColumnsUpdated, ExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <span style="color: #FD4747; font-size: 140%">Attention, all columns are update target. {NOT modified only}</span> <br />
     * So you should the other batchUpdate() (overload) method for performace,
     * which you can specify update columns like this:
     * <pre>
     * overlappingHostBhv.<span style="color: #FD4747">batchUpdate</span>(overlappingHostList, new SpecifyQuery<OverlappingHostCB>() {
     *     public void specify(OverlappingHostCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #FD4747">columnFooStatusCode()</span>;
     *         cb.specify().<span style="color: #FD4747">columnBarDate()</span>;
     *     }
     * });
     * </pre>
     * @param overlappingHostList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchUpdate(final List<OverlappingHost> overlappingHostList) {
        return doBatchUpdate(overlappingHostList, null);
    }

    protected int[] doBatchUpdate(
            final List<OverlappingHost> overlappingHostList,
            final UpdateOption<OverlappingHostCB> option) {
        assertObjectNotNull("overlappingHostList", overlappingHostList);
        prepareBatchUpdateOption(overlappingHostList, option);
        return delegateBatchUpdate(overlappingHostList, option);
    }

    protected void prepareBatchUpdateOption(
            final List<OverlappingHost> overlappingHostList,
            final UpdateOption<OverlappingHostCB> option) {
        if (option == null) {
            return;
        }
        prepareUpdateOption(option);
        // under review
        //if (option.hasSpecifiedUpdateColumn()) {
        //    option.xgatherUpdateColumnModifiedProperties(overlappingHostList);
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
     * Batch-update the entity list. (SpecifiedColumnsUpdated, ExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <pre>
     * <span style="color: #3F7E5E">// e.g. update two columns only</span>
     * overlappingHostBhv.<span style="color: #FD4747">batchUpdate</span>(overlappingHostList, new SpecifyQuery<OverlappingHostCB>() {
     *     public void specify(OverlappingHostCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #FD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #FD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span>
     * overlappingHostBhv.<span style="color: #FD4747">batchUpdate</span>(overlappingHostList, new SpecifyQuery<OverlappingHostCB>() {
     *     public void specify(OverlappingHostCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #FD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).
     * But if you specify every column, it has no check.</p>
     * @param overlappingHostList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchUpdate(final List<OverlappingHost> overlappingHostList,
            final SpecifyQuery<OverlappingHostCB> updateColumnSpec) {
        return doBatchUpdate(overlappingHostList,
                createSpecifiedUpdateOption(updateColumnSpec));
    }

    /**
     * Batch-update the entity list non-strictly. (AllColumnsUpdated, NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <span style="color: #FD4747">All columns are update target. {NOT modified only}</span>
     * So you should the other batchUpdateNonstrict() (overload) method for performace,
     * which you can specify update columns like this:
     * <pre>
     * overlappingHostBhv.<span style="color: #FD4747">batchUpdateNonstrict</span>(overlappingHostList, new SpecifyQuery<OverlappingHostCB>() {
     *     public void specify(OverlappingHostCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #FD4747">columnFooStatusCode()</span>;
     *         cb.specify().<span style="color: #FD4747">columnBarDate()</span>;
     *     }
     * });
     * </pre>
     * @param overlappingHostList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdateNonstrict(
            final List<OverlappingHost> overlappingHostList) {
        return doBatchUpdateNonstrict(overlappingHostList, null);
    }

    protected int[] doBatchUpdateNonstrict(
            final List<OverlappingHost> overlappingHostList,
            final UpdateOption<OverlappingHostCB> option) {
        assertObjectNotNull("overlappingHostList", overlappingHostList);
        prepareBatchUpdateOption(overlappingHostList, option);
        return delegateBatchUpdateNonstrict(overlappingHostList, option);
    }

    /**
     * Batch-update the entity list non-strictly. (SpecifiedColumnsUpdated, NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <pre>
     * <span style="color: #3F7E5E">// e.g. update two columns only</span>
     * overlappingHostBhv.<span style="color: #FD4747">batchUpdateNonstrict</span>(overlappingHostList, new SpecifyQuery<OverlappingHostCB>() {
     *     public void specify(OverlappingHostCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #FD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #FD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span>
     * overlappingHostBhv.<span style="color: #FD4747">batchUpdateNonstrict</span>(overlappingHostList, new SpecifyQuery<OverlappingHostCB>() {
     *     public void specify(OverlappingHostCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #FD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).</p>
     * @param overlappingHostList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdateNonstrict(
            final List<OverlappingHost> overlappingHostList,
            final SpecifyQuery<OverlappingHostCB> updateColumnSpec) {
        return doBatchUpdateNonstrict(overlappingHostList,
                createSpecifiedUpdateOption(updateColumnSpec));
    }

    @Override
    protected int[] doLumpModifyNonstrict(final List<Entity> ls,
            final UpdateOption<? extends ConditionBean> option) {
        if (option == null) {
            return batchUpdateNonstrict(downcast(ls));
        } else {
            return varyingBatchUpdateNonstrict(downcast(ls), downcast(option));
        }
    }

    /**
     * Batch-delete the entity list. (ExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param overlappingHostList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchDelete(final List<OverlappingHost> overlappingHostList) {
        return doBatchDelete(overlappingHostList, null);
    }

    protected int[] doBatchDelete(
            final List<OverlappingHost> overlappingHostList,
            final DeleteOption<OverlappingHostCB> option) {
        assertObjectNotNull("overlappingHostList", overlappingHostList);
        prepareDeleteOption(option);
        return delegateBatchDelete(overlappingHostList, option);
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

    /**
     * Batch-delete the entity list non-strictly. {NonExclusiveControl} <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param overlappingHostList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDeleteNonstrict(
            final List<OverlappingHost> overlappingHostList) {
        return doBatchDeleteNonstrict(overlappingHostList, null);
    }

    protected int[] doBatchDeleteNonstrict(
            final List<OverlappingHost> overlappingHostList,
            final DeleteOption<OverlappingHostCB> option) {
        assertObjectNotNull("overlappingHostList", overlappingHostList);
        prepareDeleteOption(option);
        return delegateBatchDeleteNonstrict(overlappingHostList, option);
    }

    @Override
    protected int[] doLumpRemoveNonstrict(final List<Entity> ls,
            final DeleteOption<? extends ConditionBean> option) {
        if (option == null) {
            return batchDeleteNonstrict(downcast(ls));
        } else {
            return varyingBatchDeleteNonstrict(downcast(ls), downcast(option));
        }
    }

    // ===================================================================================
    //                                                                        Query Update
    //                                                                        ============
    /**
     * Insert the several entities by query (modified-only for fixed value).
     * <pre>
     * overlappingHostBhv.<span style="color: #FD4747">queryInsert</span>(new QueryInsertSetupper&lt;OverlappingHost, OverlappingHostCB&gt;() {
     *     public ConditionBean setup(overlappingHost entity, OverlappingHostCB intoCB) {
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
            final QueryInsertSetupper<OverlappingHost, OverlappingHostCB> setupper) {
        return doQueryInsert(setupper, null);
    }

    protected int doQueryInsert(
            final QueryInsertSetupper<OverlappingHost, OverlappingHostCB> setupper,
            final InsertOption<OverlappingHostCB> option) {
        assertObjectNotNull("setupper", setupper);
        prepareInsertOption(option);
        final OverlappingHost entity = new OverlappingHost();
        final OverlappingHostCB intoCB = createCBForQueryInsert();
        final ConditionBean resourceCB = setupper.setup(entity, intoCB);
        return delegateQueryInsert(entity, intoCB, resourceCB, option);
    }

    protected OverlappingHostCB createCBForQueryInsert() {
        final OverlappingHostCB cb = newMyConditionBean();
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
     * OverlappingHost overlappingHost = new OverlappingHost();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//overlappingHost.setPK...(value);</span>
     * overlappingHost.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//overlappingHost.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//overlappingHost.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//overlappingHost.setVersionNo(value);</span>
     * OverlappingHostCB cb = new OverlappingHostCB();
     * cb.query().setFoo...(value);
     * overlappingHostBhv.<span style="color: #FD4747">queryUpdate</span>(overlappingHost, cb);
     * </pre>
     * @param overlappingHost The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of OverlappingHost. (NotNull)
     * @return The updated count.
     * @exception org.seasar.dbflute.exception.NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(final OverlappingHost overlappingHost,
            final OverlappingHostCB cb) {
        return doQueryUpdate(overlappingHost, cb, null);
    }

    protected int doQueryUpdate(final OverlappingHost overlappingHost,
            final OverlappingHostCB cb,
            final UpdateOption<OverlappingHostCB> option) {
        assertObjectNotNull("overlappingHost", overlappingHost);
        assertCBStateValid(cb);
        prepareUpdateOption(option);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryUpdate(
                overlappingHost, cb, option) : 0;
    }

    @Override
    protected int doRangeModify(final Entity entity, final ConditionBean cb,
            final UpdateOption<? extends ConditionBean> option) {
        if (option == null) {
            return queryUpdate(downcast(entity), (OverlappingHostCB) cb);
        } else {
            return varyingQueryUpdate(downcast(entity), (OverlappingHostCB) cb,
                    downcast(option));
        }
    }

    /**
     * Delete the several entities by query. (NonExclusiveControl)
     * <pre>
     * OverlappingHostCB cb = new OverlappingHostCB();
     * cb.query().setFoo...(value);
     * overlappingHostBhv.<span style="color: #FD4747">queryDelete</span>(overlappingHost, cb);
     * </pre>
     * @param cb The condition-bean of OverlappingHost. (NotNull)
     * @return The deleted count.
     * @exception org.seasar.dbflute.exception.NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(final OverlappingHostCB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(final OverlappingHostCB cb,
            final DeleteOption<OverlappingHostCB> option) {
        assertCBStateValid(cb);
        prepareDeleteOption(option);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryDelete(cb,
                option) : 0;
    }

    @Override
    protected int doRangeRemove(final ConditionBean cb,
            final DeleteOption<? extends ConditionBean> option) {
        if (option == null) {
            return queryDelete((OverlappingHostCB) cb);
        } else {
            return varyingQueryDelete((OverlappingHostCB) cb, downcast(option));
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
     * OverlappingHost overlappingHost = new OverlappingHost();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * overlappingHost.setFoo...(value);
     * overlappingHost.setBar...(value);
     * InsertOption<OverlappingHostCB> option = new InsertOption<OverlappingHostCB>();
     * <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     * option.disableCommonColumnAutoSetup();
     * overlappingHostBhv.<span style="color: #FD4747">varyingInsert</span>(overlappingHost, option);
     * ... = overlappingHost.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param overlappingHost The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(final OverlappingHost overlappingHost,
            final InsertOption<OverlappingHostCB> option) {
        assertInsertOptionNotNull(option);
        doInsert(overlappingHost, option);
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, ExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as update(entity).
     * <pre>
     * OverlappingHost overlappingHost = new OverlappingHost();
     * overlappingHost.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * overlappingHost.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * overlappingHost.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;OverlappingHostCB&gt; option = new UpdateOption&lt;OverlappingHostCB&gt;();
     *     option.self(new SpecifyQuery&lt;OverlappingHostCB&gt;() {
     *         public void specify(OverlappingHostCB cb) {
     *             cb.specify().<span style="color: #FD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     overlappingHostBhv.<span style="color: #FD4747">varyingUpdate</span>(overlappingHost, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param overlappingHost The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(final OverlappingHost overlappingHost,
            final UpdateOption<OverlappingHostCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdate(overlappingHost, option);
    }

    /**
     * Update the entity with varying requests non-strictly modified-only. (ZeroUpdateException, NonExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as updateNonstrict(entity).
     * <pre>
     * <span style="color: #3F7E5E">// ex) you can update by self calculation values</span>
     * OverlappingHost overlappingHost = new OverlappingHost();
     * overlappingHost.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * overlappingHost.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//overlappingHost.setVersionNo(value);</span>
     * UpdateOption&lt;OverlappingHostCB&gt; option = new UpdateOption&lt;OverlappingHostCB&gt;();
     * option.self(new SpecifyQuery&lt;OverlappingHostCB&gt;() {
     *     public void specify(OverlappingHostCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * overlappingHostBhv.<span style="color: #FD4747">varyingUpdateNonstrict</span>(overlappingHost, option);
     * </pre>
     * @param overlappingHost The entity of update target. (NotNull, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdateNonstrict(final OverlappingHost overlappingHost,
            final UpdateOption<OverlappingHostCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdateNonstrict(overlappingHost, option);
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdate(entity).
     * @param overlappingHost The entity of insert or update target. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(final OverlappingHost overlappingHost,
            final InsertOption<OverlappingHostCB> insertOption,
            final UpdateOption<OverlappingHostCB> updateOption) {
        assertInsertOptionNotNull(insertOption);
        assertUpdateOptionNotNull(updateOption);
        doInesrtOrUpdate(overlappingHost, insertOption, updateOption);
    }

    /**
     * Insert or update the entity with varying requests non-strictly. (NonExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdateNonstrict(entity).
     * @param overlappingHost The entity of insert or update target. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdateNonstrict(
            final OverlappingHost overlappingHost,
            final InsertOption<OverlappingHostCB> insertOption,
            final UpdateOption<OverlappingHostCB> updateOption) {
        assertInsertOptionNotNull(insertOption);
        assertUpdateOptionNotNull(updateOption);
        doInesrtOrUpdateNonstrict(overlappingHost, insertOption, updateOption);
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, ExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as delete(entity).
     * @param overlappingHost The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(final OverlappingHost overlappingHost,
            final DeleteOption<OverlappingHostCB> option) {
        assertDeleteOptionNotNull(option);
        doDelete(overlappingHost, option);
    }

    /**
     * Delete the entity with varying requests non-strictly. (ZeroUpdateException, NonExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as deleteNonstrict(entity).
     * @param overlappingHost The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDeleteNonstrict(final OverlappingHost overlappingHost,
            final DeleteOption<OverlappingHostCB> option) {
        assertDeleteOptionNotNull(option);
        doDeleteNonstrict(overlappingHost, option);
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br />
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br />
     * Other specifications are same as batchInsert(entityList).
     * @param overlappingHostList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(
            final List<OverlappingHost> overlappingHostList,
            final InsertOption<OverlappingHostCB> option) {
        assertInsertOptionNotNull(option);
        return doBatchInsert(overlappingHostList, option);
    }

    /**
     * Batch-update the list with varying requests. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdate(entityList).
     * @param overlappingHostList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(
            final List<OverlappingHost> overlappingHostList,
            final UpdateOption<OverlappingHostCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdate(overlappingHostList, option);
    }

    /**
     * Batch-update the list with varying requests non-strictly. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param overlappingHostList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdateNonstrict(
            final List<OverlappingHost> overlappingHostList,
            final UpdateOption<OverlappingHostCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdateNonstrict(overlappingHostList, option);
    }

    /**
     * Batch-delete the list with varying requests. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDelete(entityList).
     * @param overlappingHostList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(
            final List<OverlappingHost> overlappingHostList,
            final DeleteOption<OverlappingHostCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDelete(overlappingHostList, option);
    }

    /**
     * Batch-delete the list with varying requests non-strictly. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDeleteNonstrict(entityList).
     * @param overlappingHostList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDeleteNonstrict(
            final List<OverlappingHost> overlappingHostList,
            final DeleteOption<OverlappingHostCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDeleteNonstrict(overlappingHostList, option);
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
            final QueryInsertSetupper<OverlappingHost, OverlappingHostCB> setupper,
            final InsertOption<OverlappingHostCB> option) {
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
     * OverlappingHost overlappingHost = new OverlappingHost();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//overlappingHost.setPK...(value);</span>
     * overlappingHost.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//overlappingHost.setVersionNo(value);</span>
     * OverlappingHostCB cb = new OverlappingHostCB();
     * cb.query().setFoo...(value);
     * UpdateOption&lt;OverlappingHostCB&gt; option = new UpdateOption&lt;OverlappingHostCB&gt;();
     * option.self(new SpecifyQuery&lt;OverlappingHostCB&gt;() {
     *     public void specify(OverlappingHostCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * overlappingHostBhv.<span style="color: #FD4747">varyingQueryUpdate</span>(overlappingHost, cb, option);
     * </pre>
     * @param overlappingHost The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of OverlappingHost. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception org.seasar.dbflute.exception.NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(final OverlappingHost overlappingHost,
            final OverlappingHostCB cb,
            final UpdateOption<OverlappingHostCB> option) {
        assertUpdateOptionNotNull(option);
        return doQueryUpdate(overlappingHost, cb, option);
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br />
     * For example, allowNonQueryDelete(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param cb The condition-bean of OverlappingHost. (NotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @exception org.seasar.dbflute.exception.NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(final OverlappingHostCB cb,
            final DeleteOption<OverlappingHostCB> option) {
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
    public OutsideSqlBasicExecutor<OverlappingHostBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                     Delegate Method
    //                                                                     ===============
    // [Behavior Command]
    // -----------------------------------------------------
    //                                                Select
    //                                                ------
    protected int delegateSelectCountUniquely(final OverlappingHostCB cb) {
        return invoke(createSelectCountCBCommand(cb, true));
    }

    protected int delegateSelectCountPlainly(final OverlappingHostCB cb) {
        return invoke(createSelectCountCBCommand(cb, false));
    }

    protected <ENTITY extends OverlappingHost> void delegateSelectCursor(
            final OverlappingHostCB cb, final EntityRowHandler<ENTITY> erh,
            final Class<ENTITY> et) {
        invoke(createSelectCursorCBCommand(cb, erh, et));
    }

    protected <ENTITY extends OverlappingHost> List<ENTITY> delegateSelectList(
            final OverlappingHostCB cb, final Class<ENTITY> et) {
        return invoke(createSelectListCBCommand(cb, et));
    }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(final OverlappingHost e,
            final InsertOption<OverlappingHostCB> op) {
        if (!processBeforeInsert(e, op)) {
            return 0;
        }
        return invoke(createInsertEntityCommand(e, op));
    }

    protected int delegateUpdate(final OverlappingHost e,
            final UpdateOption<OverlappingHostCB> op) {
        if (!processBeforeUpdate(e, op)) {
            return 0;
        }
        return invoke(createUpdateEntityCommand(e, op));
    }

    protected int delegateUpdateNonstrict(final OverlappingHost e,
            final UpdateOption<OverlappingHostCB> op) {
        if (!processBeforeUpdate(e, op)) {
            return 0;
        }
        return invoke(createUpdateNonstrictEntityCommand(e, op));
    }

    protected int delegateDelete(final OverlappingHost e,
            final DeleteOption<OverlappingHostCB> op) {
        if (!processBeforeDelete(e, op)) {
            return 0;
        }
        return invoke(createDeleteEntityCommand(e, op));
    }

    protected int delegateDeleteNonstrict(final OverlappingHost e,
            final DeleteOption<OverlappingHostCB> op) {
        if (!processBeforeDelete(e, op)) {
            return 0;
        }
        return invoke(createDeleteNonstrictEntityCommand(e, op));
    }

    protected int[] delegateBatchInsert(final List<OverlappingHost> ls,
            final InsertOption<OverlappingHostCB> op) {
        if (ls.isEmpty()) {
            return new int[] {};
        }
        return invoke(createBatchInsertCommand(processBatchInternally(ls, op),
                op));
    }

    protected int[] delegateBatchUpdate(final List<OverlappingHost> ls,
            final UpdateOption<OverlappingHostCB> op) {
        if (ls.isEmpty()) {
            return new int[] {};
        }
        return invoke(createBatchUpdateCommand(
                processBatchInternally(ls, op, false), op));
    }

    protected int[] delegateBatchUpdateNonstrict(
            final List<OverlappingHost> ls,
            final UpdateOption<OverlappingHostCB> op) {
        if (ls.isEmpty()) {
            return new int[] {};
        }
        return invoke(createBatchUpdateNonstrictCommand(
                processBatchInternally(ls, op, true), op));
    }

    protected int[] delegateBatchDelete(final List<OverlappingHost> ls,
            final DeleteOption<OverlappingHostCB> op) {
        if (ls.isEmpty()) {
            return new int[] {};
        }
        return invoke(createBatchDeleteCommand(
                processBatchInternally(ls, op, false), op));
    }

    protected int[] delegateBatchDeleteNonstrict(
            final List<OverlappingHost> ls,
            final DeleteOption<OverlappingHostCB> op) {
        if (ls.isEmpty()) {
            return new int[] {};
        }
        return invoke(createBatchDeleteNonstrictCommand(
                processBatchInternally(ls, op, true), op));
    }

    protected int delegateQueryInsert(final OverlappingHost e,
            final OverlappingHostCB inCB, final ConditionBean resCB,
            final InsertOption<OverlappingHostCB> op) {
        if (!processBeforeQueryInsert(e, inCB, resCB, op)) {
            return 0;
        }
        return invoke(createQueryInsertCBCommand(e, inCB, resCB, op));
    }

    protected int delegateQueryUpdate(final OverlappingHost e,
            final OverlappingHostCB cb, final UpdateOption<OverlappingHostCB> op) {
        if (!processBeforeQueryUpdate(e, cb, op)) {
            return 0;
        }
        return invoke(createQueryUpdateCBCommand(e, cb, op));
    }

    protected int delegateQueryDelete(final OverlappingHostCB cb,
            final DeleteOption<OverlappingHostCB> op) {
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
        return !(downcast(entity).getVersionNo() + "").equals("null");// For primitive type
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
    protected OverlappingHost downcast(final Entity entity) {
        return helpEntityDowncastInternally(entity, OverlappingHost.class);
    }

    protected OverlappingHostCB downcast(final ConditionBean cb) {
        return helpConditionBeanDowncastInternally(cb, OverlappingHostCB.class);
    }

    @SuppressWarnings("unchecked")
    protected List<OverlappingHost> downcast(
            final List<? extends Entity> entityList) {
        return (List<OverlappingHost>) entityList;
    }

    @SuppressWarnings("unchecked")
    protected InsertOption<OverlappingHostCB> downcast(
            final InsertOption<? extends ConditionBean> option) {
        return (InsertOption<OverlappingHostCB>) option;
    }

    @SuppressWarnings("unchecked")
    protected UpdateOption<OverlappingHostCB> downcast(
            final UpdateOption<? extends ConditionBean> option) {
        return (UpdateOption<OverlappingHostCB>) option;
    }

    @SuppressWarnings("unchecked")
    protected DeleteOption<OverlappingHostCB> downcast(
            final DeleteOption<? extends ConditionBean> option) {
        return (DeleteOption<OverlappingHostCB>) option;
    }

    @SuppressWarnings("unchecked")
    protected QueryInsertSetupper<OverlappingHost, OverlappingHostCB> downcast(
            final QueryInsertSetupper<? extends Entity, ? extends ConditionBean> option) {
        return (QueryInsertSetupper<OverlappingHost, OverlappingHostCB>) option;
    }
}
