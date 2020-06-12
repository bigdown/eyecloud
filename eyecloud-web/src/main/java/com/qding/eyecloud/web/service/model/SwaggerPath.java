package com.qding.eyecloud.web.service.model;

import com.alibaba.fastjson.JSONObject;

/**
 * description: <简述>
 *     {
 * 	       "id": "1",
 * 	       "swaggerId": "aaa",
 * 	       "json": {
 * 	           "/users": {
 * 		           "get": {
 * 			           "summary": "查询用户",
 * 			           "tags": ["tag1"],
 * 			           "produces": ["application/json"],
 *      	           "consumes": ["application/json],
 * 			           "description": "。。。。。",
 * 			           "responses": {
 * 				           "200": {"description": "Success"},
 * 				           "400": {"description": "Bad request"},
 * 				           "401": {"description": "Unauthorized"},
 * 				           "500": {"description": "Internal Server Error"},
 * 				           "403": {"description": "Forbidden"},
 * 				           "404": {"description": "Not found"}
 * 				       },
 * 			           "parameters": [{
 * 				           "in": "query",
 * 				           "name": "userName",
 * 				           "description": "用户名称",
 * 				           "type": "string",
 * 				           "required": true
 * 			           }]
 *                 }
 * 	           }
 *         }
 *     }
 *
 * @author: tanshen@qding.me
 * @Date:
 * @since [产品/模块版本]
 */
public class SwaggerPath {
    private String id;
    private String swaggerId;
    private String name;
    private JSONObject json;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSwaggerId() {
        return swaggerId;
    }

    public void setSwaggerId(String swaggerId) {
        this.swaggerId = swaggerId;
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
