package com.qding.eyecloud.controller.auth.v1_0_0;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qding.eyecloud.auth.remote.facade.IAuthFacade;
import com.qding.eyecloud.common.data.base.RestResponse;
import com.qding.eyecloud.data.center.remote.facade.IDataCenterFacade;

@RestController
@RequestMapping("/v1_0_0/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Reference(interfaceClass = IAuthFacade.class)
	private IAuthFacade iAuthFacade;
	@Reference(interfaceClass = IDataCenterFacade.class)
	private IDataCenterFacade iDataCenterFacade;

	@RequestMapping("test")
	public RestResponse<String> test() {
		logger.info("1");

		logger.info("2");
		iDataCenterFacade.hello("data-center");

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
