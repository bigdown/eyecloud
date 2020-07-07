package com.t.s.eyecloud.web.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.t.s.eyeclod.data.center.facade.IModelFacade;
import com.t.s.eyecloud.auth.remote.facade.IAuthFacade;
import com.t.s.eyecloud.auth.remote.facade.IAuthMenuFacade;
import org.springframework.stereotype.Component;

/**
 * description: dubbo接口facade
 * info: <详细信息>
 * @since [产品/模块版本]
 * @return
 * @author: tanshen@qding.me
 * @Date: 2020年07月07日 11:53
 */
@Component("rpcFacade")
public class RpcFacade {

    @Reference(interfaceClass = IAuthFacade.class, retries = 0)
    public IAuthFacade iAuthFacade;

    @Reference(interfaceClass = IAuthMenuFacade.class, retries = 0)
    public IAuthMenuFacade iAuthMenuFacade;

    @Reference(interfaceClass = IModelFacade.class, retries = 0)
    public IModelFacade iModelFacade;

}
