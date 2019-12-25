package com.qding.eyecloud.search.service.impl;

import org.springframework.stereotype.Service;

import com.qding.eyecloud.search.service.IElasticLabelService;

/**
 * Desc:ES搜索-考评标签
 * Info:<功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * Date:2019年12月13日 上午9:59:04
 */
@Service("iElasticLabelService")
public class ElasticLabelServiceImpl implements IElasticLabelService {
    
    @Override
    public void createIndex() {
        
    }
    
    @Override
    public void deleteIndex(String index) {
        
    }
    
}
