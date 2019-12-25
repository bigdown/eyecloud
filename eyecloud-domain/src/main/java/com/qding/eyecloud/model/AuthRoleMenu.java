package com.qding.eyecloud.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qding.eyecloud.base.BaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * qdh_角色菜单表
 * </p>
 *
 * @author CodeGenerator
 * @since 2019-11-26
 */
@TableName("qdh_auth_role_menu")
@ApiModel(value = "AuthRoleMenu对象", description = "qdh_角色菜单表")
public class AuthRoleMenu extends BaseModel implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(value = "角色id")
    private String roleId;
    
    @ApiModelProperty(value = "菜单id")
    private String menuId;
    
    public String getRoleId() {
        return roleId;
    }
    
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    
    public String getMenuId() {
        return menuId;
    }
    
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
