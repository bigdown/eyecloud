package com.t.s.eyecloud.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.t.s.eyecloud.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * <p>
 * qdh_用户表
 * </p>
 *
 * @author CodeGenerator
 * @since 2020-03-06
 */
@TableName("qdh_auth_user")
@ApiModel(value="AuthUser对象", description="qdh_用户表")
public class AuthUser extends BaseModel {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "租户id")
    private String tenantId;

    @ApiModelProperty(value = "用户账号")
    private String account;

    @ApiModelProperty(value = "用户头像")
    private String avatar;

    @ApiModelProperty(value = "用户位置")
    private String address;

    @ApiModelProperty(value = "用户岗位")
    private String position;

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

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
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
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("tenantId", tenantId)
                .append("account", account)
                .append("avatar", avatar)
                .append("address", address)
                .append("position", position)
                .append("mobile", mobile)
                .append("email", email)
                .append("password", password)
                .append("salt", salt)
                .append("realName", realName)
                .append("nickName", nickName)
                .append("accountType", accountType)
                .append("id", id)
                .append("version", version)
                .append("creator", creator)
                .append("createTime", createTime)
                .append("updator", updator)
                .append("updateTime", updateTime)
                .toString();
    }
}
