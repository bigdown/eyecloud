package com.t.s.eyecloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;

@Configuration
public class DubboConfig {

	@Value("dubbo.application.name")
	private String applicationName;

	@Value("dubbo.registry.address")
	private String registryAddress;

	@Bean
	public ApplicationConfig applicationConfig() {
		ApplicationConfig applicationConfig = new ApplicationConfig(applicationName);
		applicationConfig.setLogger("slf4j");
		return applicationConfig;
	}

	@Bean
	public RegistryConfig registryConfig() {
		return new RegistryConfig(registryAddress);
	}

	@Bean
	public AnnotationBean annotationBean() {
		AnnotationBean annotationBean = new AnnotationBean();
		annotationBean.setPackage("com.t.s.eyecloud.controller");
		return annotationBean;
	}

	@Bean
	public ConsumerConfig consumerConfig() {
		ConsumerConfig consumerConfig = new ConsumerConfig();
		consumerConfig.setFilter("traceLog");
		return consumerConfig;
	}
}
