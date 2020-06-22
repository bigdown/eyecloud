package com.qding.eyecloud.auth.remote.facade;

import com.qding.eyecloud.common.data.base.PageResultVO;
import com.qding.eyecloud.model.AuthMenu;

import java.util.List;

/**
 * description: <简述>
 * info: <详细信息>
 *
 * @author: tanshen@qding.me
 * @Date:
 * @since [产品/模块版本]
 */
public interface IAuthMenuFacade {

    /**
     * 分页查询菜单列表
     * @param authMenu
     * @param limitSize
     * @return
     */
    List<AuthMenu> limitAuthMenu(AuthMenu authMenu, long limitSize);

    /**
     * 新增或者修改
     * @param authMenu
     * @return
     */
    boolean saveAuthMenu(AuthMenu authMenu);

    /**
     * 根据条件获取单个
     * @param authMenu
     * @return
     */
    AuthMenu getOne(AuthMenu authMenu);

    /**
     * 根据条件获取菜单列表
     * @param authMenu
     * @return
     */
    List<AuthMenu> listAuthMenu(AuthMenu authMenu);
}
