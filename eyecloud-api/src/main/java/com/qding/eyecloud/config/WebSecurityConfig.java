package com.qding.eyecloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.qding.eyecloud.interceptor.TraceIdInterceptor;

@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration addInterceptor = registry.addInterceptor(new TraceIdInterceptor());
		addInterceptor.addPathPatterns("/v1_0_0/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}

}
