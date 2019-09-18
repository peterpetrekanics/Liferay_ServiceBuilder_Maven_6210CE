package com.test.SampleServiceBuilder.service.impl;

import com.test.SampleServiceBuilder.service.base.FooLocalServiceBaseImpl;

/**
 * The implementation of the foo local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.test.SampleServiceBuilder.service.FooLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Joe Bloggs
 * @see com.test.SampleServiceBuilder.service.base.FooLocalServiceBaseImpl
 * @see com.test.SampleServiceBuilder.service.FooLocalServiceUtil
 */
public class FooLocalServiceImpl extends FooLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.test.SampleServiceBuilder.service.FooLocalServiceUtil} to access the foo local service.
     */
}
