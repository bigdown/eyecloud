package com.t.s.eyecloud.controller.auth.v1_0_0;

import com.alibaba.dubbo.config.annotation.Reference;
import com.t.s.eyecloud.auth.remote.facade.IAuthFacade;
import com.t.s.eyecloud.common.data.base.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1_0_0/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Reference(interfaceClass = IAuthFacade.class)
    private IAuthFacade iAuthFacade;

    @RequestMapping("test")
    public RestResponse<String> test() {
        logger.info("1");

        logger.info("2");

        logger.info("3");
        return RestResponse.ok();
    }

    @RequestMapping("test1")
    public RestResponse<String> test1() {
        logger.info("1");

        logger.info("2");

        logger.info("3");
        return RestResponse.ok();
    }
}
