package com.qding.eyecloud.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qding.eyecloud.base.BaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * qdh_项目表
 * </p>
 *
 * @author CodeGenerator
 * @since 2019-11-20
 */
@TableName("qdh_auth_project")
@ApiModel(value = "AuthProject对象", description = "qdh_项目表")
public class AuthProject extends BaseModel implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(value = "租户id")
    private String tenantId;
    
    @ApiModelProperty(value = "项目名称")
    private String projectName;
    
    @ApiModelProperty(value = "所在省")
    private String provinceCode;
    
    @ApiModelProperty(value = "省名称")
    private String provinceName;
    
    @ApiModelProperty(value = "所在市")
    private String cityCode;
    
    @ApiModelProperty(value = "市名称")
    private String cityName;
    
    @ApiModelProperty(value = "所在街道")
    private String streetCode;
    
    @ApiModelProperty(value = "街道名称")
    private String streetName;
    
    @ApiModelProperty(value = "项目详细地址")
    private String address;
    
    public String getTenantId() {
        return tenantId;
    }
    
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
    
    public String getProjectName() {
        return projectName;
    }
    
    public void setProjectName(String projectName) {
        this.projectName = projectName;
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
    
    public String getStreetCode() {
        return streetCode;
    }
    
    public void setStreetCode(String streetCode) {
        this.streetCode = streetCode;
    }
    
    public String getStreetName() {
        return streetName;
    }
    
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AuthProject [tenantId=")
            .append(tenantId)
            .append(", projectName=")
            .append(projectName)
            .append(", provinceCode=")
            .append(provinceCode)
            .append(", provinceName=")
            .append(provinceName)
            .append(", cityCode=")
            .append(cityCode)
            .append(", cityName=")
            .append(cityName)
            .append(", streetCode=")
            .append(streetCode)
            .append(", streetName=")
            .append(streetName)
            .append(", address=")
            .append(address)
            .append(", toString()=")
            .append(super.toString())
            .append("]");
        return builder.toString();
    }
}
