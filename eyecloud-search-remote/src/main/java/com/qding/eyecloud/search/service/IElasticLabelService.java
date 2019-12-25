package com.qding.eyecloud.search.service;

public interface IElasticLabelService {
    void createIndex();
    
    void deleteIndex(String index);
    
}
