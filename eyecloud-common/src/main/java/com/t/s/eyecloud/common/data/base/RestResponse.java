package com.t.s.eyecloud.common.data.base;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * Desc: rest接口返回数据结构
 * Info: <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年11月28日
 */
public class RestResponse<T> implements Serializable {

	private static final String SUCESS = "success";
	private static final String ERROR = "error";
	private static final String SUCESS_CODE = "1001";
	private static final String ERROR_CODE = "1000";

	private static final long serialVersionUID = 4473740711913124380L;
	@ApiModelProperty(value = "返回状态码")
	private String code;
	@ApiModelProperty(value = "返回值描述")
	private String msg;
	@ApiModelProperty(value = "返回数据体（按具体接口变化）")
	private T data;
	@ApiModelProperty(value = "当前请求唯一id（排除问题请提供接口url以及当前请求requestId）")
	private String requestId;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public RestResponse(String code, String msg, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public RestResponse() {
		super();
	}

	public static <T> RestResponse<T> ok(T data) {
		return new RestResponse<T>(SUCESS_CODE, SUCESS, data);
	}

	public static <T> RestResponse<T> ok(String msg, T data) {
		return new RestResponse<T>(SUCESS_CODE, msg, data);
	}

	public static <T> RestResponse<T> ok() {
		return ok(null);
	}

	public static <T> RestResponse<T> error(String msg) {
		return new RestResponse<T>(ERROR_CODE, msg, null);
	}

	public static <T> RestResponse<T> error() {
		return error(ERROR);
	}

	public static <T> RestResponse<T> error(String code, String msg) {
		return new RestResponse<T>(code, msg, null);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RestResponse [code=").append(code).append(", msg=").append(msg).append(", data=").append(data)
				.append(", requestId=").append(requestId).append("]");
		return builder.toString();
	}

}
