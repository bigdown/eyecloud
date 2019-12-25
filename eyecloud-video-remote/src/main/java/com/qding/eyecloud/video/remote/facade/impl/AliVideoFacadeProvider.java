package com.qding.eyecloud.video.remote.facade.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.vs.model.v20181212.BatchDeleteDevicesRequest;
import com.aliyuncs.vs.model.v20181212.BatchDeleteDevicesResponse;
import com.aliyuncs.vs.model.v20181212.BatchStopDevicesRequest;
import com.aliyuncs.vs.model.v20181212.BatchStopDevicesResponse;
import com.aliyuncs.vs.model.v20181212.CreateDeviceRequest;
import com.aliyuncs.vs.model.v20181212.CreateDeviceResponse;
import com.aliyuncs.vs.model.v20181212.DescribeDeviceChannelsResponse;
import com.aliyuncs.vs.model.v20181212.DescribeDeviceChannelsResponse.Channel;
import com.aliyuncs.vs.model.v20181212.DescribeStreamURLRequest;
import com.aliyuncs.vs.model.v20181212.DescribeStreamURLResponse;
import com.aliyuncs.vs.model.v20181212.ModifyDeviceRequest;
import com.aliyuncs.vs.model.v20181212.ModifyDeviceResponse;
import com.aliyuncs.vs.model.v20181212.StartDeviceRequest;
import com.aliyuncs.vs.model.v20181212.StopDeviceRequest;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.qding.eyecloud.common.constants.Constants;
import com.qding.eyecloud.common.data.base.BaseRequest;
import com.qding.eyecloud.common.data.request.video.VideoCallbackRequest;
import com.qding.eyecloud.common.data.response.video.VideoPreviewVO;
import com.qding.eyecloud.common.enums.CommonDisableEnum;
import com.qding.eyecloud.common.enums.VideoDeviceEnum;
import com.qding.eyecloud.common.exception.A;
import com.qding.eyecloud.common.utils.SnowFlake;
import com.qding.eyecloud.dao.IVideoDeviceChannelDao;
import com.qding.eyecloud.dao.IVideoDeviceDao;
import com.qding.eyecloud.dao.IVideoGroupDao;
import com.qding.eyecloud.model.VideoDevice;
import com.qding.eyecloud.model.VideoDeviceChannel;
import com.qding.eyecloud.model.VideoGroup;
import com.qding.eyecloud.video.facade.IAliVideoFacade;
import com.qding.eyecloud.video.remote.utils.AliyunVideoDeviceUtil;
import com.qding.eyecloud.video.remote.utils.AliyunVideoStreamUtil;

/**
 * Desc: video dubbo服务提供者
 * Info: <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年11月28日
 */
@Service
public class AliVideoFacadeProvider implements IAliVideoFacade {
    
    @Autowired
    private IVideoDeviceDao iVideoDeviceDao;
    
    @Autowired
    private IVideoGroupDao iVideoGroupDao;
    
    @Autowired
    private IVideoDeviceChannelDao iVideoDeviceChannelDao;
    
    public static DefaultProfile PROFILE =
        DefaultProfile.getProfile("cn-shanghai", "LTAI4Ffew9GwqygMKApVfRDe", "c4zIVTu6NOeUvKdRDNnpcSRXyc5sgE");
    
    @Override
    public String manageVideo(VideoDevice request) {
        A.checkParams(request == null || StringUtils
            .isAnyBlank(request.getGbId(), request.getUsername(), request.getPassword(), request.getName()));
        
        if (StringUtils.isBlank(request.getId())) {
            request.setId(SnowFlake.createSnowFlake().nextIdString());
            setGroupId(request);
            checkGbId(request);
            iVideoDeviceDao.save(request);
        } else {
            checkGbId(request);
            iVideoDeviceDao.updateById(request);
        }
        return request.getId();
    }
    
    /**
     * Desc:检查gbId是否已经被占用
     * Info:<功能详细描述>
     * @param request
     * @author tanshen@qding.me
     * Date:2019年12月4日 下午5:45:30
     */
    private void checkGbId(VideoDevice request) {
        // 国标id不能重复
        int exist = iVideoDeviceDao.count(Wrappers.<VideoDevice> lambdaQuery()
            .eq(VideoDevice::getGbId, request.getGbId())
            .ne(VideoDevice::getId, request.getId()));
        A.checkBusiness(exist > 0, "已经存在相同的国标id，请修改国标id的值再次提交");
    }
    
