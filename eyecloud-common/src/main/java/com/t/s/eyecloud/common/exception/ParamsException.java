package com.t.s.eyecloud.common.exception;

/**
 * Desc: 入参异常
 * Info: <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年11月28日
 */
public class ParamsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ParamsException(String msg) {
		super();
		this.msg = msg;
	}

	public ParamsException() {
		super();
	}

}
