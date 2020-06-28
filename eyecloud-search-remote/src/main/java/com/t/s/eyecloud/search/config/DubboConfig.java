package com.t.s.eyecloud.search.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;

@Configuration
public class DubboConfig {

	@Value("dubbo.application.name")
	private String applicationName;

	@Value("dubbo.registry.address")
	private String registryAddress;

	@Value("dubbo.protocol.name")
	private String protocolName;
	@Value("dubbo.protocol.port")
	private Integer protocolPort;
	@Value("dubbo.protocol.threads")
	private Integer protocolThreads;
	@Value("dubbo.protocol.threadpool")
	private String protocolThreadPool;

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
	public ProtocolConfig protocolConfig() {
		ProtocolConfig protocolConfig = new ProtocolConfig();
		protocolConfig.setName(protocolName);
		protocolConfig.setPort(protocolPort);
		protocolConfig.setThreads(protocolThreads);
		protocolConfig.setThreadpool(protocolThreadPool);
		return protocolConfig;
	}

	@Bean
	public AnnotationBean annotationBean() {
		AnnotationBean annotationBean = new AnnotationBean();
		annotationBean.setPackage("com.t.s.eyecloud.search.remote.facade");
		return annotationBean;
	}

	@Bean
	public ConsumerConfig consumerConfig() {
		ConsumerConfig consumerConfig = new ConsumerConfig();
		consumerConfig.setFilter("traceLog");
		return consumerConfig;
	}

	@Bean
	public ProviderConfig providerConfig() {
		ProviderConfig providerConfig = new ProviderConfig();
		providerConfig.setFilter("traceLog");
		return providerConfig;
	}
}
