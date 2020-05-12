package com.qding.eyecloud.common.data.response.auth;

import com.qding.eyecloud.model.AuthUser;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * description: <简述>
 * info: <详细信息>
 *
 * @author: tanshen@qding.me
 * @Date:
 * @since [产品/模块版本]
 */
public class AuthUserVO implements Serializable {

    @ApiModelProperty(value = "用户基本信息")
    private AuthUser base;

    @ApiModelProperty(value = "token")
    private String token;

    public AuthUser getBase() {
        return base;
    }

    public void setBase(AuthUser base) {
        this.base = base;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
