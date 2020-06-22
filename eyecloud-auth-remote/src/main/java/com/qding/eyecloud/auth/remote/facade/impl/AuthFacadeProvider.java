package com.qding.eyecloud.auth.remote.facade.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.qding.eyecloud.common.data.response.auth.AuthUserVO;
import com.qding.eyecloud.dao.*;
import com.qding.eyecloud.model.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fasterxml.jackson.core.type.TypeReference;
import com.qding.eyecloud.auth.remote.facade.IAuthFacade;
import com.qding.eyecloud.auth.remote.utils.JwtUtils;
import com.qding.eyecloud.auth.remote.utils.MapUtils;
import com.qding.eyecloud.common.constants.EyecloudConstants;
import com.qding.eyecloud.common.data.response.auth.AuthMenuVO;
import com.qding.eyecloud.common.data.response.auth.AuthOperateVO;
import com.qding.eyecloud.common.data.response.auth.UserDataVO;
import com.qding.eyecloud.common.enums.AuthUserTypeEnum;
import com.qding.eyecloud.common.exception.A;
import com.qding.eyecloud.common.utils.Base64Utils;
import com.qding.eyecloud.common.utils.JsonUtil;
import com.qding.eyecloud.common.utils.ShaUtils;
import com.qding.eyecloud.common.utils.SnowFlake;
import com.qding.eyecloud.common.utils.TreeUtils;

import io.jsonwebtoken.Claims;

/**
 * Desc: auth dubbo服务提供者
 * Info: <功能详细描述>
 *
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年11月28日
 * @since [产品/模块版本]
 */
@Service(interfaceClass = IAuthFacade.class, interfaceName = "authFacadeProvider")
public class AuthFacadeProvider implements IAuthFacade {

    @Autowired
    private IAuthUserDao iAuthUserDao;

    @Autowired
    private IAuthMenuDao iAuthMenuDao;

    @Autowired
    private IAuthMenuOperateDao iAuthMenuOperateDao;

    @Autowired
    private IAuthUserRoleDao iAuthUserRoleDao;

    @Autowired
    private IAuthRoleMenuDao iAuthRoleMenuDao;

    @Autowired
    private IAuthUserProjectDao iAuthUserProjectDao;

    @Override
    public AuthUserVO getAuthUser(AuthUser req, boolean checkPassWord, boolean createToken) {
        AuthUserVO authUserVO = new AuthUserVO();
        A.checkParams(Objects.isNull(req) || StringUtils.isBlank(req.getAccount()), "入参错误");

        AuthUser authUser =
                iAuthUserDao.getOne(Wrappers.<AuthUser>lambdaQuery().eq(AuthUser::getAccount, req.getAccount()));

        A.checkBusiness(Objects.isNull(authUser), EyecloudConstants.COMMON_FAIL, "用户不存在");

        if (checkPassWord) {
            A.checkParams(StringUtils.isBlank(req.getPassword()), "密码不能为空");
            A.checkParams(
                    !ShaUtils.shaxxx(req.getPassword(), authUser.getSalt(), ShaUtils.SHA_256)
                            .equals(authUser.getPassword()),
                    "账号名或密码错误");
        }
        sensitiveUser(authUser);
        if (createToken) {
            authUserVO.setToken(generateToken(authUser));
        }
        authUserVO.setBase(authUser);
        return authUserVO;
    }

    @Override
    public void logout(String token) {
        // jwt - 没法销毁
    }

    /**
     * 生成token
     * 功能详细描述
     *
     * @param req
     * @return String
     * @author tanshen@qding.me
     * @version v1.0
     * Date:2019年12月27日 12:05
     * @since [产品/模块版本]
     **/
    @Override
    public String generateToken(AuthUser req) {
        A.checkParams(req == null || StringUtils.isAnyBlank(req.getAccount(), req.getId()), "入参错误");
        return JwtUtils.createToken(req.getId(), JsonUtil.writeValue(req), false);
    }

    /**
     * 校验token并返回用户信息
     * 功能详细描述
     *
     * @param token
     * @return AuthUser
     * @author tanshen@qding.me
     * @version v1.0
     * Date:2019年12月27日 12:04
     * @since [产品/模块版本]
     **/
    @Override
    public AuthUser checkAndGetAuthUser(String token) {
        Claims claims = JwtUtils.getTokenBody(token);
        String subject = claims.getSubject();
        AuthUser user = JsonUtil.readValue(subject, new TypeReference<AuthUser>() {
        });
        A.checkBusiness(user == null, EyecloudConstants.COMMON_FAIL, "token校验失败");
        sensitiveUser(user);
        return user;
    }

    /**
     * 过滤敏感信息
     * 功能详细描述
     *
     * @param authUser
     * @author tanshen@qding.me
     * @version v1.0
     * Date:2019年12月27日 12:03
     * @since [产品/模块版本]
     **/
    private void sensitiveUser(AuthUser authUser) {
        authUser.setPassword("*");
        authUser.setSalt("*");
    }

