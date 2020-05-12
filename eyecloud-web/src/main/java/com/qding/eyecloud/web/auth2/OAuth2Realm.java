package com.qding.eyecloud.web.auth2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.util.CollectionUtils;

import com.qding.eyecloud.base.BaseTreeModel;
import com.qding.eyecloud.common.data.base.TreeVO;
import com.qding.eyecloud.common.data.response.auth.AuthMenuVO;
import com.qding.eyecloud.common.data.response.auth.AuthOperateVO;
import com.qding.eyecloud.common.data.response.auth.UserDataVO;
import com.qding.eyecloud.model.AuthUser;
import com.qding.eyecloud.web.facade.RpcFacade;
import com.qding.eyecloud.web.utils.SpringContextUtils;

public class OAuth2Realm extends AuthorizingRealm {

    public OAuth2Realm() {
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    /**
     * Desc:授权
     * Info:<功能详细描述>
     *
     * @param principals
     * @return
     * @author tanshen@qding.me
     * Date:2019年12月2日 下午6:49:42
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        AuthUser authUser = (AuthUser) principals.getPrimaryPrincipal();
        if (authUser == null) {
            throw new RuntimeException();
        }
        // 如果是管理员，则认为有所有权限
        UserDataVO userDataVO =
                ((RpcFacade) SpringContextUtils.getBean("rpcFacade")).iAuthFacade.getAuthPermissions(authUser.getId(), authUser.getTenantId(), authUser.getAccountType());
        // 用户权限列表
        Set<String> permsSet = new HashSet<>();
        if (userDataVO != null && !CollectionUtils.isEmpty(userDataVO.getPermissions())) {
            for (TreeVO<? extends BaseTreeModel> item : userDataVO.getPermissions()) {
                AuthMenuVO authMenuVO = (AuthMenuVO) item.getData();
                List<AuthOperateVO> operates = authMenuVO.getOperates();
                if (CollectionUtils.isEmpty(operates)) {
                    continue;
                }
                Set<String> itemSet =
                        operates.stream().map(operate -> operate.getOperateCode()).collect(Collectors.toSet());
                permsSet.addAll(itemSet);
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }

    /**
     * Desc:认证
     * Info:<功能详细描述>
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     * @author tanshen@qding.me
     * Date:2019年12月2日 下午6:49:48
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        String token = (String) authenticationToken.getPrincipal();
        // 根据token查询用户信息
        AuthUser user = ((RpcFacade) SpringContextUtils.getBean("rpcFacade")).iAuthFacade.checkAndGetAuthUser(token);
        if (user == null) {
            throw new UnauthorizedException("账号或密码不正确");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, token, getName());
        return info;
    }

}
