package com.t.s.eyecloud.web.advice;

import org.slf4j.MDC;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.t.s.eyecloud.common.constants.EyecloudConstants;
import com.t.s.eyecloud.common.data.base.RestResponse;

@ControllerAdvice
public class RestResponseAdvice implements ResponseBodyAdvice<Object> {

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		if(body instanceof RestResponse<?>) {
			RestResponse<?> restResponse = (RestResponse<?>) body;
			restResponse.setRequestId(MDC.get(EyecloudConstants.TRACE_ID));
			return restResponse;
		}
		return body;
	}

}
