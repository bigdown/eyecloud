package com.t.s.eyecloud.search.service;

public interface IElasticLabelService {
    void createIndex();
    
    void deleteIndex(String index);
    
}
