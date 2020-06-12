package com.qding.eyecloud.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.qding.eyecloud.base.BaseModel;
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
public class AuthTenantInfo extends BaseModel {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    private String id;

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

    @ApiModelProperty(value = "父节点id（-1为顶层）")
    private String parentId;

    @ApiModelProperty(value = "是否可用(0 不可用 1 可用)")
    private String status;

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
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
