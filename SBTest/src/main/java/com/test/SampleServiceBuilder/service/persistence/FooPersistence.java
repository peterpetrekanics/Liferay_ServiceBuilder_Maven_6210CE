package com.test.SampleServiceBuilder.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.test.SampleServiceBuilder.model.Foo;

/**
 * The persistence interface for the foo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Joe Bloggs
 * @see FooPersistenceImpl
 * @see FooUtil
 * @generated
 */
public interface FooPersistence extends BasePersistence<Foo> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link FooUtil} to access the foo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the foos where field1 = &#63;.
    *
    * @param field1 the field1
    * @return the matching foos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.SampleServiceBuilder.model.Foo> findByField1(
        java.lang.String field1)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the foos where field1 = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.SampleServiceBuilder.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param field1 the field1
    * @param start the lower bound of the range of foos
    * @param end the upper bound of the range of foos (not inclusive)
    * @return the range of matching foos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.SampleServiceBuilder.model.Foo> findByField1(
        java.lang.String field1, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the foos where field1 = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.SampleServiceBuilder.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param field1 the field1
    * @param start the lower bound of the range of foos
    * @param end the upper bound of the range of foos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching foos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.SampleServiceBuilder.model.Foo> findByField1(
        java.lang.String field1, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first foo in the ordered set where field1 = &#63;.
    *
    * @param field1 the field1
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching foo
    * @throws com.test.SampleServiceBuilder.NoSuchFooException if a matching foo could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.SampleServiceBuilder.model.Foo findByField1_First(
        java.lang.String field1,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.test.SampleServiceBuilder.NoSuchFooException;

    /**
    * Returns the first foo in the ordered set where field1 = &#63;.
    *
    * @param field1 the field1
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching foo, or <code>null</code> if a matching foo could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.SampleServiceBuilder.model.Foo fetchByField1_First(
        java.lang.String field1,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last foo in the ordered set where field1 = &#63;.
    *
    * @param field1 the field1
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching foo
    * @throws com.test.SampleServiceBuilder.NoSuchFooException if a matching foo could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.SampleServiceBuilder.model.Foo findByField1_Last(
        java.lang.String field1,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.test.SampleServiceBuilder.NoSuchFooException;

    /**
    * Returns the last foo in the ordered set where field1 = &#63;.
    *
    * @param field1 the field1
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching foo, or <code>null</code> if a matching foo could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.SampleServiceBuilder.model.Foo fetchByField1_Last(
        java.lang.String field1,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the foos before and after the current foo in the ordered set where field1 = &#63;.
    *
    * @param fooId the primary key of the current foo
    * @param field1 the field1
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next foo
    * @throws com.test.SampleServiceBuilder.NoSuchFooException if a foo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.SampleServiceBuilder.model.Foo[] findByField1_PrevAndNext(
        long fooId, java.lang.String field1,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.test.SampleServiceBuilder.NoSuchFooException;

    /**
    * Returns all the foos where field1 = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.SampleServiceBuilder.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param field1s the field1s
    * @return the matching foos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.SampleServiceBuilder.model.Foo> findByField1(
        java.lang.String[] field1s)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the foos where field1 = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.SampleServiceBuilder.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param field1s the field1s
    * @param start the lower bound of the range of foos
    * @param end the upper bound of the range of foos (not inclusive)
    * @return the range of matching foos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.SampleServiceBuilder.model.Foo> findByField1(
        java.lang.String[] field1s, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the foos where field1 = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.SampleServiceBuilder.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param field1s the field1s
    * @param start the lower bound of the range of foos
    * @param end the upper bound of the range of foos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching foos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.SampleServiceBuilder.model.Foo> findByField1(
        java.lang.String[] field1s, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the foos where field1 = &#63; from the database.
    *
    * @param field1 the field1
    * @throws SystemException if a system exception occurred
    */
    public void removeByField1(java.lang.String field1)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of foos where field1 = &#63;.
    *
    * @param field1 the field1
    * @return the number of matching foos
    * @throws SystemException if a system exception occurred
    */
    public int countByField1(java.lang.String field1)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of foos where field1 = any &#63;.
    *
    * @param field1s the field1s
    * @return the number of matching foos
    * @throws SystemException if a system exception occurred
    */
    public int countByField1(java.lang.String[] field1s)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the foos where field2 = &#63;.
    *
    * @param field2 the field2
    * @return the matching foos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.SampleServiceBuilder.model.Foo> findByField2(
        boolean field2)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the foos where field2 = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.SampleServiceBuilder.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param field2 the field2
    * @param start the lower bound of the range of foos
    * @param end the upper bound of the range of foos (not inclusive)
    * @return the range of matching foos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.SampleServiceBuilder.model.Foo> findByField2(
        boolean field2, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the foos where field2 = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.SampleServiceBuilder.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param field2 the field2
    * @param start the lower bound of the range of foos
    * @param end the upper bound of the range of foos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching foos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.SampleServiceBuilder.model.Foo> findByField2(
        boolean field2, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first foo in the ordered set where field2 = &#63;.
    *
    * @param field2 the field2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching foo
    * @throws com.test.SampleServiceBuilder.NoSuchFooException if a matching foo could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.SampleServiceBuilder.model.Foo findByField2_First(
        boolean field2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.test.SampleServiceBuilder.NoSuchFooException;

    /**
    * Returns the first foo in the ordered set where field2 = &#63;.
    *
    * @param field2 the field2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching foo, or <code>null</code> if a matching foo could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.SampleServiceBuilder.model.Foo fetchByField2_First(
        boolean field2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last foo in the ordered set where field2 = &#63;.
    *
    * @param field2 the field2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching foo
    * @throws com.test.SampleServiceBuilder.NoSuchFooException if a matching foo could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.SampleServiceBuilder.model.Foo findByField2_Last(
        boolean field2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.test.SampleServiceBuilder.NoSuchFooException;

    /**
    * Returns the last foo in the ordered set where field2 = &#63;.
    *
    * @param field2 the field2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching foo, or <code>null</code> if a matching foo could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.SampleServiceBuilder.model.Foo fetchByField2_Last(
        boolean field2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the foos before and after the current foo in the ordered set where field2 = &#63;.
    *
    * @param fooId the primary key of the current foo
    * @param field2 the field2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next foo
    * @throws com.test.SampleServiceBuilder.NoSuchFooException if a foo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.SampleServiceBuilder.model.Foo[] findByField2_PrevAndNext(
        long fooId, boolean field2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.test.SampleServiceBuilder.NoSuchFooException;

    /**
    * Removes all the foos where field2 = &#63; from the database.
    *
    * @param field2 the field2
    * @throws SystemException if a system exception occurred
    */
    public void removeByField2(boolean field2)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of foos where field2 = &#63;.
    *
    * @param field2 the field2
    * @return the number of matching foos
    * @throws SystemException if a system exception occurred
    */
    public int countByField2(boolean field2)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the foo in the entity cache if it is enabled.
    *
    * @param foo the foo
    */
    public void cacheResult(com.test.SampleServiceBuilder.model.Foo foo);

    /**
    * Caches the foos in the entity cache if it is enabled.
    *
    * @param foos the foos
    */
    public void cacheResult(
        java.util.List<com.test.SampleServiceBuilder.model.Foo> foos);

    /**
    * Creates a new foo with the primary key. Does not add the foo to the database.
    *
    * @param fooId the primary key for the new foo
    * @return the new foo
    */
    public com.test.SampleServiceBuilder.model.Foo create(long fooId);

    /**
    * Removes the foo with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param fooId the primary key of the foo
    * @return the foo that was removed
    * @throws com.test.SampleServiceBuilder.NoSuchFooException if a foo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.SampleServiceBuilder.model.Foo remove(long fooId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.test.SampleServiceBuilder.NoSuchFooException;

    public com.test.SampleServiceBuilder.model.Foo updateImpl(
        com.test.SampleServiceBuilder.model.Foo foo)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the foo with the primary key or throws a {@link com.test.SampleServiceBuilder.NoSuchFooException} if it could not be found.
    *
    * @param fooId the primary key of the foo
    * @return the foo
    * @throws com.test.SampleServiceBuilder.NoSuchFooException if a foo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.SampleServiceBuilder.model.Foo findByPrimaryKey(long fooId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.test.SampleServiceBuilder.NoSuchFooException;

    /**
    * Returns the foo with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param fooId the primary key of the foo
    * @return the foo, or <code>null</code> if a foo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.test.SampleServiceBuilder.model.Foo fetchByPrimaryKey(long fooId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the foos.
    *
    * @return the foos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.SampleServiceBuilder.model.Foo> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the foos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.SampleServiceBuilder.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of foos
    * @param end the upper bound of the range of foos (not inclusive)
    * @return the range of foos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.SampleServiceBuilder.model.Foo> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the foos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.SampleServiceBuilder.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of foos
    * @param end the upper bound of the range of foos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of foos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.test.SampleServiceBuilder.model.Foo> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the foos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of foos.
    *
    * @return the number of foos
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
