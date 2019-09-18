package com.test.SampleServiceBuilder.service.impl;

import com.test.SampleServiceBuilder.service.base.FooServiceBaseImpl;

/**
 * The implementation of the foo remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.test.SampleServiceBuilder.service.FooService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Joe Bloggs
 * @see com.test.SampleServiceBuilder.service.base.FooServiceBaseImpl
 * @see com.test.SampleServiceBuilder.service.FooServiceUtil
 */
public class FooServiceImpl extends FooServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.test.SampleServiceBuilder.service.FooServiceUtil} to access the foo remote service.
     */
}
