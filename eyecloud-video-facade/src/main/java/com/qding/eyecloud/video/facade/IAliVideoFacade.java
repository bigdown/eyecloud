package com.qding.eyecloud.video.facade;

import com.qding.eyecloud.common.data.base.BaseRequest;
import com.qding.eyecloud.common.data.request.video.VideoCallbackRequest;
import com.qding.eyecloud.common.data.response.video.VideoPreviewVO;
import com.qding.eyecloud.model.VideoDevice;

/**
 * Desc:阿里视频facade
 * Info:<功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * Date:2019年12月4日 下午3:26:12
 */
public interface IAliVideoFacade {
    
    /**
     * Desc:新增、修改设备
     * Info:<功能详细描述>
     * @param videoDevice
     * @return
     * @author tanshen@qding.me
     * Date:2019年12月4日 下午3:32:19
     */
    String manageVideo(VideoDevice videoDevice);
    
    /**
     * Desc:删除设备
     * Info:<功能详细描述>
     * @param videoDevice
     * @return
     * @author tanshen@qding.me
     * Date:2019年12月4日 下午3:32:54
     */
    String removeVideo(BaseRequest request);
    
    /**
     * Desc:获取设备播流url
     * Info:<功能详细描述>
     * @param request
     * @return
     * @author tanshen@qding.me
     * Date:2019年12月4日 下午3:47:25
     */
    String getDevicePreviewUrl(VideoPreviewVO request);
    
    /**
     * Desc:同步设备
     * Info:<功能详细描述>
     * @param request
     * @return
     * @author tanshen@qding.me
     * Date:2019年12月4日 下午3:51:59
     */
    String syncDevice(BaseRequest request);
    
    /**
     * Desc:开启设备
     * Info:<功能详细描述>
     * @param request
     * @return
     * @author tanshen@qding.me
     * Date:2019年12月4日 下午3:52:23
     */
    String startDevice(BaseRequest request);
    
    /**
     * Desc:停止设备
     * Info:<功能详细描述>
     * @param request
     * @return
     * @author tanshen@qding.me
     * Date:2019年12月4日 下午3:52:42
     */
    String stopDevice(BaseRequest request);
    
    /**
     * Desc:解锁设备
     * Info:<功能详细描述>
     * @param request
     * @return
     * @author tanshen@qding.me
     * Date:2019年12月4日 下午4:07:38
     */
    String unlockDevice(BaseRequest request);
    
    /**
     * Desc:同步设备通道信息
     * Info:<功能详细描述>
     * @param request
     * @return
     * @author tanshen@qding.me
     * Date:2019年12月4日 下午4:04:34
     */
    String syncDeviceChannels(BaseRequest request);
    
    /**
     * Desc:获取指定设备的截图
     * Info:<功能详细描述>
     * @param request
     * @return
     * @author tanshen@qding.me
     * Date:2019年12月4日 下午4:09:44
     */
    String getSnapshot(BaseRequest request);

    /**
     * Desc:阿里设备心跳上报
     * Info:<功能详细描述>
     * @param request
     * @return
     * @author tanshen@qding.me
     * Date:2019年12月5日 下午1:49:57
     */
    String deviceHeartBeat(VideoCallbackRequest request);
    
    
}
