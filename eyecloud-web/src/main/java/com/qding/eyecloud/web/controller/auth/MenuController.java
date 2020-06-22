package com.qding.eyecloud.web.controller.auth;

import com.qding.eyecloud.common.data.base.RestResponse;
import com.qding.eyecloud.common.data.response.auth.UserDataVO;
import com.qding.eyecloud.model.AuthMenu;
import com.qding.eyecloud.web.auth2.ShiroUtils;
import com.qding.eyecloud.web.cache.RedisCache;
import com.qding.eyecloud.web.facade.RpcFacade;
import com.qding.eyecloud.web.request.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private RpcFacade rpcFacade;

    /**
     * 获取用户基本信息以及权限菜单
     *
     * @return
     */
    @PostMapping(value = "/auth-menu/list")
    @ResponseBody
    public RestResponse<List<AuthMenu>> getUserMenuOperates(@RequestBody @Validated PageRequest<AuthMenu> pageRequest) {
        return RestResponse.ok(rpcFacade.iAuthMenuFacade.limitAuthMenu(pageRequest.getData(), pageRequest.getPageSize()));
    }
}
