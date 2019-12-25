package com.qding.eyecloud.web.facade;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qding.eyecloud.auth.remote.facade.IAuthFacade;
import com.qding.eyecloud.video.facade.IAliVideoFacade;

@Component
public class RpcFacade {
    
    @Reference(interfaceClass = IAuthFacade.class, retries = 0)
    public IAuthFacade iAuthFacade;
    
    @Reference(interfaceClass = IAliVideoFacade.class, retries = 0)
    public IAliVideoFacade iAliVideoFacade;
}
