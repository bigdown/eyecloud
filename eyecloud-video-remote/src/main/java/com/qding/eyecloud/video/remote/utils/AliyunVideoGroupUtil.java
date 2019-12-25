package com.qding.eyecloud.video.remote.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.vs.model.v20181212.CreateGroupRequest;
import com.aliyuncs.vs.model.v20181212.CreateGroupResponse;
import com.aliyuncs.vs.model.v20181212.DeleteGroupRequest;
import com.aliyuncs.vs.model.v20181212.DeleteGroupResponse;
import com.aliyuncs.vs.model.v20181212.DescribeGroupRequest;
import com.aliyuncs.vs.model.v20181212.DescribeGroupResponse;
import com.aliyuncs.vs.model.v20181212.DescribeGroupsRequest;
import com.aliyuncs.vs.model.v20181212.DescribeGroupsResponse;
import com.aliyuncs.vs.model.v20181212.ModifyGroupRequest;
import com.aliyuncs.vs.model.v20181212.ModifyGroupResponse;

/**
 * 阿里云视频监控--空间相关工具类
 * <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年10月14日
 */
public class AliyunVideoGroupUtil {
    
    /**
     * Desc:新增空间
     * Info:<功能详细描述>
     * @param profile
     * @param request
     * @return
     * @author tanshen@qding.me
     * Date:2019年11月29日 上午10:45:25
     */
    public static CreateGroupResponse createGroup(DefaultProfile profile, CreateGroupRequest request) {
        CreateGroupResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * Desc:删除空间
     * Info:<功能详细描述>
     * @param profile
     * @param request
     * @return
     * @author tanshen@qding.me
     * Date:2019年11月29日 上午10:45:46
     */
    public static DeleteGroupResponse deleteGroup(DefaultProfile profile, DeleteGroupRequest request) {
        DeleteGroupResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * Desc:获取空间信息
     * Info:<功能详细描述>
     * @param profile
     * @param request
     * @return
     * @author tanshen@qding.me
     * Date:2019年11月29日 上午10:46:02
     */
    public static DescribeGroupResponse describeGroup(DefaultProfile profile, DescribeGroupRequest request) {
        DescribeGroupResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * Desc:批量获取空间信息
     * Info:<功能详细描述>
     * @param profile
     * @param request
     * @return
     * @author tanshen@qding.me
     * Date:2019年11月29日 上午10:46:15
     */
    public static DescribeGroupsResponse describeGroups(DefaultProfile profile, DescribeGroupsRequest request) {
        DescribeGroupsResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * Desc:修改空间信息
     * Info:<功能详细描述>
     * @param profile
     * @param request
     * @return
     * @author tanshen@qding.me
     * Date:2019年11月29日 上午10:46:26
     */
    public static ModifyGroupResponse modifyGroup(DefaultProfile profile, ModifyGroupRequest request) {
        ModifyGroupResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
}
