package com.qding.eyecloud.video.remote.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.vs.model.v20181212.BatchDeleteDevicesRequest;
import com.aliyuncs.vs.model.v20181212.BatchDeleteDevicesResponse;
import com.aliyuncs.vs.model.v20181212.BatchStartDevicesRequest;
import com.aliyuncs.vs.model.v20181212.BatchStartDevicesResponse;
import com.aliyuncs.vs.model.v20181212.BatchStopDevicesRequest;
import com.aliyuncs.vs.model.v20181212.BatchStopDevicesResponse;
import com.aliyuncs.vs.model.v20181212.ContinuousAdjustRequest;
import com.aliyuncs.vs.model.v20181212.ContinuousAdjustResponse;
import com.aliyuncs.vs.model.v20181212.ContinuousMoveRequest;
import com.aliyuncs.vs.model.v20181212.ContinuousMoveResponse;
import com.aliyuncs.vs.model.v20181212.CreateDeviceRequest;
import com.aliyuncs.vs.model.v20181212.CreateDeviceResponse;
import com.aliyuncs.vs.model.v20181212.CreateStreamSnapshotRequest;
import com.aliyuncs.vs.model.v20181212.CreateStreamSnapshotResponse;
import com.aliyuncs.vs.model.v20181212.DeleteDeviceRequest;
import com.aliyuncs.vs.model.v20181212.DeleteDeviceResponse;
import com.aliyuncs.vs.model.v20181212.DescribeDeviceChannelsRequest;
import com.aliyuncs.vs.model.v20181212.DescribeDeviceChannelsResponse;
import com.aliyuncs.vs.model.v20181212.DescribeDeviceRequest;
import com.aliyuncs.vs.model.v20181212.DescribeDeviceResponse;
import com.aliyuncs.vs.model.v20181212.DescribeDevicesRequest;
import com.aliyuncs.vs.model.v20181212.DescribeDevicesResponse;
import com.aliyuncs.vs.model.v20181212.ModifyDeviceRequest;
import com.aliyuncs.vs.model.v20181212.ModifyDeviceResponse;
import com.aliyuncs.vs.model.v20181212.StartDeviceRequest;
import com.aliyuncs.vs.model.v20181212.StartDeviceResponse;
import com.aliyuncs.vs.model.v20181212.StopAdjustRequest;
import com.aliyuncs.vs.model.v20181212.StopAdjustResponse;
import com.aliyuncs.vs.model.v20181212.StopDeviceRequest;
import com.aliyuncs.vs.model.v20181212.StopDeviceResponse;
import com.aliyuncs.vs.model.v20181212.StopMoveRequest;
import com.aliyuncs.vs.model.v20181212.StopMoveResponse;
import com.aliyuncs.vs.model.v20181212.UnlockDeviceRequest;
import com.aliyuncs.vs.model.v20181212.UnlockDeviceResponse;

/**
 * 阿里云视频监控-设备相关接口工具类
 * <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年10月14日
 */
public class AliyunVideoDeviceUtil {
    
    private static final Logger LOG = LoggerFactory.getLogger(AliyunVideoDeviceUtil.class);
    
