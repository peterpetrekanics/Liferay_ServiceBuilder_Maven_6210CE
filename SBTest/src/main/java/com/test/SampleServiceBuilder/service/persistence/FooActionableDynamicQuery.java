package com.test.SampleServiceBuilder.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.test.SampleServiceBuilder.model.Foo;
import com.test.SampleServiceBuilder.service.FooLocalServiceUtil;

/**
 * @author Joe Bloggs
 * @generated
 */
public abstract class FooActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public FooActionableDynamicQuery() throws SystemException {
        setBaseLocalService(FooLocalServiceUtil.getService());
        setClass(Foo.class);

        setClassLoader(com.test.SampleServiceBuilder.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("fooId");
    }
}
