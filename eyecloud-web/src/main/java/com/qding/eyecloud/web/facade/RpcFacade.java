package com.qding.eyecloud.web.facade;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qding.eyecloud.auth.remote.facade.IAuthFacade;

/**
 * @author TS
 */
@Component("rpcFacade")
public class RpcFacade {
    
    @Reference(interfaceClass = IAuthFacade.class, interfaceName = "authFacadeProvider", retries = 0)
    public IAuthFacade iAuthFacade;
}
