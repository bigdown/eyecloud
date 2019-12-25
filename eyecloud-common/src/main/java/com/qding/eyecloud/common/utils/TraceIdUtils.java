package com.qding.eyecloud.common.utils;

/**
 * Desc: 辅助traceId工具类
 * Info: <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年11月28日
 */
public class TraceIdUtils {

	private static final ThreadLocal<String> TRACE_ID_CACHE = new ThreadLocal<String>();

	public static String getTraceId() {
		return TRACE_ID_CACHE.get();
	}

	public static void setTraceId(String traceId) {
		TRACE_ID_CACHE.set(traceId);
	}

	public static void clear() {
		TRACE_ID_CACHE.remove();
	}
}
