package com.t.s.eyecloud.common.data.response.auth;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * Desc:权限操作实体
 * Info:<功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * Date:2019年12月2日 下午2:11:31
 */
public class AuthOperateVO implements Serializable {
    
    private static final long serialVersionUID = -2943358653375600875L;
    
    @ApiModelProperty(value = "操作名称")
    private String operateName;
    
    @ApiModelProperty(value = "操作code")
    private String operateCode;
    
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
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AuthOperateVO [operateName=")
            .append(operateName)
            .append(", operateCode=")
            .append(operateCode)
            .append("]");
        return builder.toString();
    }
    
}
