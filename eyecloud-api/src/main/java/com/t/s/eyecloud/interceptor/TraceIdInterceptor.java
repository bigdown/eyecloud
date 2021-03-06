package com.t.s.eyecloud.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.t.s.eyecloud.common.constants.EyecloudConstants;
import com.t.s.eyecloud.common.utils.SnowFlake;
import com.t.s.eyecloud.common.utils.TraceIdUtils;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TraceIdInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String traceId = "req" + SnowFlake.createSnowFlake().nextIdString();
		TraceIdUtils.setTraceId(traceId);
		MDC.put(EyecloudConstants.TRACE_ID, traceId);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		TraceIdUtils.clear();
		MDC.remove(EyecloudConstants.TRACE_ID);
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