    private void setGroupId(VideoDevice request) {
        // 获取空间id
        List<VideoGroup> videoGroups = iVideoGroupDao.list();
        A.checkBusiness(CollectionUtils.isEmpty(videoGroups), "空间未配置");
        request.setGroupId(videoGroups.stream().findFirst().get().getId());
    }
    
    @Override
    public String removeVideo(BaseRequest request) {
        A.checkParams(request == null || StringUtils.isBlank(request.getId()));
        VideoDevice entity = new VideoDevice();
        entity.setId(request.getId());
        entity.setDeviceDisable(CommonDisableEnum.DIS_ABLED.getCode());
        entity.setDeviceStatus(VideoDeviceEnum.WAIT_SYNC.getCode());
        iVideoDeviceDao.updateById(entity);
        return Constants.COMMON_SUCCESS;
    }
    
    @Override
    public String getDevicePreviewUrl(VideoPreviewVO request) {
        String previewUrl = null;
        DescribeStreamURLRequest describeStreamURLRequest = new DescribeStreamURLRequest();
        describeStreamURLRequest.setId(request.getId());
        describeStreamURLRequest.setOutProtocol(request.getOutProtocol());
        describeStreamURLRequest.setAuthKey(request.getAuthKey());
        describeStreamURLRequest.setExpire(request.getExpire());
        describeStreamURLRequest.setType(request.getType());
        describeStreamURLRequest.setStartTime(request.getStartTime());
        describeStreamURLRequest.setEndTime(request.getEndTime());
        describeStreamURLRequest.setTranscode(request.getTranscode());
        DescribeStreamURLResponse response = AliyunVideoStreamUtil.describeStreamUrl(PROFILE, describeStreamURLRequest);
        if (response != null) {
            previewUrl = response.getUrl();
        }
        return previewUrl;
    }
    
    @Override
    public String syncDevice(BaseRequest request) {
        A.checkParams(request == null);
        syncDeviceCore(request);
        return Constants.COMMON_SUCCESS;
    }
    
    @Override
    public String startDevice(BaseRequest request) {
        A.checkParams(request == null || StringUtils.isBlank(request.getId()));
        
        VideoDevice videoDevice = iVideoDeviceDao.getById(request.getId());
        A.checkBusiness(videoDevice == null, "设备不存在");
        A.checkBusiness(StringUtils.isBlank(videoDevice.getDeviceId()), "设备还未同步，暂不支持该操作");
        
        StartDeviceRequest startDeviceRequest = new StartDeviceRequest();
        startDeviceRequest.setId(videoDevice.getDeviceId());
        // 开启某个设备
        AliyunVideoDeviceUtil.startDevice(PROFILE, startDeviceRequest);
        
        // 同步通道
        syncDeviceChannels(request);
        return Constants.COMMON_SUCCESS;
    }
    
    @Override
    public String stopDevice(BaseRequest request) {
        if (StringUtils.isNotBlank(request.getId())) {
            // 单个stop
            VideoDevice videoDevice = iVideoDeviceDao.getById(request.getId());
            A.checkBusiness(videoDevice == null, "设备不存在");
            StopDeviceRequest stopDeviceRequest = new StopDeviceRequest();
            stopDeviceRequest.setId(request.getId());
            AliyunVideoDeviceUtil.stopDevice(PROFILE, stopDeviceRequest);
        } else {
            List<VideoDevice> videoDevices = iVideoDeviceDao.list(Wrappers.<VideoDevice> lambdaQuery()
                .eq(StringUtils.isNotBlank(request.getProjectId()), VideoDevice::getProjectId, request.getProjectId())
                .eq(StringUtils.isNotBlank(request.getTenantId()), VideoDevice::getTenantId, request.getTenantId()));
            BatchStopDevicesRequest batchStopDevicesRequest = new BatchStopDevicesRequest();
            List<String> list = videoDevices.stream().map(item -> item.getDeviceId()).collect(Collectors.toList());
            batchStopDevicesRequest.setId(StringUtils.join(list, ","));
            // 批量stop
            AliyunVideoDeviceUtil.batchStopDevices(PROFILE, batchStopDevicesRequest);
        }
        return Constants.COMMON_SUCCESS;
    }
    
    @Override
    public String unlockDevice(BaseRequest request) {
        A.checkParams(request == null || StringUtils.isBlank(request.getId()));
        VideoDevice videoDevice = iVideoDeviceDao.getById(request.getId());
        A.checkBusiness(videoDevice == null, "设备不存在");
        AliyunVideoDeviceUtil.unlockDevice(PROFILE, request.getId());
        return Constants.COMMON_SUCCESS;
    }
    
