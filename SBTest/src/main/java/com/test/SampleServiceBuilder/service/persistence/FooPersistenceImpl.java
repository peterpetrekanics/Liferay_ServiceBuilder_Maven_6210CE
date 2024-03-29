package com.test.SampleServiceBuilder.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.test.SampleServiceBuilder.NoSuchFooException;
import com.test.SampleServiceBuilder.model.Foo;
import com.test.SampleServiceBuilder.model.impl.FooImpl;
import com.test.SampleServiceBuilder.model.impl.FooModelImpl;
import com.test.SampleServiceBuilder.service.persistence.FooPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the foo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Joe Bloggs
 * @see FooPersistence
 * @see FooUtil
 * @generated
 */
public class FooPersistenceImpl extends BasePersistenceImpl<Foo>
    implements FooPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link FooUtil} to access the foo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = FooImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, FooImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, FooImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FIELD1 = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, FooImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByField1",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELD1 =
        new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, FooImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByField1",
            new String[] { String.class.getName() },
            FooModelImpl.FIELD1_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_FIELD1 = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByField1",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_FIELD1 = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByField1",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_FIELD1_FIELD1_1 = "foo.field1 IS NULL";
    private static final String _FINDER_COLUMN_FIELD1_FIELD1_2 = "foo.field1 = ?";
    private static final String _FINDER_COLUMN_FIELD1_FIELD1_3 = "(foo.field1 IS NULL OR foo.field1 = '')";
    private static final String _FINDER_COLUMN_FIELD1_FIELD1_4 = "(" +
        removeConjunction(_FINDER_COLUMN_FIELD1_FIELD1_1) + ")";
    private static final String _FINDER_COLUMN_FIELD1_FIELD1_5 = "(" +
        removeConjunction(_FINDER_COLUMN_FIELD1_FIELD1_2) + ")";
    private static final String _FINDER_COLUMN_FIELD1_FIELD1_6 = "(" +
        removeConjunction(_FINDER_COLUMN_FIELD1_FIELD1_3) + ")";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FIELD2 = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, FooImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByField2",
            new String[] {
                Boolean.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELD2 =
        new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, FooImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByField2",
            new String[] { Boolean.class.getName() },
            FooModelImpl.FIELD2_COLUMN_BITMASK |
            FooModelImpl.FIELD1_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_FIELD2 = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByField2",
            new String[] { Boolean.class.getName() });
    private static final String _FINDER_COLUMN_FIELD2_FIELD2_2 = "foo.field2 = ?";
    private static final String _SQL_SELECT_FOO = "SELECT foo FROM Foo foo";
    private static final String _SQL_SELECT_FOO_WHERE = "SELECT foo FROM Foo foo WHERE ";
    private static final String _SQL_COUNT_FOO = "SELECT COUNT(foo) FROM Foo foo";
    private static final String _SQL_COUNT_FOO_WHERE = "SELECT COUNT(foo) FROM Foo foo WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "foo.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Foo exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Foo exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(FooPersistenceImpl.class);
    private static Foo _nullFoo = new FooImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Foo> toCacheModel() {
                return _nullFooCacheModel;
            }
        };

    private static CacheModel<Foo> _nullFooCacheModel = new CacheModel<Foo>() {
            @Override
            public Foo toEntityModel() {
                return _nullFoo;
            }
        };

    public FooPersistenceImpl() {
        setModelClass(Foo.class);
    }

    /**
     * Returns all the foos where field1 = &#63;.
     *
     * @param field1 the field1
     * @return the matching foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Foo> findByField1(String field1) throws SystemException {
        return findByField1(field1, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Foo> findByField1(String field1, int start, int end)
        throws SystemException {
        return findByField1(field1, start, end, null);
    }

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
    @Override
    public List<Foo> findByField1(String field1, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELD1;
            finderArgs = new Object[] { field1 };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FIELD1;
            finderArgs = new Object[] { field1, start, end, orderByComparator };
        }

        List<Foo> list = (List<Foo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Foo foo : list) {
                if (!Validator.equals(field1, foo.getField1())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_FOO_WHERE);

            boolean bindField1 = false;

            if (field1 == null) {
                query.append(_FINDER_COLUMN_FIELD1_FIELD1_1);
            } else if (field1.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_FIELD1_FIELD1_3);
            } else {
                bindField1 = true;

                query.append(_FINDER_COLUMN_FIELD1_FIELD1_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(FooModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindField1) {
                    qPos.add(field1);
                }

                if (!pagination) {
                    list = (List<Foo>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Foo>(list);
                } else {
                    list = (List<Foo>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first foo in the ordered set where field1 = &#63;.
     *
     * @param field1 the field1
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching foo
     * @throws com.test.SampleServiceBuilder.NoSuchFooException if a matching foo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo findByField1_First(String field1,
        OrderByComparator orderByComparator)
        throws NoSuchFooException, SystemException {
        Foo foo = fetchByField1_First(field1, orderByComparator);

        if (foo != null) {
            return foo;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("field1=");
        msg.append(field1);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFooException(msg.toString());
    }

    /**
     * Returns the first foo in the ordered set where field1 = &#63;.
     *
     * @param field1 the field1
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching foo, or <code>null</code> if a matching foo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo fetchByField1_First(String field1,
        OrderByComparator orderByComparator) throws SystemException {
        List<Foo> list = findByField1(field1, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last foo in the ordered set where field1 = &#63;.
     *
     * @param field1 the field1
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching foo
     * @throws com.test.SampleServiceBuilder.NoSuchFooException if a matching foo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo findByField1_Last(String field1,
        OrderByComparator orderByComparator)
        throws NoSuchFooException, SystemException {
        Foo foo = fetchByField1_Last(field1, orderByComparator);

        if (foo != null) {
            return foo;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("field1=");
        msg.append(field1);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFooException(msg.toString());
    }

    /**
     * Returns the last foo in the ordered set where field1 = &#63;.
     *
     * @param field1 the field1
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching foo, or <code>null</code> if a matching foo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo fetchByField1_Last(String field1,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByField1(field1);

        if (count == 0) {
            return null;
        }

        List<Foo> list = findByField1(field1, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Foo[] findByField1_PrevAndNext(long fooId, String field1,
        OrderByComparator orderByComparator)
        throws NoSuchFooException, SystemException {
        Foo foo = findByPrimaryKey(fooId);

        Session session = null;

        try {
            session = openSession();

            Foo[] array = new FooImpl[3];

            array[0] = getByField1_PrevAndNext(session, foo, field1,
                    orderByComparator, true);

            array[1] = foo;

            array[2] = getByField1_PrevAndNext(session, foo, field1,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Foo getByField1_PrevAndNext(Session session, Foo foo,
        String field1, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_FOO_WHERE);

        boolean bindField1 = false;

        if (field1 == null) {
            query.append(_FINDER_COLUMN_FIELD1_FIELD1_1);
        } else if (field1.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_FIELD1_FIELD1_3);
        } else {
            bindField1 = true;

            query.append(_FINDER_COLUMN_FIELD1_FIELD1_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(FooModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindField1) {
            qPos.add(field1);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(foo);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Foo> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

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
    @Override
    public List<Foo> findByField1(String[] field1s) throws SystemException {
        return findByField1(field1s, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Foo> findByField1(String[] field1s, int start, int end)
        throws SystemException {
        return findByField1(field1s, start, end, null);
    }

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
    @Override
    public List<Foo> findByField1(String[] field1s, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        if ((field1s != null) && (field1s.length == 1)) {
            return findByField1(field1s[0], start, end, orderByComparator);
        }

        boolean pagination = true;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderArgs = new Object[] { StringUtil.merge(field1s) };
        } else {
            finderArgs = new Object[] {
                    StringUtil.merge(field1s),
                    
                    start, end, orderByComparator
                };
        }

        List<Foo> list = (List<Foo>) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_FIELD1,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Foo foo : list) {
                if (!ArrayUtil.contains(field1s, foo.getField1())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_SELECT_FOO_WHERE);

            boolean conjunctionable = false;

            if ((field1s == null) || (field1s.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < field1s.length; i++) {
                    String field1 = field1s[i];

                    if (field1 == null) {
                        query.append(_FINDER_COLUMN_FIELD1_FIELD1_4);
                    } else if (field1.equals(StringPool.BLANK)) {
                        query.append(_FINDER_COLUMN_FIELD1_FIELD1_6);
                    } else {
                        query.append(_FINDER_COLUMN_FIELD1_FIELD1_5);
                    }

                    if ((i + 1) < field1s.length) {
                        query.append(WHERE_OR);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(FooModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (field1s != null) {
                    qPos.add(field1s);
                }

                if (!pagination) {
                    list = (List<Foo>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Foo>(list);
                } else {
                    list = (List<Foo>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_FIELD1,
                    finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_FIELD1,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the foos where field1 = &#63; from the database.
     *
     * @param field1 the field1
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByField1(String field1) throws SystemException {
        for (Foo foo : findByField1(field1, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(foo);
        }
    }

    /**
     * Returns the number of foos where field1 = &#63;.
     *
     * @param field1 the field1
     * @return the number of matching foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByField1(String field1) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_FIELD1;

        Object[] finderArgs = new Object[] { field1 };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_FOO_WHERE);

            boolean bindField1 = false;

            if (field1 == null) {
                query.append(_FINDER_COLUMN_FIELD1_FIELD1_1);
            } else if (field1.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_FIELD1_FIELD1_3);
            } else {
                bindField1 = true;

                query.append(_FINDER_COLUMN_FIELD1_FIELD1_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindField1) {
                    qPos.add(field1);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of foos where field1 = any &#63;.
     *
     * @param field1s the field1s
     * @return the number of matching foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByField1(String[] field1s) throws SystemException {
        Object[] finderArgs = new Object[] { StringUtil.merge(field1s) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_FIELD1,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_COUNT_FOO_WHERE);

            boolean conjunctionable = false;

            if ((field1s == null) || (field1s.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < field1s.length; i++) {
                    String field1 = field1s[i];

                    if (field1 == null) {
                        query.append(_FINDER_COLUMN_FIELD1_FIELD1_4);
                    } else if (field1.equals(StringPool.BLANK)) {
                        query.append(_FINDER_COLUMN_FIELD1_FIELD1_6);
                    } else {
                        query.append(_FINDER_COLUMN_FIELD1_FIELD1_5);
                    }

                    if ((i + 1) < field1s.length) {
                        query.append(WHERE_OR);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (field1s != null) {
                    qPos.add(field1s);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_FIELD1,
                    finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_FIELD1,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the foos where field2 = &#63;.
     *
     * @param field2 the field2
     * @return the matching foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Foo> findByField2(boolean field2) throws SystemException {
        return findByField2(field2, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Foo> findByField2(boolean field2, int start, int end)
        throws SystemException {
        return findByField2(field2, start, end, null);
    }

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
    @Override
    public List<Foo> findByField2(boolean field2, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELD2;
            finderArgs = new Object[] { field2 };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FIELD2;
            finderArgs = new Object[] { field2, start, end, orderByComparator };
        }

        List<Foo> list = (List<Foo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Foo foo : list) {
                if ((field2 != foo.getField2())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_FOO_WHERE);

            query.append(_FINDER_COLUMN_FIELD2_FIELD2_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(FooModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(field2);

                if (!pagination) {
                    list = (List<Foo>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Foo>(list);
                } else {
                    list = (List<Foo>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first foo in the ordered set where field2 = &#63;.
     *
     * @param field2 the field2
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching foo
     * @throws com.test.SampleServiceBuilder.NoSuchFooException if a matching foo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo findByField2_First(boolean field2,
        OrderByComparator orderByComparator)
        throws NoSuchFooException, SystemException {
        Foo foo = fetchByField2_First(field2, orderByComparator);

        if (foo != null) {
            return foo;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("field2=");
        msg.append(field2);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFooException(msg.toString());
    }

    /**
     * Returns the first foo in the ordered set where field2 = &#63;.
     *
     * @param field2 the field2
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching foo, or <code>null</code> if a matching foo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo fetchByField2_First(boolean field2,
        OrderByComparator orderByComparator) throws SystemException {
        List<Foo> list = findByField2(field2, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last foo in the ordered set where field2 = &#63;.
     *
     * @param field2 the field2
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching foo
     * @throws com.test.SampleServiceBuilder.NoSuchFooException if a matching foo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo findByField2_Last(boolean field2,
        OrderByComparator orderByComparator)
        throws NoSuchFooException, SystemException {
        Foo foo = fetchByField2_Last(field2, orderByComparator);

        if (foo != null) {
            return foo;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("field2=");
        msg.append(field2);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFooException(msg.toString());
    }

    /**
     * Returns the last foo in the ordered set where field2 = &#63;.
     *
     * @param field2 the field2
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching foo, or <code>null</code> if a matching foo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo fetchByField2_Last(boolean field2,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByField2(field2);

        if (count == 0) {
            return null;
        }

        List<Foo> list = findByField2(field2, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Foo[] findByField2_PrevAndNext(long fooId, boolean field2,
        OrderByComparator orderByComparator)
        throws NoSuchFooException, SystemException {
        Foo foo = findByPrimaryKey(fooId);

        Session session = null;

        try {
            session = openSession();

            Foo[] array = new FooImpl[3];

            array[0] = getByField2_PrevAndNext(session, foo, field2,
                    orderByComparator, true);

            array[1] = foo;

            array[2] = getByField2_PrevAndNext(session, foo, field2,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Foo getByField2_PrevAndNext(Session session, Foo foo,
        boolean field2, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_FOO_WHERE);

        query.append(_FINDER_COLUMN_FIELD2_FIELD2_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(FooModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(field2);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(foo);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Foo> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the foos where field2 = &#63; from the database.
     *
     * @param field2 the field2
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByField2(boolean field2) throws SystemException {
        for (Foo foo : findByField2(field2, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(foo);
        }
    }

    /**
     * Returns the number of foos where field2 = &#63;.
     *
     * @param field2 the field2
     * @return the number of matching foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByField2(boolean field2) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_FIELD2;

        Object[] finderArgs = new Object[] { field2 };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_FOO_WHERE);

            query.append(_FINDER_COLUMN_FIELD2_FIELD2_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(field2);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the foo in the entity cache if it is enabled.
     *
     * @param foo the foo
     */
    @Override
    public void cacheResult(Foo foo) {
        EntityCacheUtil.putResult(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooImpl.class, foo.getPrimaryKey(), foo);

        foo.resetOriginalValues();
    }

    /**
     * Caches the foos in the entity cache if it is enabled.
     *
     * @param foos the foos
     */
    @Override
    public void cacheResult(List<Foo> foos) {
        for (Foo foo : foos) {
            if (EntityCacheUtil.getResult(FooModelImpl.ENTITY_CACHE_ENABLED,
                        FooImpl.class, foo.getPrimaryKey()) == null) {
                cacheResult(foo);
            } else {
                foo.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all foos.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(FooImpl.class.getName());
        }

        EntityCacheUtil.clearCache(FooImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the foo.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Foo foo) {
        EntityCacheUtil.removeResult(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooImpl.class, foo.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Foo> foos) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Foo foo : foos) {
            EntityCacheUtil.removeResult(FooModelImpl.ENTITY_CACHE_ENABLED,
                FooImpl.class, foo.getPrimaryKey());
        }
    }

    /**
     * Creates a new foo with the primary key. Does not add the foo to the database.
     *
     * @param fooId the primary key for the new foo
     * @return the new foo
     */
    @Override
    public Foo create(long fooId) {
        Foo foo = new FooImpl();

        foo.setNew(true);
        foo.setPrimaryKey(fooId);

        return foo;
    }

    /**
     * Removes the foo with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param fooId the primary key of the foo
     * @return the foo that was removed
     * @throws com.test.SampleServiceBuilder.NoSuchFooException if a foo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo remove(long fooId) throws NoSuchFooException, SystemException {
        return remove((Serializable) fooId);
    }

    /**
     * Removes the foo with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the foo
     * @return the foo that was removed
     * @throws com.test.SampleServiceBuilder.NoSuchFooException if a foo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo remove(Serializable primaryKey)
        throws NoSuchFooException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Foo foo = (Foo) session.get(FooImpl.class, primaryKey);

            if (foo == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchFooException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(foo);
        } catch (NoSuchFooException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Foo removeImpl(Foo foo) throws SystemException {
        foo = toUnwrappedModel(foo);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(foo)) {
                foo = (Foo) session.get(FooImpl.class, foo.getPrimaryKeyObj());
            }

            if (foo != null) {
                session.delete(foo);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (foo != null) {
            clearCache(foo);
        }

        return foo;
    }

    @Override
    public Foo updateImpl(com.test.SampleServiceBuilder.model.Foo foo)
        throws SystemException {
        foo = toUnwrappedModel(foo);

        boolean isNew = foo.isNew();

        FooModelImpl fooModelImpl = (FooModelImpl) foo;

        Session session = null;

        try {
            session = openSession();

            if (foo.isNew()) {
                session.save(foo);

                foo.setNew(false);
            } else {
                session.merge(foo);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !FooModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((fooModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELD1.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { fooModelImpl.getOriginalField1() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIELD1, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELD1,
                    args);

                args = new Object[] { fooModelImpl.getField1() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIELD1, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELD1,
                    args);
            }

            if ((fooModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELD2.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { fooModelImpl.getOriginalField2() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIELD2, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELD2,
                    args);

                args = new Object[] { fooModelImpl.getField2() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIELD2, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELD2,
                    args);
            }
        }

        EntityCacheUtil.putResult(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooImpl.class, foo.getPrimaryKey(), foo);

        return foo;
    }

    protected Foo toUnwrappedModel(Foo foo) {
        if (foo instanceof FooImpl) {
            return foo;
        }

        FooImpl fooImpl = new FooImpl();

        fooImpl.setNew(foo.isNew());
        fooImpl.setPrimaryKey(foo.getPrimaryKey());

        fooImpl.setFooId(foo.getFooId());
        fooImpl.setGroupId(foo.getGroupId());
        fooImpl.setCompanyId(foo.getCompanyId());
        fooImpl.setUserId(foo.getUserId());
        fooImpl.setUserName(foo.getUserName());
        fooImpl.setCreateDate(foo.getCreateDate());
        fooImpl.setModifiedDate(foo.getModifiedDate());
        fooImpl.setField1(foo.getField1());
        fooImpl.setField2(foo.isField2());
        fooImpl.setField3(foo.getField3());
        fooImpl.setField4(foo.getField4());
        fooImpl.setField5(foo.getField5());

        return fooImpl;
    }

    /**
     * Returns the foo with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the foo
     * @return the foo
     * @throws com.test.SampleServiceBuilder.NoSuchFooException if a foo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo findByPrimaryKey(Serializable primaryKey)
        throws NoSuchFooException, SystemException {
        Foo foo = fetchByPrimaryKey(primaryKey);

        if (foo == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchFooException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return foo;
    }

    /**
     * Returns the foo with the primary key or throws a {@link com.test.SampleServiceBuilder.NoSuchFooException} if it could not be found.
     *
     * @param fooId the primary key of the foo
     * @return the foo
     * @throws com.test.SampleServiceBuilder.NoSuchFooException if a foo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo findByPrimaryKey(long fooId)
        throws NoSuchFooException, SystemException {
        return findByPrimaryKey((Serializable) fooId);
    }

    /**
     * Returns the foo with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the foo
     * @return the foo, or <code>null</code> if a foo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Foo foo = (Foo) EntityCacheUtil.getResult(FooModelImpl.ENTITY_CACHE_ENABLED,
                FooImpl.class, primaryKey);

        if (foo == _nullFoo) {
            return null;
        }

        if (foo == null) {
            Session session = null;

            try {
                session = openSession();

                foo = (Foo) session.get(FooImpl.class, primaryKey);

                if (foo != null) {
                    cacheResult(foo);
                } else {
                    EntityCacheUtil.putResult(FooModelImpl.ENTITY_CACHE_ENABLED,
                        FooImpl.class, primaryKey, _nullFoo);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(FooModelImpl.ENTITY_CACHE_ENABLED,
                    FooImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return foo;
    }

    /**
     * Returns the foo with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param fooId the primary key of the foo
     * @return the foo, or <code>null</code> if a foo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo fetchByPrimaryKey(long fooId) throws SystemException {
        return fetchByPrimaryKey((Serializable) fooId);
    }

    /**
     * Returns all the foos.
     *
     * @return the foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Foo> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Foo> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<Foo> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Foo> list = (List<Foo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_FOO);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_FOO;

                if (pagination) {
                    sql = sql.concat(FooModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Foo>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Foo>(list);
                } else {
                    list = (List<Foo>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the foos from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Foo foo : findAll()) {
            remove(foo);
        }
    }

    /**
     * Returns the number of foos.
     *
     * @return the number of foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_FOO);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the foo persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.test.SampleServiceBuilder.model.Foo")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Foo>> listenersList = new ArrayList<ModelListener<Foo>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Foo>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(FooImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
