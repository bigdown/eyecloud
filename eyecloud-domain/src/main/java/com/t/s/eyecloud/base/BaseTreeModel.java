package com.t.s.eyecloud.base;

import io.swagger.annotations.ApiModelProperty;

public class BaseTreeModel extends BaseModel {
    
    private static final long serialVersionUID = -8156900538888203031L;
    
    @ApiModelProperty(value = "父级id，顶层为-1")
    protected String parentId;
    
    public String getParentId() {
        return parentId;
    }
    
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    
}
