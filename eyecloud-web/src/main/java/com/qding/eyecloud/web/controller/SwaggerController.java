package com.qding.eyecloud.web.controller;

import com.qding.eyecloud.web.service.SwaggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: <简述>
 * info: <详细信息>
 *
 * @author: tanshen@qding.me
 * @Date:
 * @since [产品/模块版本]
 */
@RestController
@RequestMapping("/v2")
public class SwaggerController {

    @Autowired
    private SwaggerService swaggerService;

    /**
     * 获取动态文档，最好加UTF-8注解，保证格式不乱码
     * @return Swagger Json字符串
     */
    @GetMapping(value = "/qding-api-docs", produces= "application/json;charset=UTF-8")
    public String getJson() {
        return swaggerService.getSwagger();
    }
}
