package com.qding.eyecloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import com.baidu.disconf.client.common.update.IDisconfUpdate;

@Configuration
@DisconfFile(filename = "common.properties")
public class CommonConfig implements IDisconfUpdate {

	private static final Logger logger = LoggerFactory.getLogger(CommonConfig.class);

	private String test;

	@DisconfFileItem(name = "test.test", associateField = "test")
	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	@Override
	public void reload() throws Exception {
		logger.info("disconf reload <common.properties> : {}", toString());
	}

	@Override
	public String toString() {
		return String.format("CommonConfig [test=%s]", test);
	}
}
