package com.t.s.eyecloud.common.data.response.auth;

import java.io.Serializable;
import java.util.List;

import com.t.s.eyecloud.base.BaseTreeModel;

import io.swagger.annotations.ApiModelProperty;

/**
 * Desc:权限菜单实体
 * Info:<功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * Date:2019年12月2日 下午2:11:54
 */
public class AuthMenuVO extends BaseTreeModel implements Serializable {
    
    private static final long serialVersionUID = -4767613275662588141L;
    
    @ApiModelProperty(value = "菜单名称")
    private String menuName;
    
    @ApiModelProperty(value = "菜单code")
    private String menuCode;
    
    @ApiModelProperty(value = "菜单url")
    private String menuUrl;
    
    @ApiModelProperty(value = "菜单图标")
    private String menuIcon;
    
    @ApiModelProperty(value = "菜单图标")
    List<AuthOperateVO> operates;
    
    public List<AuthOperateVO> getOperates() {
        return operates;
    }
    
    public void setOperates(List<AuthOperateVO> operates) {
        this.operates = operates;
    }
    
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
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AuthMenuVO [menuName=")
            .append(menuName)
            .append(", menuCode=")
            .append(menuCode)
            .append(", menuUrl=")
            .append(menuUrl)
            .append(", menuIcon=")
            .append(menuIcon)
            .append(", operates=")
            .append(operates)
            .append(", toString()=")
            .append(super.toString())
            .append("]");
        return builder.toString();
    }
    
}
