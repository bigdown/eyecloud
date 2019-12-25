package com.qding.eyecloud.auth.remote.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.qding.eyecloud.common.data.response.auth.AuthOperateVO;
import com.qding.eyecloud.model.AuthMenuOperate;

public class MapUtils {
    
    private MapUtils() {
    }
    
    public static Map<String, List<AuthOperateVO>> listToMapForOperate(List<AuthMenuOperate> list) {
        Map<String, List<AuthOperateVO>> map = new HashMap<>();
        
        for (AuthMenuOperate item : list) {
            List<AuthOperateVO> itemList = map.get(item.getMenuId());
            if (CollectionUtils.isEmpty(itemList)) {
                itemList = new ArrayList<>();
            }
            AuthOperateVO authOperateVO = new AuthOperateVO();
            BeanUtils.copyProperties(item, authOperateVO);
            itemList.add(authOperateVO);
            
            map.put(item.getMenuId(), itemList);
        }
        
        return map;
    }
    
}
