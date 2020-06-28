package com.t.s.eyecloud.web.service.model;

import com.alibaba.fastjson.JSONObject;

/**
 * description: <简述>
 *     {
 * 	       "id": "1",
 * 	       "swaggerId": "aaa",
 * 	       "name": "返回结果",
 * 	       "json": {
 * 		       "resultDto": {
 * 			       "properties": {
 * 				       "msg": {
 * 					       "default": "成功",
 * 					       "type": "string"
 *                     },
 * 				       "code": {
 * 					       "default": "000000",
 * 					       "type": "string"
 *                     },
 * 				       "data": {
 * 					       "type": "object"
 *                     }
 *                 }
 * 		       }
 *         }
 *     }
 *
 * @author: tanshen@qding.me
 * @Date:
 * @since [产品/模块版本]
 */
public class SwaggerModel {

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
