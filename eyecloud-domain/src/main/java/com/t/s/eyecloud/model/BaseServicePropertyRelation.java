package com.t.s.eyecloud.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.t.s.eyecloud.base.BaseModel;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * RBA-物模型-服务属性关联表
 * </p>
 *
 * @author CodeGenerator
 * @since 2020-07-08
 */
@TableName("qdh_base_service_property_relation")
@ApiModel(value="BaseServicePropertyRelation对象", description="RBA-物模型-服务属性关联表")
public class BaseServicePropertyRelation extends BaseModel {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "服务id")
    private String serviceId;

    @ApiModelProperty(value = "产品id")
    private String productId;

    @ApiModelProperty(value = "属性id")
    private String propertyId;
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
    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    @Override
    public String toString() {
        return "BaseServicePropertyRelation{" +
        "id=" + id +
        ", serviceId=" + serviceId +
        ", productId=" + productId +
        ", propertyId=" + propertyId +
        ", creator=" + creator +
        ", createTime=" + createTime +
        ", updator=" + updator +
        ", updateTime=" + updateTime +
        "}";
    }
}
