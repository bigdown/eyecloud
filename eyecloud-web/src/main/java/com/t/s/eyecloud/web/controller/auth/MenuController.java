package com.t.s.eyecloud.web.controller.auth;

import com.t.s.eyecloud.base.BaseTreeModel;
import com.t.s.eyecloud.common.data.base.RestResponse;
import com.t.s.eyecloud.common.data.base.TreeVO;
import com.t.s.eyecloud.common.utils.TreeUtils;
import com.t.s.eyecloud.model.AuthMenu;
import com.t.s.eyecloud.web.facade.RpcFacade;
import com.t.s.eyecloud.web.request.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * description: <简述>
 * info: <详细信息>
 *
 * @author: tanshen@qding.me
 * @Date:
 * @since [产品/模块版本]
 */
@RestController
public class MenuController {

    @Resource
    private RpcFacade rpcFacade;

    /**
     * 获取用户基本信息以及权限菜单
     *
     * @return
     */
    @PostMapping(value = "/auth-menu/list")
    @ResponseBody
    public RestResponse<List<AuthMenu>> list(@RequestBody @Validated PageRequest<AuthMenu> pageRequest) {
        return RestResponse.ok(rpcFacade.iAuthMenuFacade.limitAuthMenu(pageRequest.getData(), pageRequest.getPageSize()));
    }

    @PostMapping(value = "/auth-menu/tree")
    @ResponseBody
    public RestResponse<List<TreeVO<? extends BaseTreeModel>>> tree(@RequestBody @Validated AuthMenu authMenu) {
        List<TreeVO<? extends BaseTreeModel>> tree = TreeUtils.startForTree(rpcFacade.iAuthMenuFacade.listAuthMenu(authMenu));
        return RestResponse.ok(tree);
    }

    @PostMapping(value = "/auth-menu/add")
    @ResponseBody
    public RestResponse<Boolean> addMenu(@RequestBody @Validated AuthMenu authMenu) {
        authMenu.setId(null);
        return RestResponse.ok(rpcFacade.iAuthMenuFacade.saveAuthMenu(authMenu));
    }

    @PostMapping(value = "/auth-menu/update")
    @ResponseBody
    public RestResponse<Boolean> updateMenu(@RequestBody @Validated AuthMenu authMenu) {
        return RestResponse.ok(rpcFacade.iAuthMenuFacade.saveAuthMenu(authMenu));
    }
}
