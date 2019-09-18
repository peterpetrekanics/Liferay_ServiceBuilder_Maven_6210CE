package com.test.SampleServiceBuilder.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;
import com.liferay.portlet.asset.service.persistence.AssetTagPersistence;

import com.test.SampleServiceBuilder.model.Foo;
import com.test.SampleServiceBuilder.service.FooLocalService;
import com.test.SampleServiceBuilder.service.persistence.FooPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the foo local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.test.SampleServiceBuilder.service.impl.FooLocalServiceImpl}.
 * </p>
 *
 * @author Joe Bloggs
 * @see com.test.SampleServiceBuilder.service.impl.FooLocalServiceImpl
 * @see com.test.SampleServiceBuilder.service.FooLocalServiceUtil
 * @generated
 */
public abstract class FooLocalServiceBaseImpl extends BaseLocalServiceImpl
    implements FooLocalService, IdentifiableBean {
    @BeanReference(type = com.test.SampleServiceBuilder.service.FooLocalService.class)
    protected com.test.SampleServiceBuilder.service.FooLocalService fooLocalService;
    @BeanReference(type = com.test.SampleServiceBuilder.service.FooService.class)
    protected com.test.SampleServiceBuilder.service.FooService fooService;
    @BeanReference(type = FooPersistence.class)
    protected FooPersistence fooPersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    @BeanReference(type = com.liferay.portlet.asset.service.AssetEntryLocalService.class)
    protected com.liferay.portlet.asset.service.AssetEntryLocalService assetEntryLocalService;
    @BeanReference(type = com.liferay.portlet.asset.service.AssetEntryService.class)
    protected com.liferay.portlet.asset.service.AssetEntryService assetEntryService;
    @BeanReference(type = AssetEntryPersistence.class)
    protected AssetEntryPersistence assetEntryPersistence;
    @BeanReference(type = com.liferay.portlet.asset.service.AssetTagLocalService.class)
    protected com.liferay.portlet.asset.service.AssetTagLocalService assetTagLocalService;
    @BeanReference(type = com.liferay.portlet.asset.service.AssetTagService.class)
    protected com.liferay.portlet.asset.service.AssetTagService assetTagService;
    @BeanReference(type = AssetTagPersistence.class)
    protected AssetTagPersistence assetTagPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private FooLocalServiceClpInvoker _clpInvoker = new FooLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.test.SampleServiceBuilder.service.FooLocalServiceUtil} to access the foo local service.
     */

    /**
     * Adds the foo to the database. Also notifies the appropriate model listeners.
     *
     * @param foo the foo
     * @return the foo that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Foo addFoo(Foo foo) throws SystemException {
        foo.setNew(true);

        return fooPersistence.update(foo);
    }

    /**
     * Creates a new foo with the primary key. Does not add the foo to the database.
     *
     * @param fooId the primary key for the new foo
     * @return the new foo
     */
    @Override
    public Foo createFoo(long fooId) {
        return fooPersistence.create(fooId);
    }

    /**
     * Deletes the foo with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param fooId the primary key of the foo
     * @return the foo that was removed
     * @throws PortalException if a foo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Foo deleteFoo(long fooId) throws PortalException, SystemException {
        return fooPersistence.remove(fooId);
    }

    /**
     * Deletes the foo from the database. Also notifies the appropriate model listeners.
     *
     * @param foo the foo
     * @return the foo that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Foo deleteFoo(Foo foo) throws SystemException {
        return fooPersistence.remove(foo);
    }

    @Override
    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(Foo.class,
            clazz.getClassLoader());
    }

    /**
     * Performs a dynamic query on the database and returns the matching rows.
     *
     * @param dynamicQuery the dynamic query
     * @return the matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return fooPersistence.findWithDynamicQuery(dynamicQuery);
    }

    /**
     * Performs a dynamic query on the database and returns a range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.SampleServiceBuilder.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @return the range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return fooPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * Performs a dynamic query on the database and returns an ordered range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.SampleServiceBuilder.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return fooPersistence.findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return fooPersistence.countWithDynamicQuery(dynamicQuery);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @param projection the projection to apply to the query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery,
        Projection projection) throws SystemException {
        return fooPersistence.countWithDynamicQuery(dynamicQuery, projection);
    }

    @Override
    public Foo fetchFoo(long fooId) throws SystemException {
        return fooPersistence.fetchByPrimaryKey(fooId);
    }

    /**
     * Returns the foo with the primary key.
     *
     * @param fooId the primary key of the foo
     * @return the foo
     * @throws PortalException if a foo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo getFoo(long fooId) throws PortalException, SystemException {
        return fooPersistence.findByPrimaryKey(fooId);
    }

    @Override
    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return fooPersistence.findByPrimaryKey(primaryKeyObj);
    }

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
    @Override
    public List<Foo> getFoos(int start, int end) throws SystemException {
        return fooPersistence.findAll(start, end);
    }

    /**
     * Returns the number of foos.
     *
     * @return the number of foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getFoosCount() throws SystemException {
        return fooPersistence.countAll();
    }

    /**
     * Updates the foo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param foo the foo
     * @return the foo that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Foo updateFoo(Foo foo) throws SystemException {
        return fooPersistence.update(foo);
    }

    /**
     * Returns the foo local service.
     *
     * @return the foo local service
     */
    public com.test.SampleServiceBuilder.service.FooLocalService getFooLocalService() {
        return fooLocalService;
    }

    /**
     * Sets the foo local service.
     *
     * @param fooLocalService the foo local service
     */
    public void setFooLocalService(
        com.test.SampleServiceBuilder.service.FooLocalService fooLocalService) {
        this.fooLocalService = fooLocalService;
    }

    /**
     * Returns the foo remote service.
     *
     * @return the foo remote service
     */
    public com.test.SampleServiceBuilder.service.FooService getFooService() {
        return fooService;
    }

    /**
     * Sets the foo remote service.
     *
     * @param fooService the foo remote service
     */
    public void setFooService(
        com.test.SampleServiceBuilder.service.FooService fooService) {
        this.fooService = fooService;
    }

    /**
     * Returns the foo persistence.
     *
     * @return the foo persistence
     */
    public FooPersistence getFooPersistence() {
        return fooPersistence;
    }

    /**
     * Sets the foo persistence.
     *
     * @param fooPersistence the foo persistence
     */
    public void setFooPersistence(FooPersistence fooPersistence) {
        this.fooPersistence = fooPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    /**
     * Returns the asset entry local service.
     *
     * @return the asset entry local service
     */
    public com.liferay.portlet.asset.service.AssetEntryLocalService getAssetEntryLocalService() {
        return assetEntryLocalService;
    }

    /**
     * Sets the asset entry local service.
     *
     * @param assetEntryLocalService the asset entry local service
     */
    public void setAssetEntryLocalService(
        com.liferay.portlet.asset.service.AssetEntryLocalService assetEntryLocalService) {
        this.assetEntryLocalService = assetEntryLocalService;
    }

    /**
     * Returns the asset entry remote service.
     *
     * @return the asset entry remote service
     */
    public com.liferay.portlet.asset.service.AssetEntryService getAssetEntryService() {
        return assetEntryService;
    }

    /**
     * Sets the asset entry remote service.
     *
     * @param assetEntryService the asset entry remote service
     */
    public void setAssetEntryService(
        com.liferay.portlet.asset.service.AssetEntryService assetEntryService) {
        this.assetEntryService = assetEntryService;
    }

    /**
     * Returns the asset entry persistence.
     *
     * @return the asset entry persistence
     */
    public AssetEntryPersistence getAssetEntryPersistence() {
        return assetEntryPersistence;
    }

    /**
     * Sets the asset entry persistence.
     *
     * @param assetEntryPersistence the asset entry persistence
     */
    public void setAssetEntryPersistence(
        AssetEntryPersistence assetEntryPersistence) {
        this.assetEntryPersistence = assetEntryPersistence;
    }

    /**
     * Returns the asset tag local service.
     *
     * @return the asset tag local service
     */
    public com.liferay.portlet.asset.service.AssetTagLocalService getAssetTagLocalService() {
        return assetTagLocalService;
    }

    /**
     * Sets the asset tag local service.
     *
     * @param assetTagLocalService the asset tag local service
     */
    public void setAssetTagLocalService(
        com.liferay.portlet.asset.service.AssetTagLocalService assetTagLocalService) {
        this.assetTagLocalService = assetTagLocalService;
    }

    /**
     * Returns the asset tag remote service.
     *
     * @return the asset tag remote service
     */
    public com.liferay.portlet.asset.service.AssetTagService getAssetTagService() {
        return assetTagService;
    }

    /**
     * Sets the asset tag remote service.
     *
     * @param assetTagService the asset tag remote service
     */
    public void setAssetTagService(
        com.liferay.portlet.asset.service.AssetTagService assetTagService) {
        this.assetTagService = assetTagService;
    }

    /**
     * Returns the asset tag persistence.
     *
     * @return the asset tag persistence
     */
    public AssetTagPersistence getAssetTagPersistence() {
        return assetTagPersistence;
    }

    /**
     * Sets the asset tag persistence.
     *
     * @param assetTagPersistence the asset tag persistence
     */
    public void setAssetTagPersistence(AssetTagPersistence assetTagPersistence) {
        this.assetTagPersistence = assetTagPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();

        PersistedModelLocalServiceRegistryUtil.register("com.test.SampleServiceBuilder.model.Foo",
            fooLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "com.test.SampleServiceBuilder.model.Foo");
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return Foo.class;
    }

    protected String getModelClassName() {
        return Foo.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = fooPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
