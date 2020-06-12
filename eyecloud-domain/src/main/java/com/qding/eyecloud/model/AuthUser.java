package com.qding.eyecloud.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.qding.eyecloud.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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

    @ApiModelProperty(value = "主键id")
    private String id;

    @ApiModelProperty(value = "租户id")
    private String tenantId;

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

    @ApiModelProperty(value = "版本号字段，用于乐观锁")
    private Integer version;

    @ApiModelProperty(value = "创建人")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改人")
    private String updator;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
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
    @Override
    public Integer getVersion() {
        return version;
    }

    @Override
    public void setVersion(Integer version) {
        this.version = version;
    }
    @Override
    public String getCreator() {
        return creator;
    }

    @Override
    public void setCreator(String creator) {
        this.creator = creator;
    }
    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @Override
    public String getUpdator() {
        return updator;
    }

    @Override
    public void setUpdator(String updator) {
        this.updator = updator;
    }
    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "AuthUser{" +
        "id=" + id +
        ", tenantId=" + tenantId +
        ", account=" + account +
        ", mobile=" + mobile +
        ", email=" + email +
        ", password=" + password +
        ", salt=" + salt +
        ", realName=" + realName +
        ", nickName=" + nickName +
        ", accountType=" + accountType +
        ", version=" + version +
        ", creator=" + creator +
        ", createTime=" + createTime +
        ", updator=" + updator +
        ", updateTime=" + updateTime +
        "}";
    }
}
