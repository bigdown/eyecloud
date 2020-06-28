package com.t.s.eyecloud.search;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.t.s.eyecloud.search.service.IElasticLabelService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchRemoteApplication.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class SearchTests {
    
    @Autowired
    private IElasticLabelService iElasticLabelService;
    
    @Test
    public void createIndexTest() {
        iElasticLabelService.createIndex();
        for (int i = 0; i < 100; i++) {
            saveTest(i); 
        }
    }
    
//    @Test
    public void saveTest(int index) {
    }
    
    @Test
    public void findAllTest() throws IOException {
        
    }
    
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
            RestClient.builder(
                    new HttpHost("localhost", 9200, "http")));
        GetRequest getRequest = new GetRequest("doclabel", "ONxI_W4BNjFVlQrkhv5u");
        GetResponse response = client.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(response);
    }
}
