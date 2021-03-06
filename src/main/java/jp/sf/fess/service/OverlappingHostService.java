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

package jp.sf.fess.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import jp.sf.fess.crud.service.BsOverlappingHostService;
import jp.sf.fess.db.cbean.OverlappingHostCB;
import jp.sf.fess.db.exentity.OverlappingHost;
import jp.sf.fess.pager.OverlappingHostPager;

public class OverlappingHostService extends BsOverlappingHostService implements
        Serializable {

    private static final long serialVersionUID = 1L;

    public List<OverlappingHost> getOverlappingHostList() {

        final OverlappingHostCB cb = new OverlappingHostCB();

        cb.query().setDeletedBy_IsNull();
        cb.query().addOrderBy_SortOrder_Asc();
        cb.query().addOrderBy_RegularName_Asc();
        cb.query().addOrderBy_OverlappingName_Asc();

        return overlappingHostBhv.selectList(cb);
    }

    @Override
    protected void setupListCondition(final OverlappingHostCB cb,
            final OverlappingHostPager overlappingHostPager) {
        super.setupListCondition(cb, overlappingHostPager);

        // setup condition
        cb.query().setDeletedBy_IsNull();
        cb.query().addOrderBy_SortOrder_Asc();

        // search

    }

    @Override
    protected void setupEntityCondition(final OverlappingHostCB cb,
            final Map<String, String> keys) {
        super.setupEntityCondition(cb, keys);

        // setup condition
        cb.query().setDeletedBy_IsNull();

    }

    @Override
    protected void setupStoreCondition(final OverlappingHost overlappingHost) {
        super.setupStoreCondition(overlappingHost);

        // setup condition

    }

    @Override
    protected void setupDeleteCondition(final OverlappingHost overlappingHost) {
        super.setupDeleteCondition(overlappingHost);

        // setup condition

    }

}
