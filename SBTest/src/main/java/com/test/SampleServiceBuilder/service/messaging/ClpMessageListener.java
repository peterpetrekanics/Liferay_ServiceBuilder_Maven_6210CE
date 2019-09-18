package com.test.SampleServiceBuilder.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.test.SampleServiceBuilder.service.ClpSerializer;
import com.test.SampleServiceBuilder.service.FooLocalServiceUtil;
import com.test.SampleServiceBuilder.service.FooServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            FooLocalServiceUtil.clearService();

            FooServiceUtil.clearService();
        }
    }
}
