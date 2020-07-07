package com.t.s.eyecloud.data.center.remote.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.t.s.eyeclod.data.center.facade.IModelFacade;
import com.t.s.eyecloud.data.center.remote.config.MqttConfig;
import com.t.s.eyecloud.data.center.remote.service.IMqttReceiveService;
import com.t.s.eyecloud.data.center.remote.service.TestReceiveServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description: <简述>
 * info: <详细信息>
 *
 * @author: tanshen@qding.me
 * @Date:
 * @since [产品/模块版本]
 */
@Service(interfaceClass = IModelFacade.class)
public class ModelFacadeProvider implements IModelFacade {

    @Autowired
    private MqttConfig mqttConfig;

    @Override
    public Map<String, String> addModel(Map<String, String> map) {
        mqttConfig.addListenTopic(map.get("topic"), new TestReceiveServiceImpl());
        return map;
    }

    @Override
    public List<Map<String, String>> listModel() {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, IMqttReceiveService> map = mqttConfig.getLocalMap();
        for (Map.Entry<String, IMqttReceiveService> entry : map.entrySet()) {
            Map<String, String> item = new HashMap<>();
            item.put("topic", entry.getKey());
            list.add(item);
        }
        return list;
    }

    @Override
    public boolean removeModel(String topic) {
        mqttConfig.removeListenTopic(topic);
        return true;
    }
}
