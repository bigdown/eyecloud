package com.qding.eyecloud.auth.remote.facade;

import com.qding.eyecloud.common.data.response.auth.AuthUserVO;
import com.qding.eyecloud.common.data.response.auth.UserDataVO;
import com.qding.eyecloud.model.AuthUser;

/**
 * Description:基础-权限中心
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年11月15日
 */
public interface IAuthFacade {

	// 获取校验码（邮箱、手机、图形）

	/**
	 * 登录（根据id或者账号获取信息）
	 */
	AuthUserVO getAuthUser(AuthUser authUser, boolean checkPass, boolean createToken);

	/**
	 * 生成token
	 */
	String generateToken(AuthUser authUser);


	/**
	 * 一句话功能简述
	 * 功能详细描述
	 * @return com.qding.eyecloud.model.AuthUser
	 * @throws
	 * @since [产品/模块版本]
	 * @author tanshen@qding.me
	 * @version v1.0
	 * Date:2019年12月27日 13:38
	**/
	AuthUser register(AuthUser authUser);

	/**
	 * 退出登录
	 */
	void logout(String token);

	/**
	 * token校验并获取当前登录用户主信息
	 */
	AuthUser checkAndGetAuthUser(String token);

	// token校验并获取当前登录用户租户信息

	// token校验并获取当前登录用户项目信息

	// token校验并获取当前登录用户基础信息

	// 平台类型管理

	// 基于平台类型的菜单管理

	// 基于平台类型的角色管理

	/**
	 * Desc:获取用户的权限集合
	 * Info:<功能详细描述>
	 * @return
	 * @author tanshen@qding.me
	 * Date:2019年11月29日 下午3:45:14
	 */
	UserDataVO getAuthPermissions(String userId, String platCode);

}
