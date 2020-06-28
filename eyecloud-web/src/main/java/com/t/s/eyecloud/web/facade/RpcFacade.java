package com.t.s.eyecloud.web.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.t.s.eyecloud.auth.remote.facade.IAuthFacade;
import com.t.s.eyecloud.auth.remote.facade.IAuthMenuFacade;
import org.springframework.stereotype.Component;

/**
 * @author TS
 */
@Component("rpcFacade")
public class RpcFacade {

    @Reference(interfaceClass = IAuthFacade.class, retries = 0)
    public IAuthFacade iAuthFacade;

    @Reference(interfaceClass = IAuthMenuFacade.class, retries = 0)
    public IAuthMenuFacade iAuthMenuFacade;
}
