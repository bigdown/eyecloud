package com.t.s.eyecloud.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.t.s.eyecloud.base.BaseModel;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * RBA-物模型-产品属性表
 * </p>
 *
 * @author CodeGenerator
 * @since 2020-07-08
 */
@TableName("qdh_base_product_property")
@ApiModel(value="BaseProductProperty对象", description="RBA-物模型-产品属性表")
public class BaseProductProperty extends BaseModel {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "产品id")
    private String productId;

    @ApiModelProperty(value = "属性id")
    private String propertyId;

    @ApiModelProperty(value = "属性代号")
    private String identifier;

    @ApiModelProperty(value = "属性名称")
    private String propertyName;

    @ApiModelProperty(value = "属性字段类型")
    private String dataType;

    @ApiModelProperty(value = "属性内容")
    private String dataSchema;

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
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    public String getDataSchema() {
        return dataSchema;
    }

    public void setDataSchema(String dataSchema) {
        this.dataSchema = dataSchema;
    }

    @Override
    public String toString() {
        return "BaseProductProperty{" +
        "id=" + id +
        ", productId=" + productId +
        ", propertyId=" + propertyId +
        ", identifier=" + identifier +
        ", propertyName=" + propertyName +
        ", dataType=" + dataType +
        ", dataSchema=" + dataSchema +
        ", creator=" + creator +
        ", createTime=" + createTime +
        ", updator=" + updator +
        ", updateTime=" + updateTime +
        "}";
    }
}
