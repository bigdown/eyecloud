package com.t.s.eyecloud.common.enums;

/**
 * Desc: 通用逻辑删除枚举
 * Info: <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年11月29日
 */
public enum CommonDisableEnum {

	/**
	 * 逻辑删除：可用状态
	 */
	ABLED("0", "可用"),

	/**
	 * 逻辑删除：不可用状态
	 */
	DIS_ABLED("1", "删除/不可用");

	private String code;
	private String value;

	public String getCode() {
		return code;
	}

	public String getValue() {
		return value;
	}

	private CommonDisableEnum(String code, String value) {
		this.code = code;
		this.value = value;
	}

}
