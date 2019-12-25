package com.qding.eyecloud.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qding.eyecloud.base.BaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * qdh_角色表
 * </p>
 *
 * @author CodeGenerator
 * @since 2019-11-26
 */
@TableName("qdh_auth_role")
@ApiModel(value = "AuthRole对象", description = "qdh_角色表")
public class AuthRole extends BaseModel implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(value = "租户id")
    private String tenantId;
    
    @ApiModelProperty(value = "项目id")
    private String projectId;
    
    @ApiModelProperty(value = "角色名称")
    private String roleName;
    
    @ApiModelProperty(value = "角色code")
    private String roleCode;
    
    @ApiModelProperty(value = "平台类型，用来进行多个平台间的权限转换")
    private String platCode;
    
    @ApiModelProperty(value = "排序字段，值越大越靠前")
    private Integer roleSort;
    
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
    
    public String getRoleName() {
        return roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    public String getRoleCode() {
        return roleCode;
    }
    
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
    
    public Integer getRoleSort() {
        return roleSort;
    }
    
    public void setRoleSort(Integer roleSort) {
        this.roleSort = roleSort;
    }
    
    public String getPlatCode() {
        return platCode;
    }
    
    public void setPlatCode(String platCode) {
        this.platCode = platCode;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AuthRole [tenantId=")
            .append(tenantId)
            .append(", projectId=")
            .append(projectId)
            .append(", roleName=")
            .append(roleName)
            .append(", roleCode=")
            .append(roleCode)
            .append(", platCode=")
            .append(platCode)
            .append(", roleSort=")
            .append(roleSort)
            .append(", toString()=")
            .append(super.toString())
            .append("]");
        return builder.toString();
    }
}
