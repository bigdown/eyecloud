package com.t.s.eyecloud.common.data.response.auth;

import java.io.Serializable;
import java.util.List;

import com.t.s.eyecloud.base.BaseTreeModel;
import com.t.s.eyecloud.common.data.base.TreeVO;
import com.t.s.eyecloud.model.AuthUser;

import io.swagger.annotations.ApiModelProperty;

/**
 * Desc: 用户通用数据封装结构体
 * Info: <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年11月28日
 */
public class UserDataVO implements Serializable {
    
    private static final long serialVersionUID = -7907314967541174734L;
    
    @ApiModelProperty(value = "用户基本信息")
    private AuthUser base;
    
    @ApiModelProperty(value = "用户权限集合")
    List<TreeVO<? extends BaseTreeModel>> permissions;
    
    public AuthUser getBase() {
        return base;
    }
    
    public void setBase(AuthUser base) {
        this.base = base;
    }
    
    public List<TreeVO<? extends BaseTreeModel>> getPermissions() {
        return permissions;
    }
    
    public void setPermissions(List<TreeVO<? extends BaseTreeModel>> list) {
        this.permissions = list;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserPermissionsVO [base=")
            .append(base)
            .append(", permissions=")
            .append(permissions)
            .append("]");
        return builder.toString();
    }
    
}
