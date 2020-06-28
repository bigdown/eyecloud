package com.t.s.eyecloud.base;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class BaseModel implements Serializable {
    
    private static final long serialVersionUID = 4273025517736737059L;

    @ApiModelProperty(value = "主键id")
    protected String id;
    
    @ApiModelProperty(value = "版本号字段，用于乐观锁")
    protected Integer version;
    
    @ApiModelProperty(value = "创建人")
    protected String creator;
    
    @ApiModelProperty(value = "创建时间")
    protected Date createTime;
    
    @ApiModelProperty(value = "修改人")
    protected String updator;
    
    @ApiModelProperty(value = "修改时间")
    protected Date updateTime;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public Integer getVersion() {
        return version;
    }
    
    public void setVersion(Integer version) {
        this.version = version;
    }
    
    public String getCreator() {
        return creator;
    }
    
    public void setCreator(String creator) {
        this.creator = creator;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public String getUpdator() {
        return updator;
    }
    
    public void setUpdator(String updator) {
        this.updator = updator;
    }
    
    public Date getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BaseModel [id=")
            .append(id)
            .append(", version=")
            .append(version)
            .append(", creator=")
            .append(creator)
            .append(", createTime=")
            .append(createTime)
            .append(", updator=")
            .append(updator)
            .append(", updateTime=")
            .append(updateTime)
            .append("]");
        return builder.toString();
    }
    
}