    /**
     * 批量删除设备
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static BatchDeleteDevicesResponse batchDeleteDevices(DefaultProfile profile,
        BatchDeleteDevicesRequest request) {
        BatchDeleteDevicesResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
            LOG.error("批量删除设备报错：{}", e);
        } catch (ClientException e) {
            LOG.error("批量删除设备报错：{}", e);
        }
        return response;
    }
    
    /**
     * 批量启动设备拉流
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static BatchStartDevicesResponse batchStartDevices(DefaultProfile profile,
        BatchStartDevicesRequest request) {
        BatchStartDevicesResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
            LOG.error("批量启动设备报错：{}", e);
        } catch (ClientException e) {
            LOG.error("批量启动设备报错：{}", e);
        }
        return response;
    }
    
    /**
     * 批量停止设备拉流
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static BatchStopDevicesResponse batchStopDevices(DefaultProfile profile, BatchStopDevicesRequest request) {
        BatchStopDevicesResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
            LOG.error("批量停止设备报错：{}", e);
        } catch (ClientException e) {
            LOG.error("批量停止设备报错：{}", e);
        }
        return response;
    }
    
    /**
     * <添加新设备。>
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static CreateDeviceResponse createDevice(DefaultProfile profile, CreateDeviceRequest request) {
        CreateDeviceResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
            LOG.error("添加新设备报错：{}", e);
        } catch (ClientException e) {
            LOG.error("添加新设备报错：{}", e);
        }
        return response;
    }
    
    /**
     * 删除设备。
     * 需先停止设备再删除
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static DeleteDeviceResponse deleteDevice(DefaultProfile profile, DeleteDeviceRequest request) {
        DeleteDeviceResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
            LOG.error("删除设备报错：{}", e);
        } catch (ClientException e) {
            LOG.error("删除设备报错：{}", e);
        }
        return response;
    }
    
    /**
     * 查询设备信息
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static DescribeDeviceResponse describeDevice(DefaultProfile profile, DescribeDeviceRequest request) {
        DescribeDeviceResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
            LOG.error("查询设备信息报错：{}", e);
        } catch (ClientException e) {
            LOG.error("查询设备信息报错：{}", e);
        }
        return response;
    }
    
    /**
     * 查询设备列表
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static DescribeDevicesResponse describeDevices(DefaultProfile profile, DescribeDevicesRequest request) {
        DescribeDevicesResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
            LOG.error("查询设备列表报错：{}", e);
        } catch (ClientException e) {
            LOG.error("查询设备列表报错：{}", e);
        }
        return response;
    }
    
    /**
     * 修改设备信息
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static ModifyDeviceResponse modifyDevice(DefaultProfile profile, ModifyDeviceRequest request) {
        ModifyDeviceResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
            LOG.error("修改设备信息报错：{}", e);
        } catch (ClientException e) {
            LOG.error("修改设备信息报错：{}", e);
        }
        return response;
    }
    
    /**
     * 启动设备拉流，会启动设备上的所有流
     * 目前每个设备仅支持单路流，效果等同于StartStream
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static StartDeviceResponse startDevice(DefaultProfile profile, StartDeviceRequest request) {
        StartDeviceResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
            LOG.error("启动设备拉流报错：{}", e);
        } catch (ClientException e) {
            LOG.error("启动设备拉流报错：{}", e);
        }
        return response;
    }
    
    /**
     * 停止设备拉流，会停止设备上的所有流
     * 目前每个设备仅支持单路流，效果等同于StopStream
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static StopDeviceResponse stopDevice(DefaultProfile profile, StopDeviceRequest request) {
        StopDeviceResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
            LOG.error("停止设备拉流报错：{}", e);
        } catch (ClientException e) {
            LOG.error("停止设备拉流报错：{}", e);
        }
        return response;
    }
    
    /**
     * 持续调节镜头，如光圈、变焦等
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static ContinuousAdjustResponse continuousAdjust(DefaultProfile profile, ContinuousAdjustRequest request) {
        ContinuousAdjustResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 持续转动镜头，如水平、垂直、缩放等
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static ContinuousMoveResponse continuousMove(DefaultProfile profile, ContinuousMoveRequest request) {
        ContinuousMoveResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 停止调节镜头，如光圈、变焦等
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static StopAdjustResponse stopAdjust(DefaultProfile profile, StopAdjustRequest request) {
        StopAdjustResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 停止转动镜头，如水平、垂直、缩放等
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static StopMoveResponse stopMove(DefaultProfile profile, StopMoveRequest request) {
        StopMoveResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 设置预置点位
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月29日
     */
    public static StopMoveResponse setPresetPoint(DefaultProfile profile, StopMoveRequest request) {
        StopMoveResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * Desc:远程拉取截图
     * Info:<功能详细描述>
     * @param streamId
     * @return
     * @author tanshen@qding.me
     * Date:2019年11月29日 上午10:47:25
     */
    public static String createStreamSnapshot(DefaultProfile profile, String streamId) {
        String url = null;
        CreateStreamSnapshotRequest request = new CreateStreamSnapshotRequest();
        request.setId(streamId);
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            CreateStreamSnapshotResponse response = client.getAcsResponse(request);
            url = response.getUrl();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return url;
    }
    
    /**
     * Desc:获取设备通道列表
     * Info:<功能详细描述>
     * @param profile
     * @param id
     * @return
     * @author tanshen@qding.me
     * Date:2019年12月5日 上午10:35:58
     */
    public static DescribeDeviceChannelsResponse describeDeviceChannels(DefaultProfile profile, String id) {
        DescribeDeviceChannelsResponse response = null;
        DescribeDeviceChannelsRequest request = new DescribeDeviceChannelsRequest();
        request.setId(id);
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return response;
    }
    
    /**
     * Desc:解锁设备
     * Info:<功能详细描述>
     * @param profile
     * @param id
     * @return
     * @author tanshen@qding.me
     * Date:2019年12月5日 下午12:03:41
     */
    public static UnlockDeviceResponse unlockDevice(DefaultProfile profile, String id) {
        UnlockDeviceResponse response = null;
        UnlockDeviceRequest request = new UnlockDeviceRequest();
        request.setId(id);
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return response;
    }
    
    public static void main(String[] args) {
        System.out.println(createStreamSnapshot(null, "130704579397509145-cn-shanghai"));
    }
}
