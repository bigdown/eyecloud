package com.t.s.eyecloud.rule.service;


import com.t.s.eyecloud.rule.entity.QueryParam;

public interface RuleEngineService {
    void executeAddRule(QueryParam param) ;
    void executeRemoveRule(QueryParam param) ;
}
