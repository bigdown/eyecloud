package com.qding.eyecloud.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qding.eyecloud.base.BaseTreeModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * qdh_菜单表
 * </p>
 *
 * @author CodeGenerator
 * @since 2019-11-26
 */
@TableName("qdh_auth_menu")
@ApiModel(value = "AuthMenu对象", description = "qdh_菜单表")
public class AuthMenu extends BaseTreeModel implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(value = "菜单名称")
    private String menuName;
    
    @ApiModelProperty(value = "菜单code")
    private String menuCode;
    
    @ApiModelProperty(value = "菜单url")
    private String menuUrl;
    
    @ApiModelProperty(value = "菜单图标")
    private String menuIcon;
    
    @ApiModelProperty(value = "排序字段，值越大越靠前")
    private Integer menuSort;
    
    @ApiModelProperty(value = "平台类型，用来进行多个平台见的权限转换")
    private String platCode;
    
    @ApiModelProperty(value = "-1为顶层菜单")
    private String parentId;
    
    public String getMenuName() {
        return menuName;
    }
    
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    
    public String getMenuCode() {
        return menuCode;
    }
    
    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }
    
    public String getMenuUrl() {
        return menuUrl;
    }
    
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
    
    public String getMenuIcon() {
        return menuIcon;
    }
    
    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }
    
    public Integer getMenuSort() {
        return menuSort;
    }
    
    public void setMenuSort(Integer menuSort) {
        this.menuSort = menuSort;
    }
    
    public String getPlatCode() {
        return platCode;
    }
    
    public void setPlatCode(String platCode) {
        this.platCode = platCode;
    }
    
    public String getParentId() {
        return parentId;
    }
    
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AuthMenu [menuName=")
            .append(menuName)
            .append(", menuCode=")
            .append(menuCode)
            .append(", menuUrl=")
            .append(menuUrl)
            .append(", menuIcon=")
            .append(menuIcon)
            .append(", menuSort=")
            .append(menuSort)
            .append(", platCode=")
            .append(platCode)
            .append(", parentId=")
            .append(parentId)
            .append(", toString()=")
            .append(super.toString())
            .append("]");
        return builder.toString();
    }
}
