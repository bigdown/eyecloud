package com.qding.eyecloud.video.remote.utils;

import com.aliyuncs.AcsRequest;
import com.aliyuncs.AcsResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Desc:<一句话功能简述>
 * Info:<功能详细描述>
 * @since [产品/模块版本]
 * @author tanshen@qding.me
 * Date: 2019/12/30 13:51
 */
public class AliyunCoreUtil {

    public static DefaultProfile profile =
            DefaultProfile.getProfile("cn-shanghai", "LTAI4Ffew9GwqygMKApVfRDe", "c4zIVTu6NOeUvKdRDNnpcSRXyc5sgE");

    private static final Logger logger = LoggerFactory.getLogger(AliyunCoreUtil.class);

    /**
     * Desc:<一句话功能简述>
     * Info:<功能详细描述>
     * @since [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * Date:2019/12/30 13:58
     */
    public static AcsResponse core(AcsRequest<? extends AcsResponse> request) {
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            return client.getAcsResponse(request);
        } catch (ServerException e) {
            logger.error("ServerException:{}", e.getMessage());
        } catch (ClientException e) {
            logger.error("ClientException:{}", e.getMessage());
        }
        return null;
    }

}