    /**
     * 用户注册
     * 功能详细描述
     *
     * @param req
     * @return AuthUser
     * @author tanshen@qding.me
     * @version v1.0
     * Date:2019年12月27日 12:01
     * @since [产品/模块版本]
     **/
    @Override
    public AuthUser register(AuthUser req) {
        A.checkParams(Objects.isNull(req) || StringUtils.isAnyBlank(req.getMobile(), req.getPassword()), "入参错误");
        req.setId(SnowFlake.createSnowFlake().nextIdString());
        req.setSalt(Base64Utils.getRandomSaltForSha256());
        req.setPassword(ShaUtils.shaxxx(req.getPassword(), req.getSalt(), ShaUtils.SHA_256));
        req.setAccount(req.getMobile());
        req.setNickName(req.getMobile());
        req.setAccountType("0");
        iAuthUserDao.save(req);
        sensitiveUser(req);
        return req;
    }

    /**
     * 获取用户的权限菜单
     * 功能详细描述
     *
     * @return UserDataVO
     * @author tanshen@qding.me
     * @version v1.0
     * Date:2019年12月27日 11:59
     * @since [产品/模块版本]
     **/
    @Override
    public UserDataVO getAuthPermissions(String userId, String platCode) {

        A.checkParams(StringUtils.isBlank(userId), "账号userId不能为空");

        AuthUser authUser = iAuthUserDao.getById(userId);
        UserDataVO userDataVO = new UserDataVO();
        AuthUserTypeEnum userType = AuthUserTypeEnum.getByCode(authUser.getAccountType());
        LambdaQueryWrapper<AuthUserRole> query = Wrappers.<AuthUserRole>lambdaQuery();
        Set<String> roleIds = null;

        if (AuthUserTypeEnum.ADMIN.getType().equals(userType.getType())) {
            // 超级管理员拥有所有权限
        } else if (AuthUserTypeEnum.T_ADMIN.getType().equals(userType.getType())) {
            // 租户管理员拥有该租户下面的所有权限
            A.checkParams(StringUtils.isBlank(authUser.getTenantId()), "租户tenantId不能为空");
            query.eq(AuthUserRole::getTenantId, authUser.getTenantId());
            roleIds = iAuthUserRoleDao.list(query).stream().map(AuthUserRole::getRoleId).collect(Collectors.toSet());
        } else if (AuthUserTypeEnum.P_ADMIN.getType().equals(userType.getType())) {
            // 项目管理员拥有该项目下面的所有权限
            // 获取项目管理所管理的项目
            A.checkParams(StringUtils.isBlank(authUser.getTenantId()), "租户id不能为空");
            List<AuthUserProject> authUserProjectList = iAuthUserProjectDao.list(Wrappers.<AuthUserProject>lambdaQuery().eq(AuthUserProject::getTenantId, authUser.getTenantId()).eq(AuthUserProject::getUserId, userId));
            A.checkBusiness(CollectionUtils.isEmpty(authUserProjectList), "该项目管理员没有关联项目");
            query.in(AuthUserRole::getProjectId, authUserProjectList.stream().map(AuthUserProject::getProjectId).collect(Collectors.toSet()));
            roleIds = iAuthUserRoleDao.list(query).stream().map(AuthUserRole::getRoleId).collect(Collectors.toSet());
        } else {
            // 普通用户获取该用户的权限
            query.eq(AuthUserRole::getUserId, userId);
            roleIds = iAuthUserRoleDao.list(query).stream().map(AuthUserRole::getRoleId).collect(Collectors.toSet());
        }

        if (!AuthUserTypeEnum.ADMIN.getType().equals(userType.getType()) && CollectionUtils.isEmpty(roleIds)) {
            // 如果非管理员，且没有绑定角色，则认为该用户没有相关权限，直接返回
            return userDataVO;
        }
        Set<String> menuIds = iAuthRoleMenuDao
                .list(Wrappers.<AuthRoleMenu>lambdaQuery().eq(AuthRoleMenu::getTenantId, authUser.getTenantId())
                        .in(!CollectionUtils.isEmpty(roleIds), AuthRoleMenu::getRoleId, roleIds))
                .stream()
                .map(AuthRoleMenu::getMenuId)
                .collect(Collectors.toSet());
        if (!AuthUserTypeEnum.ADMIN.getType().equals(userType.getType()) && CollectionUtils.isEmpty(menuIds)) {
            // 如果非管理员，且角色没有绑定菜单，则认为该用户没有相关权限，直接返回
            return userDataVO;
        }
        List<AuthMenu> menus = iAuthMenuDao
                .list(Wrappers.<AuthMenu>lambdaQuery().in(!CollectionUtils.isEmpty(menuIds), AuthMenu::getId, menuIds)
                        .eq(StringUtils.isNotBlank(platCode), AuthMenu::getPlatCode, platCode));
        List<AuthMenuOperate> operates = iAuthMenuOperateDao.list(Wrappers.<AuthMenuOperate>lambdaQuery()
                .in(!CollectionUtils.isEmpty(menuIds), AuthMenuOperate::getMenuId, menuIds));
        // 转换成map，在进行数据组装
        Map<String, List<AuthOperateVO>> map = MapUtils.listToMapForOperate(operates);
        List<AuthMenuVO> menuList = new ArrayList<>();
        for (AuthMenu item : menus) {
            AuthMenuVO authMenuVO = new AuthMenuVO();
            BeanUtils.copyProperties(item, authMenuVO);
            authMenuVO.setOperates(map.get(item.getId()));
            menuList.add(authMenuVO);
        }
        userDataVO.setPermissions(TreeUtils.startForTree(menuList));
        return userDataVO;
    }

}
