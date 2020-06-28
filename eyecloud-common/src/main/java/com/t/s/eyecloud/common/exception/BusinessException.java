package com.t.s.eyecloud.common.exception;

/**
 * Desc: 业务自定义异常
 * Info: <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年11月28日
 */
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private String code;
	private String msg;

	public BusinessException() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public BusinessException(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}