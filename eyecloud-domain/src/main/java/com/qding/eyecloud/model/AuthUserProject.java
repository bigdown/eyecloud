package com.qding.eyecloud.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.qding.eyecloud.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * qdh_用户项目表
 * </p>
 *
 * @author CodeGenerator
 * @since 2020-03-06
 */
@TableName("qdh_auth_user_project")
@ApiModel(value="AuthUserProject对象", description="qdh_用户项目表")
public class AuthUserProject extends BaseModel {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    private String id;

    @ApiModelProperty(value = "租户id")
    private String tenantId;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "项目id")
    private String projectId;

    @ApiModelProperty(value = "创建人")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改人")
    private String updator;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
    @Override
    public String getCreator() {
        return creator;
    }

    @Override
    public void setCreator(String creator) {
        this.creator = creator;
    }
    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @Override
    public String getUpdator() {
        return updator;
    }

    @Override
    public void setUpdator(String updator) {
        this.updator = updator;
    }
    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "AuthUserProject{" +
        "id=" + id +
        ", tenantId=" + tenantId +
        ", userId=" + userId +
        ", projectId=" + projectId +
        ", creator=" + creator +
        ", createTime=" + createTime +
        ", updator=" + updator +
        ", updateTime=" + updateTime +
        "}";
    }
}
