package com.qding.eyecloud.common.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qding.eyecloud.base.BaseModel;

/**
 * Desc:map工具类
 * Info:<功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * Date:2019年12月2日 上午11:01:40
 */
public class MapUtils {
    
    public static Integer initSize(List<?> list) {
        return list == null ? 0 : list.size();
    }
    
    /**
     * Desc:List转换成map
     * Info:PECS原则
     * @param list
     * @return
     * @author tanshen@qding.me
     * Date:2019年12月2日 下午3:00:36
     */
    public Map<String, ? super BaseModel> listToMap(List<? extends BaseModel> list) {
        Map<String, ? super BaseModel> map = new HashMap<>(initSize(list));
        list.stream().forEach(item -> {
            map.put(item.getId(), item);
        });
        return map;
    }
}
