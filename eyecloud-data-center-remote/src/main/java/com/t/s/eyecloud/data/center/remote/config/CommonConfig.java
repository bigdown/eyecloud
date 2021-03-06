package com.t.s.eyecloud.data.center.remote.config;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@DisconfFile(filename = "common.properties")
public class CommonConfig implements IDisconfUpdate {

	private static final Logger logger = LoggerFactory.getLogger(CommonConfig.class);

	@Value("test.test")
	private String test;

	@DisconfFileItem(name = "test.test")
	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	@Override
	public void reload() throws Exception {
		logger.info("disconf reload <common.properties> : {}", this);
	}

	@Override
	public String toString() {
		return String.format("CommonConfig [test=%s]", test);
	}
}
