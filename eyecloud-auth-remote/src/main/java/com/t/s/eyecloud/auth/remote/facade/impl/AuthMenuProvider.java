package com.t.s.eyecloud.auth.remote.facade.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.t.s.eyecloud.auth.remote.facade.IAuthMenuFacade;
import com.t.s.eyecloud.common.constants.EyecloudConstants;
import com.t.s.eyecloud.common.utils.SnowFlake;
import com.t.s.eyecloud.dao.IAuthMenuDao;
import com.t.s.eyecloud.model.AuthMenu;
import org.apache.commons.lang3.StringUtils;
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
@Service(interfaceClass = IAuthMenuFacade.class)
public class AuthMenuProvider implements IAuthMenuFacade {

    @Autowired
    private IAuthMenuDao iAuthMenuDao;

    @Override
    public List<AuthMenu> limitAuthMenu(AuthMenu authMenu, long limitSize) {
        String id = authMenu.getId();
        authMenu.setId(null);
        return iAuthMenuDao.list(Wrappers.lambdaQuery(authMenu)
                .lt(StringUtils.isNotBlank(id), AuthMenu::getId, id)
                .orderByDesc(AuthMenu::getId)
                .last(String.format(EyecloudConstants.LIMIT_TEMPLATE, limitSize)));
    }

    @Override
    public boolean saveAuthMenu(AuthMenu authMenu) {
        String id = authMenu.getId();
        if (StringUtils.isNotBlank(id)) {
            authMenu.setId(null);
            iAuthMenuDao.update(authMenu, Wrappers.<AuthMenu>lambdaQuery().eq(AuthMenu::getId, id));
        } else {
            authMenu.setId(SnowFlake.createSnowFlake().nextIdString());
            iAuthMenuDao.save(authMenu);
        }
        return true;
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
