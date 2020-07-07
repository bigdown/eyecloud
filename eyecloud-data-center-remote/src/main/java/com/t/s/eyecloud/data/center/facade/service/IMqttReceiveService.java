package com.t.s.eyecloud.data.center.facade.service;

import java.util.Map;

/**
 * description: <简述>
 * info: <详细信息>
 *
 * @author: tanshen@qding.me
 * @Date:
 * @since [产品/模块版本]
 */
public interface IMqttReceiveService {

    Map<String, String> handlerMqttMessage(String topic, String message);
}
