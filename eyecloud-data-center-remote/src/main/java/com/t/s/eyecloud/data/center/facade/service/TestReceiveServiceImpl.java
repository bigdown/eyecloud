package com.t.s.eyecloud.data.center.facade.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * description: <简述>
 * info: <详细信息>
 *
 * @author: tanshen@qding.me
 * @Date:
 * @since [产品/模块版本]
 */
public class TestReceiveServiceImpl implements IMqttReceiveService {

    private static final Logger logger = LoggerFactory.getLogger(TestReceiveServiceImpl.class);

    @Override
    public Map<String, String> handlerMqttMessage(String topic, String message) {
        logger.info("test topic {}, message {}", topic, message);
        return null;
    }
}