    @Override
    public String syncDeviceChannels(BaseRequest request) {
        A.checkParams(request == null || StringUtils.isBlank(request.getId()));
        VideoDevice videoDevice = iVideoDeviceDao.getById(request.getId());
        A.checkBusiness(videoDevice == null, "设备不存在");
        
        // 获取设备通道信息
        DescribeDeviceChannelsResponse response =
            AliyunVideoDeviceUtil.describeDeviceChannels(PROFILE, request.getId());
        
        if (response != null && !CollectionUtils.isEmpty(response.getChannels())) {
            // 先删除之前的通道信息
            Collection<VideoDeviceChannel> entityList = new ArrayList<VideoDeviceChannel>();
            for (Channel channel : response.getChannels()) {
                VideoDeviceChannel videoDeviceChannel = new VideoDeviceChannel();
                videoDeviceChannel.setId(SnowFlake.createSnowFlake().nextIdString());
                videoDeviceChannel.setTenantId(videoDevice.getTenantId());
                videoDeviceChannel.setProjectId(videoDevice.getProjectId());
                videoDeviceChannel.setVideoDeviceId(videoDevice.getId());
                videoDeviceChannel.setDeviceId(channel.getDeviceId());
                videoDeviceChannel.setName(channel.getName());
                videoDeviceChannel.setGbId(channel.getGbId());
                videoDeviceChannel.setDeviceStreamId(channel.getStreamId());
                videoDeviceChannel.setDeviceStreamStatus(channel.getStreamStatus());
                videoDeviceChannel.setDeviceStatus(channel.getDeviceStatus());
                videoDeviceChannel.setCreator(request.getUserId());
                entityList.add(videoDeviceChannel);
            }
            iVideoDeviceChannelDao.saveBatch(entityList);
        }
        return Constants.COMMON_SUCCESS;
    }
    
    @Override
    public String deviceHeartBeat(VideoCallbackRequest request) {
        // 设备消息（改变设备上线下线状态）
        if (Constants.DEVICE_STATUS.equals(request.getEvent())) {
            // 更新设备上下线状态
            if (StringUtils.isNotBlank(request.getDeviceStatus())) {
                VideoDevice entity = new VideoDevice();
                entity.setDeviceStatus(request.getDeviceStatus());
                iVideoDeviceDao.update(entity,
                    Wrappers.<VideoDevice> lambdaQuery()
                        .eq(VideoDevice::getDeviceId, request.getDeviceId())
                        .eq(VideoDevice::getGroupId, request.getGroupId()));
            }
        }
        // 流消息
        else if (Constants.STREAM_STATUS.equals(request.getEvent())) {
            // 保存流id
            if (StringUtils.isNoneBlank(request.getStreamId(), request.getStreamStatus())) {
                VideoDevice entity = new VideoDevice();
                entity.setDeviceStreamId(request.getStreamId());
                entity.setDeviceStreamStatus(request.getStreamStatus());
                iVideoDeviceDao.update(entity,
                    Wrappers.<VideoDevice> lambdaQuery()
                        .eq(VideoDevice::getDeviceId, request.getDeviceId())
                        .eq(VideoDevice::getGroupId, request.getGroupId()));
            }
        }
        return Constants.COMMON_SUCCESS;
    }
    
    @Override
    public String getSnapshot(BaseRequest request) {
        A.checkParams(request == null || StringUtils.isBlank(request.getId()));
        VideoDevice videoDevice = iVideoDeviceDao.getById(request.getId());
        A.checkBusiness(videoDevice == null, "设备不存在");
        String url = AliyunVideoDeviceUtil.createStreamSnapshot(PROFILE, videoDevice.getDeviceStreamId());
        return url;
    }
    
