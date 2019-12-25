package com.qding.eyecloud.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * qdh_hy_视频监控空间表
 * </p>
 *
 * @author CodeGenerator
 * @since 2019-12-04
 */
@TableName("qdh_video_group")
@ApiModel(value="VideoGroup对象", description="qdh_hy_视频监控空间表")
public class VideoGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    private String id;

    @ApiModelProperty(value = "空间名称")
    private String name;

    @ApiModelProperty(value = "空间描述")
    private String description;

    @ApiModelProperty(value = "区域")
    private String region;

    @ApiModelProperty(value = "空间使用的应用名称")
    private String groupApp;

    @ApiModelProperty(value = "接入协议")
    private String inProtocol;

    @ApiModelProperty(value = "播放协议")
    private String outProtocol;

    @ApiModelProperty(value = "推流域名")
    private String pushDomain;

    @ApiModelProperty(value = "播流域名")
    private String playDomain;

    @ApiModelProperty(value = "播流域名主key")
    private String playDomainKey;

    @ApiModelProperty(value = "回调路径")
    private String callback;

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
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    public String getGroupApp() {
        return groupApp;
    }

    public void setGroupApp(String groupApp) {
        this.groupApp = groupApp;
    }
    public String getInProtocol() {
        return inProtocol;
    }

    public void setInProtocol(String inProtocol) {
        this.inProtocol = inProtocol;
    }
    public String getOutProtocol() {
        return outProtocol;
    }

    public void setOutProtocol(String outProtocol) {
        this.outProtocol = outProtocol;
    }
    public String getPushDomain() {
        return pushDomain;
    }

    public void setPushDomain(String pushDomain) {
        this.pushDomain = pushDomain;
    }
    public String getPlayDomain() {
        return playDomain;
    }

    public void setPlayDomain(String playDomain) {
        this.playDomain = playDomain;
    }
    public String getPlayDomainKey() {
        return playDomainKey;
    }

    public void setPlayDomainKey(String playDomainKey) {
        this.playDomainKey = playDomainKey;
    }
    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
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
        return "VideoGroup{" +
        "id=" + id +
        ", name=" + name +
        ", description=" + description +
        ", region=" + region +
        ", groupApp=" + groupApp +
        ", inProtocol=" + inProtocol +
        ", outProtocol=" + outProtocol +
        ", pushDomain=" + pushDomain +
        ", playDomain=" + playDomain +
        ", playDomainKey=" + playDomainKey +
        ", callback=" + callback +
        ", creator=" + creator +
        ", createTime=" + createTime +
        ", updator=" + updator +
        ", updateTime=" + updateTime +
        "}";
    }
}
