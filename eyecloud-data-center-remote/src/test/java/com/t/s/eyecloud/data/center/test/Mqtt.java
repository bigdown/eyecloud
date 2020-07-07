package com.t.s.eyecloud.data.center.test;

import com.t.s.eyecloud.data.center.facade.DataCenterRemoteApplication;
import com.t.s.eyecloud.data.center.facade.service.MqttGateway;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * description: <简述>
 * info: <详细信息>
 *
 * @author: tanshen@qding.me
 * @Date:
 * @since [产品/模块版本]
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DataCenterRemoteApplication.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class Mqtt {

    @Autowired
    private MqttGateway mqttGateway;

    @Test
    public void sendToMqttTest() {

        mqttGateway.sendToMqtt("topic", "hello");
    }

}
