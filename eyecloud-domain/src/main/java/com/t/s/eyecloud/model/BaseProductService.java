package com.t.s.eyecloud.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.t.s.eyecloud.base.BaseModel;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * RBA-物模型-服务定义表
 * </p>
 *
 * @author CodeGenerator
 * @since 2020-07-08
 */
@TableName("qdh_base_product_service")
@ApiModel(value="BaseProductService对象", description="RBA-物模型-服务定义表")
public class BaseProductService extends BaseModel {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "服务id")
    private String serviceId;

    @ApiModelProperty(value = "产品id")
    private String productId;

    @ApiModelProperty(value = "服务名称")
    private String serviceName;

    @ApiModelProperty(value = "服务code")
    private String serviceCode;

    @ApiModelProperty(value = "服务代号")
    private String identifier;
    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "BaseProductService{" +
        "id=" + id +
        ", serviceId=" + serviceId +
        ", productId=" + productId +
        ", serviceName=" + serviceName +
        ", serviceCode=" + serviceCode +
        ", identifier=" + identifier +
        ", creator=" + creator +
        ", createTime=" + createTime +
        ", updator=" + updator +
        ", updateTime=" + updateTime +
        "}";
    }
}
