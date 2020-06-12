package com.qding.eyecloud.web.service.model;

import io.swagger.models.Tag;

/**
 * description: <简述>
 *     {
 * 	       "id": "1",
 * 	       "swaggerId": "aaa",
 * 	       "json": {"name": "tag1", "description": "test"}
 *     }
 *
 * @author: tanshen@qding.me
 * @Date:
 * @since [产品/模块版本]
 */
public class SwaggerTag {
    private String id;
    private String swaggerId;
    private Tag json;

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

    public Tag getJson() {
        return json;
    }

    public void setJson(Tag json) {
        this.json = json;
    }
}
