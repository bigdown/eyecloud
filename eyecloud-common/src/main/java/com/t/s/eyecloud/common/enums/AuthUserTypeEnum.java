package com.t.s.eyecloud.common.enums;

import java.util.Arrays;

import com.t.s.eyecloud.common.exception.EnumException;

/**
 * Desc: 用户类型枚举定义
 * Info: <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年11月28日
 */
public enum AuthUserTypeEnum {
	/**
	 * 普通用户
	 */
	NORMAL("0", "普通用户"), 
	/**
	 * 超级管理员
	 */
	ADMIN("1", "超级管理员"), 
	/**
	 * 租户管理员
	 */
	T_ADMIN("2", "租户管理员"), 
	/**
	 * 项目管理员
	 */
	P_ADMIN("3", "项目管理员");

	/**
	 * 用户类型
	 */
	private String type;

	/**
	 * 用户类型名称
	 */
	private String name;

	private AuthUserTypeEnum(String type, String name) {
		this.type = type;
		this.name = name;
	}

	public static AuthUserTypeEnum getByCode(String code) {
		AuthUserTypeEnum authUserTypeEnum = Arrays.stream(AuthUserTypeEnum.values())
				.filter(exTypeEnum -> code.equals(exTypeEnum.getType())).findFirst().get();
		if (authUserTypeEnum == null) {
			throw new EnumException();
		}
		return authUserTypeEnum;
	}

	public static String getNameByCode(String code) {
		return getByCode(code).getName();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
