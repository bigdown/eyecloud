package com.qding.eyecloud.video.remote.utils;

import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.vs.model.v20181212.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 阿里云视频监控-设备相关接口工具类
 * <功能详细描述>
 * @since [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年10月14日
 */
public class AliyunVideoDeviceUtil {

    private static final Logger LOG = LoggerFactory.getLogger(AliyunVideoDeviceUtil.class);

    /**
     * 批量删除设备
     * <功能详细描述>
     * @param request
     * @return
     * @since [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static BatchDeleteDevicesResponse batchDeleteDevices(BatchDeleteDevicesRequest request) {
        return (BatchDeleteDevicesResponse)AliyunCoreUtil.core(request);
    }

    /**
     * 批量启动设备拉流
     * <功能详细描述>
     * @param request
     * @return
     * @since [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static BatchStartDevicesResponse batchStartDevices(BatchStartDevicesRequest request) {
        return (BatchStartDevicesResponse)AliyunCoreUtil.core(request);
    }

    /**
     * 批量停止设备拉流
     * <功能详细描述>
     * @param request
     * @return
     * @since [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static BatchStopDevicesResponse batchStopDevices(BatchStopDevicesRequest request) {
        return (BatchStopDevicesResponse)AliyunCoreUtil.core(request);
    }

    /**
     * <添加新设备。>
     * <功能详细描述>
     * @param request
     * @return
     * @since [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static CreateDeviceResponse createDevice(CreateDeviceRequest request) {
        return (CreateDeviceResponse)AliyunCoreUtil.core(request);
    }

    /**
     * 删除设备。
     * 需先停止设备再删除
     * @param request
     * @return
     * @since [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static DeleteDeviceResponse deleteDevice(DefaultProfile profile, DeleteDeviceRequest request) {
        return (DeleteDeviceResponse)AliyunCoreUtil.core(request);
    }

    /**
     * 查询设备信息
     * <功能详细描述>
     * @param request
     * @return
     * @since [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static DescribeDeviceResponse describeDevice(DescribeDeviceRequest request) {
        return (DescribeDeviceResponse)AliyunCoreUtil.core(request);
    }

    /**
     * Desc:获取设备通道列表
     * Info:<功能详细描述>
     * @since [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * Date:2020/1/2 10:13
     */
    public static DescribeDeviceChannelsResponse describeDeviceChannels(DescribeDeviceChannelsRequest request) {
        return (DescribeDeviceChannelsResponse)AliyunCoreUtil.core(request);
    }

    /**
     * 查询设备列表
     * <功能详细描述>
     * @param request
     * @return
     * @since [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static DescribeDevicesResponse describeDevices(DescribeDevicesRequest request) {
        return (DescribeDevicesResponse)AliyunCoreUtil.core(request);
    }

    /**
     * 修改设备信息
     * <功能详细描述>
     * @param request
     * @return
     * @since [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static ModifyDeviceResponse modifyDevice(ModifyDeviceRequest request) {
        return (ModifyDeviceResponse)AliyunCoreUtil.core(request);
    }

    /**
     * 启动设备拉流，会启动设备上的所有流
     * 目前每个设备仅支持单路流，效果等同于StartStream
     * @param deviceId
     * @return
     * @since [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static StartDeviceResponse startDevice(String deviceId) {
        StartDeviceRequest request = new StartDeviceRequest();
        request.setId(deviceId);
        return (StartDeviceResponse)AliyunCoreUtil.core(request);
    }

    /**
     * 停止设备拉流，会停止设备上的所有流
     * 目前每个设备仅支持单路流，效果等同于StopStream
     * @param request
     * @return
     * @since [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static StopDeviceResponse stopDevice(StopDeviceRequest request) {
        return (StopDeviceResponse)AliyunCoreUtil.core(request);
    }

    /**
     * 持续调节镜头，如光圈、变焦等
     * <功能详细描述>
     * @param request
     * @return
     * @since [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static ContinuousAdjustResponse continuousAdjust(ContinuousAdjustRequest request) {
        return (ContinuousAdjustResponse)AliyunCoreUtil.core(request);
    }

    /**
     * 持续转动镜头，如水平、垂直、缩放等
     * <功能详细描述>
     * @param request
     * @return
     * @since [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static ContinuousMoveResponse continuousMove(ContinuousMoveRequest request) {
        return (ContinuousMoveResponse)AliyunCoreUtil.core(request);
    }

    /**
     * 停止调节镜头，如光圈、变焦等
     * <功能详细描述>
     * @param request
     * @return
     * @since [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static StopAdjustResponse stopAdjust(StopAdjustRequest request) {
        return (StopAdjustResponse)AliyunCoreUtil.core(request);
    }

    /**
     * 停止转动镜头，如水平、垂直、缩放等
     * <功能详细描述>
     * @param request
     * @return
     * @since [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static StopMoveResponse stopMove(StopMoveRequest request) {
        return (StopMoveResponse)AliyunCoreUtil.core(request);
    }

    /**
     * 设置预置点位
     * <功能详细描述>
     * @param deviceId
     * @param presetId
     * @return
     * @since [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月29日
     */
    public static SetPresetResponse setPresetPoint(String deviceId, String presetId) {
        SetPresetRequest request = new SetPresetRequest();
        request.setId(deviceId);
        request.setPresetId(presetId);
        return (SetPresetResponse)AliyunCoreUtil.core(request);
    }

    /**
     * Desc:转到某个预置点位
     * Info:<功能详细描述>
     * @since [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * Date:2020/1/3 14:11
     */
    public static GotoPresetResponse gotoPresetPoint(String deviceId, String presetId) {
        GotoPresetRequest request = new GotoPresetRequest();
        request.setId(deviceId);
        request.setPresetId(presetId);
        return (GotoPresetResponse)AliyunCoreUtil.core(request);
    }

    /**
     * Desc:删除预置点位
     * Info:<功能详细描述>
     * @since [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * Date:2020/1/3 14:12
     */
    public static DeletePresetResponse deletePresetPoint(String deviceId, String presetId) {
        DeletePresetRequest request = new DeletePresetRequest();
        request.setId(deviceId);
        request.setPresetId(presetId);
        return (DeletePresetResponse)AliyunCoreUtil.core(request);
    }

    /**
     * description: 设备解锁
     * info: <详细信息>
     * @since [产品/模块版本]
     * @param deviceId
     * @return com.aliyuncs.vs.model.v20181212.UnlockDeviceResponse
     * @author: tanshen@qding.me
     * @Date: 2020年01月18日 14:22
     */
    public static UnlockDeviceResponse unlockDevice(String deviceId) {
        UnlockDeviceRequest request = new UnlockDeviceRequest();
        request.setId(deviceId);
        return (UnlockDeviceResponse)AliyunCoreUtil.core(request);
    }
}