    /**
     * Desc:核心同步设备方法
     * Info:<功能详细描述>
     * @param request
     * @author tanshen@qding.me
     * Date:2019年12月5日 上午9:27:24
     */
    private void syncDeviceCore(BaseRequest request) {
        // 如果id不为null则表示只同步这一个设备，否则则同步该租户下面该项目下面的所有设备
        // 1查询符合条件的本地设备
        List<VideoDevice> devices = iVideoDeviceDao.list(Wrappers.<VideoDevice> lambdaQuery()
            .eq(StringUtils.isNotBlank(request.getId()), VideoDevice::getId, request.getId())
            .eq(StringUtils.isNotBlank(request.getProjectId()), VideoDevice::getProjectId, request.getProjectId())
            .eq(StringUtils.isNotBlank(request.getTenantId()), VideoDevice::getTenantId, request.getTenantId())
            .eq(VideoDevice::getDeviceStatus, VideoDeviceEnum.WAIT_SYNC.getCode()));
        List<String> allIds = new ArrayList<>();
        // 远程删除的设备id集合
        List<String> remoteDeleteIds = new ArrayList<>();
        // 本地删除的设备id集合
        List<String> localDeleteIds = new ArrayList<>();
        // 远程新增的设备id集合
        List<String> remoteAddIds = new ArrayList<>();
        // 远程修改的设备id集合
        List<String> remoteModifyIds = new ArrayList<>();
        // 远程新增的设备集合
        List<VideoDevice> remoteAddObjs = new ArrayList<>();
        // 远程修改的设备集合
        List<VideoDevice> remoteModifyObjs = new ArrayList<>();
        for (VideoDevice videoDevice : devices) {
            // 远程删除的条件是：本地已经删除，且远程有同步该设备信息
            if (videoDevice.getDeviceDisable().equals(CommonDisableEnum.DIS_ABLED.getCode())
                && StringUtils.isNotBlank(videoDevice.getDeviceId())) {
                remoteDeleteIds.add(videoDevice.getDeviceId());
                localDeleteIds.add(videoDevice.getId());
            }
            // 远程新增的条件为：本地未删除，且本地没有阿里云设备id的设备
            if (videoDevice.getDeviceDisable().equals(CommonDisableEnum.ABLED.getCode())
                && StringUtils.isBlank(videoDevice.getDeviceId())) {
                remoteAddObjs.add(videoDevice);
            }
            // 远程修改的条件为： 本地未删除，且本地有阿里云设备id的设备
            if (videoDevice.getDeviceDisable().equals(CommonDisableEnum.ABLED.getCode())
                && StringUtils.isNotBlank(videoDevice.getDeviceId())) {
                remoteModifyObjs.add(videoDevice);
            }
            allIds.add(videoDevice.getDeviceId());
        }
        
        if (!CollectionUtils.isEmpty(remoteDeleteIds)) {
            VideoDevice entity = new VideoDevice();
            entity.setDeviceStatus(VideoDeviceEnum.SYNCING.getCode());
            entity.setDeviceDisable(CommonDisableEnum.DIS_ABLED.getCode());
            iVideoDeviceDao.update(entity,
                Wrappers.<VideoDevice> lambdaQuery().in(VideoDevice::getDeviceId, remoteDeleteIds));
        }
        // 远程ModifyDevice
        if (!CollectionUtils.isEmpty(remoteModifyObjs)) {
            for (VideoDevice videoDevice : remoteModifyObjs) {
                remoteModifyIds.add(videoDevice.getId());
                videoDevice.setDeviceStatus(VideoDeviceEnum.SYNCING.getCode());
            }
            iVideoDeviceDao.updateBatchById(remoteModifyObjs);
        }
        
        // 远程CreateDevice
        if (!CollectionUtils.isEmpty(remoteAddObjs)) {
            for (VideoDevice videoDevice : remoteAddObjs) {
                remoteAddIds.add(videoDevice.getId());
                videoDevice.setDeviceStatus(VideoDeviceEnum.SYNCING.getCode());
            }
            iVideoDeviceDao.updateBatchById(remoteAddObjs);
        }
        
        // 异步操作
        if (!CollectionUtils.isEmpty(remoteDeleteIds)) {
            syncDelete(remoteDeleteIds);
        }
        // 远程ModifyDevice
        if (!CollectionUtils.isEmpty(remoteModifyIds)) {
            syncModify(remoteModifyIds);
        }
        // 远程CreateDevice
        if (!CollectionUtils.isEmpty(remoteAddIds)) {
            syncCreate(remoteAddIds);
        }
    }
    
    /**
     * Desc:阿里云视频平台同步删除
     * Info:<功能详细描述>
     * @param remoteDeleteIds
     * @author tanshen@qding.me
     * Date:2019年11月29日 上午11:34:39
     */
    private void syncDelete(List<String> remoteDeleteIds) {
        // 远程BatchStopDevices、然后BatchDeleteDevices
        String ids = StringUtils.join(remoteDeleteIds.toArray(), ",");
        BatchStopDevicesRequest batchStopDevicesRequest = new BatchStopDevicesRequest();
        batchStopDevicesRequest.setId(ids);
        BatchStopDevicesResponse stopResult = AliyunVideoDeviceUtil.batchStopDevices(PROFILE, batchStopDevicesRequest);
        if (stopResult != null) {
            BatchDeleteDevicesRequest batchDeleteDevicesRequest = new BatchDeleteDevicesRequest();
            batchDeleteDevicesRequest.setId(ids);
            BatchDeleteDevicesResponse removeResult =
                AliyunVideoDeviceUtil.batchDeleteDevices(PROFILE, batchDeleteDevicesRequest);
            VideoDevice entity = new VideoDevice();
            entity.setDeviceStatus(VideoDeviceEnum.SYNCING.getCode());
            if (removeResult != null) {
                iVideoDeviceDao.update(entity,
                    Wrappers.<VideoDevice> lambdaQuery().in(VideoDevice::getDeviceId, remoteDeleteIds));
            }
        }
    }
    
