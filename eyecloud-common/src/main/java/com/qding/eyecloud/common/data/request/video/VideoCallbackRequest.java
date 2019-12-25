package com.qding.eyecloud.common.data.request.video;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.qding.eyecloud.common.data.base.BaseRequest;

/**
 * Desc:阿里设备回调结构体
 * Info:<功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * Date:2019年12月2日 上午9:23:36
 */
public class VideoCallbackRequest extends BaseRequest implements Serializable {
    
    private static final long serialVersionUID = -4873972553057859424L;
    
    @JsonProperty("Event")
    private String event;
    
    @JsonProperty("Time")
    private Long time;
    
    @JsonProperty("DeviceId")
    private String deviceId;
    
    @JsonProperty("DeviceStatus")
    private String deviceStatus;
    
    @JsonProperty("StreamId")
    private String streamId;
    
    @JsonProperty("StreamStatus")
    private String streamStatus;
    
    @JsonProperty("GBId")
    private String gBid;
    
    @JsonProperty("GroupId")
    private String groupId;
    
    public String getEvent() {
        return event;
    }
    
    public void setEvent(String event) {
        this.event = event;
    }
    
    public Long getTime() {
        return time;
    }
    
    public void setTime(Long time) {
        this.time = time;
    }
    
    public String getDeviceId() {
        return deviceId;
    }
    
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    
    public String getDeviceStatus() {
        return deviceStatus;
    }
    
    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }
    
    public String getStreamId() {
        return streamId;
    }
    
    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }
    
    public String getStreamStatus() {
        return streamStatus;
    }
    
    public void setStreamStatus(String streamStatus) {
        this.streamStatus = streamStatus;
    }
    
    public String getgBid() {
        return gBid;
    }
    
    public void setgBid(String gBid) {
        this.gBid = gBid;
    }
    
    public String getGroupId() {
        return groupId;
    }
    
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VideoCallbackRequest [event=")
            .append(event)
            .append(", time=")
            .append(time)
            .append(", deviceId=")
            .append(deviceId)
            .append(", deviceStatus=")
            .append(deviceStatus)
            .append(", streamId=")
            .append(streamId)
            .append(", streamStatus=")
            .append(streamStatus)
            .append(", gBid=")
            .append(gBid)
            .append(", groupId=")
            .append(groupId)
            .append("]");
        return builder.toString();
    }
    
}
