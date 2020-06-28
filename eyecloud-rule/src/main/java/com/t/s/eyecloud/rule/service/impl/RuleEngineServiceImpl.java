package com.t.s.eyecloud.rule.service.impl;

import com.t.s.eyecloud.rule.entity.QueryParam;
import com.t.s.eyecloud.rule.service.RuleEngineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RuleEngineServiceImpl implements RuleEngineService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RuleEngineServiceImpl.class) ;

    @Override
    public void executeAddRule(QueryParam param) {
        LOGGER.info("参数数据:"+param.getParamId()+";"+param.getParamSign());
    }

    @Override
    public void executeRemoveRule(QueryParam param) {
        LOGGER.info("参数数据:"+param.getParamId()+";"+param.getParamSign());
    }
}