    /**
     * Desc:阿里云视频平台同步修改
     * Info:<功能详细描述>
     * @param remoteModifyIds
     * @author tanshen@qding.me
     * Date:2019年11月29日 上午11:34:59
     */
    private void syncModify(List<String> remoteModifyIds) {
        List<VideoDevice> remoteModifyObjs =
            iVideoDeviceDao.list(Wrappers.<VideoDevice> lambdaQuery().in(VideoDevice::getId, remoteModifyIds));
        for (VideoDevice videoDevice : remoteModifyObjs) {
            if (videoDevice.getDeviceStatus().equals(VideoDeviceEnum.SYNCING.getCode())) {
                ModifyDeviceRequest modifyDeviceRequest = new ModifyDeviceRequest();
                modifyDeviceRequest.setId(videoDevice.getDeviceId());
                modifyDeviceRequest.setName(videoDevice.getName());
                modifyDeviceRequest.setDescription(videoDevice.getDescription());
                modifyDeviceRequest.setType(videoDevice.getType());
                modifyDeviceRequest.setAutoStart(videoDevice.getAutoStart());
                modifyDeviceRequest.setGbId(videoDevice.getGbId());
                modifyDeviceRequest.setIp(videoDevice.getIp());
                modifyDeviceRequest
                    .setPort(StringUtils.isBlank(videoDevice.getPort()) ? null : Long.valueOf(videoDevice.getPort()));
                modifyDeviceRequest.setUsername(videoDevice.getUsername());
                modifyDeviceRequest.setPassword(videoDevice.getPassword());
                modifyDeviceRequest.setVendor(videoDevice.getVendor());
                ModifyDeviceResponse modifyResult = AliyunVideoDeviceUtil.modifyDevice(PROFILE, modifyDeviceRequest);
                if (modifyResult != null) {
                    videoDevice.setDeviceStatus(VideoDeviceEnum.SYNCED.getCode());
                }
            }
        }
        iVideoDeviceDao.updateBatchById(remoteModifyObjs);
    }
    
    /**
     * Desc:阿里云视频平台同步新增
     * Info:<功能详细描述>
     * @param remoteAddIds
     * @author tanshen@qding.me
     * Date:2019年11月29日 上午11:35:10
     */
    private void syncCreate(List<String> remoteAddIds) {
        List<VideoDevice> remoteAddObjs =
            iVideoDeviceDao.list(Wrappers.<VideoDevice> lambdaQuery().in(VideoDevice::getId, remoteAddIds));
        for (VideoDevice videoDevice : remoteAddObjs) {
            if (videoDevice.getDeviceStatus().equals(VideoDeviceEnum.SYNCING.getCode())) {
                CreateDeviceRequest createDeviceRequest = new CreateDeviceRequest();
                createDeviceRequest.setName(videoDevice.getName());
                createDeviceRequest.setDescription(videoDevice.getDescription());
                createDeviceRequest.setGroupId(videoDevice.getGroupId());
                createDeviceRequest.setParentId(videoDevice.getParentId());
                createDeviceRequest.setType(videoDevice.getType());
                createDeviceRequest.setAutoStart(videoDevice.getAutoStart());
                createDeviceRequest.setGbId(videoDevice.getGbId());
                createDeviceRequest.setIp(videoDevice.getIp());
                createDeviceRequest
                    .setPort(StringUtils.isBlank(videoDevice.getPort()) ? null : Long.valueOf(videoDevice.getPort()));
                createDeviceRequest.setUsername(videoDevice.getUsername());
                createDeviceRequest.setPassword(videoDevice.getPassword());
                createDeviceRequest.setVendor(videoDevice.getVendor());
                CreateDeviceResponse addResult = AliyunVideoDeviceUtil.createDevice(PROFILE, createDeviceRequest);
                if (addResult != null) {
                    videoDevice.setDeviceId(addResult.getId());
                    videoDevice.setDeviceStatus(VideoDeviceEnum.SYNCED.getCode());
                }
            }
        }
        iVideoDeviceDao.updateBatchById(remoteAddObjs);
    }
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        System.out.println(StringUtils.join(list, ","));
    }
}
