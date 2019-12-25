package com.qding.eyecloud.common.data.base;

import java.io.Serializable;
import java.util.Set;

import io.swagger.annotations.ApiModelProperty;

/**
 * Desc: 通用请求结构
 * Info: <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年11月28日
 */
public class BaseRequest implements Serializable {
    
    private static final long serialVersionUID = 4797596361746288820L;
    
    @ApiModelProperty(value = "通用租户id")
    private String tenantId;
    
    @ApiModelProperty(value = "通用项目id")
    private String projectId;
    
    @ApiModelProperty(value = "通用用户id")
    private String userId;
    
    @ApiModelProperty(value = "通用业务id")
    private String id;
    
    @ApiModelProperty(value = "通用业务id集合")
    private Set<String> ids;
    
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
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public Set<String> getIds() {
        return ids;
    }
    
    public void setIds(Set<String> ids) {
        this.ids = ids;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BaseRequest [tenantId=")
            .append(tenantId)
            .append(", projectId=")
            .append(projectId)
            .append(", userId=")
            .append(userId)
            .append(", id=")
            .append(id)
            .append(", ids=")
            .append(ids)
            .append("]");
        return builder.toString();
    }
}
