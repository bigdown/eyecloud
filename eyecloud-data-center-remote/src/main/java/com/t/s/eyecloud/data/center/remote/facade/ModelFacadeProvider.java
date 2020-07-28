package com.t.s.eyecloud.data.center.remote.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.t.s.eyeclod.data.center.facade.IModelFacade;
import com.t.s.eyecloud.common.utils.SnowFlake;
import com.t.s.eyecloud.dao.IBaseProductDao;
import com.t.s.eyecloud.data.center.remote.config.MqttConfig;
import com.t.s.eyecloud.data.center.remote.service.IMqttReceiveService;
import com.t.s.eyecloud.data.center.remote.service.TestReceiveServiceImpl;
import com.t.s.eyecloud.model.BaseProduct;
import com.t.s.eyecloud.model.BaseProductProperty;
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

    @Autowired
    private IBaseProductDao iBaseProductDao;

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

    @Override
    public BaseProduct addProduct(BaseProduct baseProduct) {
        baseProduct.setId(SnowFlake.createSnowFlake().nextIdString());
        iBaseProductDao.save(baseProduct);
        return baseProduct;
    }

    @Override
    public List<BaseProduct> listProduct(BaseProduct baseProduct) {
        return iBaseProductDao.list(Wrappers.lambdaQuery(baseProduct));
    }

    @Override
    public Boolean batchAddProductProperty(List<BaseProductProperty> baseProductProperties) {
        return null;
    }
}
