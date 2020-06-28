package com.t.s.eyecloud.web.cache;

import com.t.s.eyecloud.common.data.response.auth.UserDataVO;
import com.t.s.eyecloud.web.facade.RpcFacade;
import com.t.s.eyecloud.web.utils.SpringContextUtils;

/**
 * description: <简述>
 * info: <详细信息>
 *
 * @author: tanshen@qding.me
 * @Date:
 * @since [产品/模块版本]
 */
public class RedisCache {

    public static UserDataVO getAndSetUserCache(String userId) {
//        String cached = RedisUtil.getRedisUtil().get(EyecloudConstants.AUTH_USER_DATA + userId);
        UserDataVO userDataVO;
//        if (StringUtils.isBlank(cached)) {
        userDataVO =
                ((RpcFacade) SpringContextUtils.getBean("rpcFacade")).iAuthFacade.getAuthPermissions(userId, "eyecloud-web");
//        RedisUtil.getRedisUtil().set(EyecloudConstants.AUTH_USER_DATA + userId, JsonUtil.writeValue(userDataVO));
//        } else {
//            userDataVO = JsonUtil.readValue(cached, new TypeReference<UserDataVO>() {
//            });
//        }
        return userDataVO;
    }
}
