package com.qding.eyecloud.web.service.model;

import com.alibaba.fastjson.JSONObject;

/**
 * description: <简述>
 * info: <详细信息>
 *
 * @author: tanshen@qding.me
 * @Date:
 * @since [产品/模块版本]
 */

/**
 *     {
 * 	       "id": "aaa",
 * 	       "name": "代码生成json",
 * 	       "json": {
 * 		       "swagger": "2.0",
 * 		       "info": {
 * 			        "contact": {
 * 				        "name": "Wilson Support",
 * 				        "url": "http://www.baidu.com",
 * 				        "email": "support@wilson.com"
 *                  },
 * 			        "description": "代码生成json",
 * 			        "title": "我的Swagger REST API",
 * 			        "version": "0.0.1"*
 * 			    },
 * 		        "basePath": "/v1",
 * 		        "host": "127.0.0.1:8080",
 * 		        "schemes": ["http"]
 * 	        }
 *     }
 */
public class SwaggerBody {
    private String id;
    private String name;
    private JSONObject json;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JSONObject getJson() {
        return json;
    }

    public void setJson(JSONObject json) {
        this.json = json;
    }
}
