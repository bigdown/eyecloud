package com.t.s.eyecloud.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.t.s.eyecloud.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * qdh_用户角色表
 * </p>
 *
 * @author CodeGenerator
 * @since 2020-03-06
 */
@TableName("qdh_auth_user_role")
@ApiModel(value="AuthUserRole对象", description="qdh_用户角色表")
public class AuthUserRole extends BaseModel {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "租户id")
    private String tenantId;

    @ApiModelProperty(value = "项目id")
    private String projectId;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "角色id")
    private String roleId;

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
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "AuthUserRole{" +
        "id=" + id +
        ", tenantId=" + tenantId +
        ", projectId=" + projectId +
        ", userId=" + userId +
        ", roleId=" + roleId +
        ", creator=" + creator +
        ", createTime=" + createTime +
        ", updator=" + updator +
        ", updateTime=" + updateTime +
        "}";
    }
}
