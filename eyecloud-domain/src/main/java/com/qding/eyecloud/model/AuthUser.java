package com.qding.eyecloud.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qding.eyecloud.base.BaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * qdh_用户表
 * </p>
 *
 * @author CodeGenerator
 * @since 2019-11-20
 */
@TableName("qdh_auth_user")
@ApiModel(value = "AuthUser对象", description = "qdh_用户表")
public class AuthUser extends BaseModel implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(value = "用户账号")
    private String account;
    
    @ApiModelProperty(value = "手机号")
    private String mobile;
    
    @ApiModelProperty(value = "邮箱")
    private String email;
    
    @ApiModelProperty(value = "密码")
    private String password;
    
    @ApiModelProperty(value = "密码盐值")
    private String salt;
    
    @ApiModelProperty(value = "真实姓名")
    private String realName;
    
    @ApiModelProperty(value = "用户昵称")
    private String nickName;
    
    @ApiModelProperty(value = "账号类型：0普通账号，1超级管理员，2租户管理员，3项目管理员")
    private String accountType;
    
    @ApiModelProperty(value = "租户id")
    private String tenantId;
    
    @ApiModelProperty(value = "项目id")
    private String projectId;
    
    @TableField(exist = false)
    @ApiModelProperty(value = "token")
    private String token;
    
    public String getAccount() {
        return account;
    }
    
    public void setAccount(String account) {
        this.account = account;
    }
    
    public String getMobile() {
        return mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getSalt() {
        return salt;
    }
    
    public void setSalt(String salt) {
        this.salt = salt;
    }
    
    public String getRealName() {
        return realName;
    }
    
    public void setRealName(String realName) {
        this.realName = realName;
    }
    
    public String getNickName() {
        return nickName;
    }
    
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    
    public String getAccountType() {
        return accountType;
    }
    
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    
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
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AuthUser [account=")
            .append(account)
            .append(", mobile=")
            .append(mobile)
            .append(", email=")
            .append(email)
            .append(", password=")
            .append(password)
            .append(", salt=")
            .append(salt)
            .append(", realName=")
            .append(realName)
            .append(", nickName=")
            .append(nickName)
            .append(", accountType=")
            .append(accountType)
            .append(", tenantId=")
            .append(tenantId)
            .append(", projectId=")
            .append(projectId)
            .append(", token=")
            .append(token)
            .append(", toString()=")
            .append(super.toString())
            .append("]");
        return builder.toString();
    }
}
