package com.qding.eyecloud.web.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qding.eyecloud.auth.remote.facade.IAuthFacade;
import com.qding.eyecloud.auth.remote.facade.IAuthMenuFacade;
import org.springframework.stereotype.Component;

/**
 * @author TS
 */
@Component("rpcFacade")
public class RpcFacade {

    @Reference(interfaceClass = IAuthFacade.class, interfaceName = "authFacadeProvider", retries = 0)
    public IAuthFacade iAuthFacade;

    @Reference(interfaceClass = IAuthMenuFacade.class, interfaceName = "authMenuFacadeProvider", retries = 0)
    public IAuthMenuFacade iAuthMenuFacade;
}
