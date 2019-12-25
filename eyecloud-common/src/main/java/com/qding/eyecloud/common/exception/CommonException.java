package com.qding.eyecloud.common.exception;

/**
 * Desc: 全局通用自定义异常
 * Info: <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年11月28日
 */
public class CommonException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private String msg;
	private String code = "500";

	public CommonException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public CommonException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}

	public CommonException(String msg, String code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}

	public CommonException(String msg, String code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
