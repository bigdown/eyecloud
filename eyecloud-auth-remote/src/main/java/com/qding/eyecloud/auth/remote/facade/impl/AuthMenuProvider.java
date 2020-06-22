package com.qding.eyecloud.auth.remote.facade.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.qding.eyecloud.auth.remote.facade.IAuthMenuFacade;
import com.qding.eyecloud.common.constants.EyecloudConstants;
import com.qding.eyecloud.dao.IAuthMenuDao;
import com.qding.eyecloud.model.AuthMenu;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * description: <简述>
 * info: <详细信息>
 *
 * @author: tanshen@qding.me
 * @Date:
 * @since [产品/模块版本]
 */
@Service(interfaceClass = IAuthMenuFacade.class, interfaceName = "authMenuProvider")
public class AuthMenuProvider implements IAuthMenuFacade {

    @Autowired
    private IAuthMenuDao iAuthMenuDao;

    @Override
    public List<AuthMenu> limitAuthMenu(AuthMenu authMenu, long limitSize) {
        String id = authMenu.getId();
        authMenu.setId(null);
        return iAuthMenuDao.list(Wrappers.lambdaQuery(authMenu)
                .lt(AuthMenu::getId, authMenu.getId())
                .orderByDesc(AuthMenu::getId)
                .last(String.format(EyecloudConstants.LIMIT_TEMPLATE, limitSize)));
    }

    @Override
    public boolean saveAuthMenu(AuthMenu authMenu) {
        return false;
    }

    @Override
    public AuthMenu getOne(AuthMenu authMenu) {
        return iAuthMenuDao.getOne(Wrappers.lambdaQuery(authMenu));
    }

    @Override
    public List<AuthMenu> listAuthMenu(AuthMenu authMenu) {
        return iAuthMenuDao.list(Wrappers.lambdaQuery(authMenu));
    }
}
