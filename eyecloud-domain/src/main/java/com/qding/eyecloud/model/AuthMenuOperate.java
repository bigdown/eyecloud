package com.qding.eyecloud.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qding.eyecloud.base.BaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * qdh_操作表
 * </p>
 *
 * @author CodeGenerator
 * @since 2019-11-26
 */
@TableName("qdh_auth_menu_operate")
@ApiModel(value = "AuthMenuOperate对象", description = "qdh_操作表")
public class AuthMenuOperate extends BaseModel implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(value = "菜单id")
    private String menuId;
    
    @ApiModelProperty(value = "操作名称")
    private String operateName;
    
    @ApiModelProperty(value = "操作code")
    private String operateCode;
    
    @ApiModelProperty(value = "操作说明")
    private String operateRemark;
    
    public String getMenuId() {
        return menuId;
    }
    
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
    
    public String getOperateName() {
        return operateName;
    }
    
    public void setOperateName(String operateName) {
        this.operateName = operateName;
    }
    
    public String getOperateCode() {
        return operateCode;
    }
    
    public void setOperateCode(String operateCode) {
        this.operateCode = operateCode;
    }
    
    public String getOperateRemark() {
        return operateRemark;
    }
    
    public void setOperateRemark(String operateRemark) {
        this.operateRemark = operateRemark;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AuthMenuOperate [menuId=")
            .append(menuId)
            .append(", operateName=")
            .append(operateName)
            .append(", operateCode=")
            .append(operateCode)
            .append(", operateRemark=")
            .append(operateRemark)
            .append(", toString()=")
            .append(super.toString())
            .append("]");
        return builder.toString();
    }
}
