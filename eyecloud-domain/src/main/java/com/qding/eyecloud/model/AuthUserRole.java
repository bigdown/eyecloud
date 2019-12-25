package com.qding.eyecloud.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qding.eyecloud.base.BaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * qdh_用户角色表
 * </p>
 *
 * @author CodeGenerator
 * @since 2019-11-26
 */
@TableName("qdh_auth_user_role")
@ApiModel(value = "AuthUserRole对象", description = "qdh_用户角色表")
public class AuthUserRole extends BaseModel implements Serializable {
    
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
        StringBuilder builder = new StringBuilder();
        builder.append("AuthUserRole [tenantId=")
            .append(tenantId)
            .append(", projectId=")
            .append(projectId)
            .append(", userId=")
            .append(userId)
            .append(", roleId=")
            .append(roleId)
            .append(", toString()=")
            .append(super.toString())
            .append("]");
        return builder.toString();
    }
}
