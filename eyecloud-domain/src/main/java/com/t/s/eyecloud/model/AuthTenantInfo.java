package com.t.s.eyecloud.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.t.s.eyecloud.base.BaseTreeModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * qdh_租户表
 * </p>
 *
 * @author CodeGenerator
 * @since 2020-03-06
 */
@TableName("qdh_auth_tenant_info")
@ApiModel(value="AuthTenantInfo对象", description="qdh_租户表")
public class AuthTenantInfo extends BaseTreeModel {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "租户名称")
    private String tenantName;

    @ApiModelProperty(value = "所在省")
    private String provinceCode;

    @ApiModelProperty(value = "省名称")
    private String provinceName;

    @ApiModelProperty(value = "所在市")
    private String cityCode;

    @ApiModelProperty(value = "市名称")
    private String cityName;

    @ApiModelProperty(value = "租户地址")
    private String address;

    @ApiModelProperty(value = "联系人")
    private String linkMan;

    @ApiModelProperty(value = "联系电话")
    private String phone;

    @ApiModelProperty(value = "租户描述")
    private String description;

    @ApiModelProperty(value = "是否可用(0 不可用 1 可用)")
    private String status;

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }
    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AuthTenantInfo{" +
        "id=" + id +
        ", tenantName=" + tenantName +
        ", provinceCode=" + provinceCode +
        ", provinceName=" + provinceName +
        ", cityCode=" + cityCode +
        ", cityName=" + cityName +
        ", address=" + address +
        ", linkMan=" + linkMan +
        ", phone=" + phone +
        ", description=" + description +
        ", parentId=" + parentId +
        ", status=" + status +
        ", version=" + version +
        ", creator=" + creator +
        ", createTime=" + createTime +
        ", updator=" + updator +
        ", updateTime=" + updateTime +
        "}";
    }
}
