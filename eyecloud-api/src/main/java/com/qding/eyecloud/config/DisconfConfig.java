package com.qding.eyecloud.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import com.baidu.disconf.client.DisconfMgrBean;
import com.baidu.disconf.client.DisconfMgrBeanSecond;
import com.baidu.disconf.client.addons.properties.ReloadablePropertiesFactoryBean;

@Configuration
public class DisconfConfig {

	@Bean(destroyMethod = "destroy")
	public DisconfMgrBean getDisconfMgrBean() {
		DisconfMgrBean disconfMgrBean = new DisconfMgrBean();
		disconfMgrBean.setScanPackage("com.qding.eyecloud");
		return disconfMgrBean;
	}

	@Bean(destroyMethod = "destroy", initMethod = "init")
	public DisconfMgrBeanSecond getDisconfMgrBean2() {
		return new DisconfMgrBeanSecond();
	}

	@Bean(name = "reloadablePropertiesFactoryBean")
	@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
	public ReloadablePropertiesFactoryBean reloadablePropertiesFactoryBean() {
		ReloadablePropertiesFactoryBean propertiesFactoryBean = new ReloadablePropertiesFactoryBean();
		propertiesFactoryBean.setSingleton(true);

		// disconf配置的文件
		List<String> fileNames = new ArrayList<>();
		fileNames.add("classpath:common.properties");
		propertiesFactoryBean.setLocations(fileNames);
		return propertiesFactoryBean;
	}

	@Bean(name = "propertyPlaceholderConfigurer")
	public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(
			ReloadablePropertiesFactoryBean reloadablePropertiesFactoryBean) {
		PropertyPlaceholderConfigurer placeholderConfigurer = new PropertyPlaceholderConfigurer();
		placeholderConfigurer.setIgnoreResourceNotFound(true);
		placeholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
		try {
			Properties properties = reloadablePropertiesFactoryBean.getObject();
			placeholderConfigurer.setProperties(properties);
		} catch (IOException e) {
			throw new RuntimeException("unable to find properties", e);
		}
		return placeholderConfigurer;
	}
}
