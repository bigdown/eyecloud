package com.qding.eyecloud.web.service;

import com.alibaba.fastjson.JSONObject;
import com.qding.eyecloud.common.utils.SnowFlake;
import com.qding.eyecloud.web.service.model.SwaggerModel;
import com.qding.eyecloud.web.service.model.SwaggerPath;
import com.qding.eyecloud.web.service.model.SwaggerTag;
import io.swagger.models.Tag;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * description: <简述>
 * info: <详细信息>
 *
 * @author: tanshen@qding.me
 * @Date:
 * @since [产品/模块版本]
 */
@Service("swaggerService")
public class SwaggerService {

    public String getSwagger() {
        JSONObject swagger = JSONObject.parseObject("{\n" +
                "    \"swagger\":\"2.0\",\n" +
                "    \"info\":{\n" +
                "        \"description\":\"eyecloud-web文档\",\n" +
                "        \"version\":\"1.0.0\",\n" +
                "        \"title\":\"eyecloud-web\",\n" +
                "        \"termsOfService\":\"https://www.baidu.com\"\n" +
                "    },\n" +
                "    \"host\":\"localhost:8080\",\n" +
                "    \"basePath\":\"/\"\n" +
                "}");
        String swaggerId = SnowFlake.createSnowFlake().nextIdString();
        List<Tag> tagList = new ArrayList<>();
        SwaggerTag tag = new SwaggerTag();
        tag.setId(SnowFlake.createSnowFlake().nextIdString());
        Tag tagJson = new Tag();
        tagJson.setDescription("tag-description");
        tagJson.setName("tag-name");
        tag.setJson(tagJson);
        tag.setSwaggerId(swaggerId);
        tagList.add(tagJson);
        swagger.put("tags", tagList);

        JSONObject pathJson = new JSONObject();
        SwaggerPath path = new SwaggerPath();
        path.setId(SnowFlake.createSnowFlake().nextIdString());
        String json = "{\n" +
                "            \"/users\": {\n" +
                "            \"get\": {\n" +
                "            \"summary\": \"查询用户\",\n" +
                "            \"tags\": [\"tag-name\"],\n" +
                "            \"produces\": [\"application/json\"],\n" +
                "            \"consumes\": [\"application/json\"],\n" +
                "            \"description\": \"。。。。。\",\n" +
                "            \"responses\": {\n" +
                "            \"200\": {\"description\": \"Success\"},\n" +
                "            \"400\": {\"description\": \"Bad request\"},\n" +
                "            \"401\": {\"description\": \"Unauthorized\"},\n" +
                "            \"500\": {\"description\": \"Internal Server Error\"},\n" +
                "            \"403\": {\"description\": \"Forbidden\"},\n" +
                "            \"404\": {\"description\": \"Not found\"}\n" +
                "        },\n" +
                "            \"parameters\": [{\n" +
                "            \"in\": \"query\",\n" +
                "            \"name\": \"userName\",\n" +
                "            \"description\": \"用户名称\",\n" +
                "            \"type\": \"string\",\n" +
                "            \"required\": true\n" +
                "            }]\n" +
                "                  }\n" +
                "            }\n" +
                "          }";
        JSONObject pathObject = JSONObject.parseObject(json);
        path.setJson(pathObject);
        path.setName("path-name");
        path.setSwaggerId(swaggerId);
        pathJson.putAll(path.getJson());
        swagger.put("paths", pathJson);

        JSONObject modelJson = new JSONObject();
        SwaggerModel model = new SwaggerModel();
        model.setId(SnowFlake.createSnowFlake().nextIdString());
        json = "{" +
                "       \"resultDto\": {\n" +
                "       \"properties\": {\n" +
                "       \"msg\": {\n" +
                "       \"default\": \"成功\",\n" +
                "       \"type\": \"string\"\n" +
                "                      },\n" +
                "       \"code\": {\n" +
                "       \"default\": \"000000\",\n" +
                "       \"type\": \"string\"\n" +
                "                      },\n" +
                "       \"data\": {\n" +
                "       \"type\": \"object\"\n" +
                "                      }\n" +
                "                  }\n" +
                "       }\n" +
                "          }";
        JSONObject modelObject = JSONObject.parseObject(json);
        model.setJson(modelObject);
        model.setName("model-name");
        model.setSwaggerId(swaggerId);
        modelJson.putAll(model.getJson());

        return swagger.toJSONString();
    }
}
