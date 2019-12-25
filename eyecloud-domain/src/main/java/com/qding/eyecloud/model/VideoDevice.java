package com.qding.eyecloud.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * qdh_hy_视频监控设备表
 * </p>
 *
 * @author CodeGenerator
 * @since 2019-12-04
 */
@TableName("qdh_video_device")
@ApiModel(value="VideoDevice对象", description="qdh_hy_视频监控设备表")
public class VideoDevice implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    private String id;

    @ApiModelProperty(value = "租户id")
    private String tenantId;

    @ApiModelProperty(value = "项目id")
    private String projectId;

    @ApiModelProperty(value = "阿里云设备id")
    private String deviceId;

    @ApiModelProperty(value = "设备名称")
    private String name;

    @ApiModelProperty(value = "设备描述")
    private String description;

    @ApiModelProperty(value = "所属空间id")
    private String groupId;

    @ApiModelProperty(value = "上级设备id")
    private String parentId;

    @ApiModelProperty(value = "设备类型,1:ipc,2:nvr")
    private String type;

    @ApiModelProperty(value = "是否自动启动流")
    private Boolean autoStart;

    @ApiModelProperty(value = "国标id")
    private String gbId;

    @ApiModelProperty(value = "设备ip")
    private String ip;

    @ApiModelProperty(value = "设备端口")
    private String port;

    @ApiModelProperty(value = "设备用户名")
    private String username;

    @ApiModelProperty(value = "设备密码")
    private String password;

    @ApiModelProperty(value = "设备厂商")
    private String vendor;

    @ApiModelProperty(value = "设备删除状态：0可用，1删除")
    private String deviceDisable;

    @ApiModelProperty(value = "设备状态wait_sync：未同步，synced：已同步，on：上线，off：下线")
    private String deviceStatus;

    @ApiModelProperty(value = "设备流id")
    private String deviceStreamId;

    @ApiModelProperty(value = "设备流状态-1：未起流，off:关闭，on：开启")
    private String deviceStreamStatus;

    @ApiModelProperty(value = "设备预览图片")
    private String deviceImageUrl;

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
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Boolean getAutoStart() {
        return autoStart;
    }

    public void setAutoStart(Boolean autoStart) {
        this.autoStart = autoStart;
    }
    public String getGbId() {
        return gbId;
    }

    public void setGbId(String gbId) {
        this.gbId = gbId;
    }
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    public String getDeviceDisable() {
        return deviceDisable;
    }

    public void setDeviceDisable(String deviceDisable) {
        this.deviceDisable = deviceDisable;
    }
    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
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
    public String getDeviceImageUrl() {
        return deviceImageUrl;
    }

    public void setDeviceImageUrl(String deviceImageUrl) {
        this.deviceImageUrl = deviceImageUrl;
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

    @Override
    public String toString() {
        return "VideoDevice{" +
        "id=" + id +
        ", tenantId=" + tenantId +
        ", projectId=" + projectId +
        ", deviceId=" + deviceId +
        ", name=" + name +
        ", description=" + description +
        ", groupId=" + groupId +
        ", parentId=" + parentId +
        ", type=" + type +
        ", autoStart=" + autoStart +
        ", gbId=" + gbId +
        ", ip=" + ip +
        ", port=" + port +
        ", username=" + username +
        ", password=" + password +
        ", vendor=" + vendor +
        ", deviceDisable=" + deviceDisable +
        ", deviceStatus=" + deviceStatus +
        ", deviceStreamId=" + deviceStreamId +
        ", deviceStreamStatus=" + deviceStreamStatus +
        ", deviceImageUrl=" + deviceImageUrl +
        ", creator=" + creator +
        ", createTime=" + createTime +
        ", updator=" + updator +
        ", updateTime=" + updateTime +
        "}";
    }
}
