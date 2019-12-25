package com.qding.eyecloud.web.controller.auth;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    
    /**
     * test
     */
    @RequestMapping(value = "test", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"auth:test"})
    public String logout() {
        return "test";
    }
}
