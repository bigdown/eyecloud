package com.qding.eyecloud.web.cache;

import com.fasterxml.jackson.core.type.TypeReference;
import com.qding.eyecloud.common.constants.EyecloudConstants;
import com.qding.eyecloud.common.data.response.auth.UserDataVO;
import com.qding.eyecloud.common.utils.JsonUtil;
import com.qding.eyecloud.web.facade.RpcFacade;
import com.qding.eyecloud.web.utils.RedisUtil;
import com.qding.eyecloud.web.utils.SpringContextUtils;
import org.apache.commons.lang3.StringUtils;

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
