package com.qding.eyecloud.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.qding.eyecloud.common.constants.Constants;
import com.qding.eyecloud.common.exception.CommonException;

/**
 * Desc: json转换工具
 * Info: <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年11月28日
 */
public class JsonUtil {

	public static final ObjectMapper OBJECT_MAPPER = createObjectMapper();

	static ObjectMapper createObjectMapper() {
		final ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.setSerializationInclusion(Include.NON_NULL);
		return mapper;
	}

	public static String writeValue(Object obj) {
		try {
			return OBJECT_MAPPER.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
		}
		throw new CommonException(Constants.COMMON_FAIL, "业务参数错误");
	}

	public static <T> T readValue(String s, TypeReference<T> ref) {
		try {
			return OBJECT_MAPPER.readValue(s, ref);
		} catch (Exception e) {
		}
		throw new CommonException(Constants.COMMON_FAIL, "业务参数错误");
	}
}
