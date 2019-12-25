package com.qding.eyecloud.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * qdh_视频监控设备通道
 * </p>
 *
 * @author CodeGenerator
 * @since 2019-12-04
 */
@TableName("qdh_video_device_channel")
@ApiModel(value = "VideoDeviceChannel对象", description = "qdh_视频监控设备通道")
public class VideoDeviceChannel implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(value = "主键id")
    private String id;
    
    @ApiModelProperty(value = "租户id")
    private String tenantId;
    
    @ApiModelProperty(value = "项目id")
    private String projectId;
    
    @ApiModelProperty(value = "video_device表id")
    private String videoDeviceId;
    
    @ApiModelProperty(value = "阿里云设备id")
    private String deviceId;
    
    @ApiModelProperty(value = "通道名称")
    private String name;
    
    @ApiModelProperty(value = "国标id")
    private String gbId;
    
    @ApiModelProperty(value = "设备流id")
    private String deviceStreamId;
    
    @ApiModelProperty(value = "设备流状态-1：未起流，off:关闭，on：开启")
    private String deviceStreamStatus;
    
    @ApiModelProperty(value = "设备状态wait_sync：未同步，synced：已同步，on：上线，off：下线")
    private String deviceStatus;
    
    @ApiModelProperty(value = "创建人")
    private String creator;
    
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    
    @ApiModelProperty(value = "修改人")
    private String updator;
    
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getTenantId() {
        return tenantId;
    }
    
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
    
    public String getProjectId() {
        return projectId;
    }
    
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
    
    public String getVideoDeviceId() {
        return videoDeviceId;
    }
    
    public void setVideoDeviceId(String videoDeviceId) {
        this.videoDeviceId = videoDeviceId;
    }
    
    public String getDeviceId() {
        return deviceId;
    }
    
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getGbId() {
        return gbId;
    }
    
    public void setGbId(String gbId) {
        this.gbId = gbId;
    }
    
    public String getDeviceStreamId() {
        return deviceStreamId;
    }
    
    public void setDeviceStreamId(String deviceStreamId) {
        this.deviceStreamId = deviceStreamId;
    }
    
    public String getDeviceStreamStatus() {
        return deviceStreamStatus;
    }
    
    public void setDeviceStreamStatus(String deviceStreamStatus) {
        this.deviceStreamStatus = deviceStreamStatus;
    }
    
    public String getCreator() {
        return creator;
    }
    
    public void setCreator(String creator) {
        this.creator = creator;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public String getUpdator() {
        return updator;
    }
    
    public void setUpdator(String updator) {
        this.updator = updator;
    }
    
    public Date getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    public String getDeviceStatus() {
        return deviceStatus;
    }
    
    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VideoDeviceChannel [id=")
            .append(id)
            .append(", tenantId=")
            .append(tenantId)
            .append(", projectId=")
            .append(projectId)
            .append(", videoDeviceId=")
            .append(videoDeviceId)
            .append(", deviceId=")
            .append(deviceId)
            .append(", name=")
            .append(name)
            .append(", gbId=")
            .append(gbId)
            .append(", deviceStreamId=")
            .append(deviceStreamId)
            .append(", deviceStreamStatus=")
            .append(deviceStreamStatus)
            .append(", deviceStatus=")
            .append(deviceStatus)
            .append(", creator=")
            .append(creator)
            .append(", createTime=")
            .append(createTime)
            .append(", updator=")
            .append(updator)
            .append(", updateTime=")
            .append(updateTime)
            .append("]");
        return builder.toString();
    }
}
