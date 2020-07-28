package com.t.s.eyecloud.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.t.s.eyecloud.base.BaseModel;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * RBA-物模型-产品定义表
 * </p>
 *
 * @author CodeGenerator
 * @since 2020-07-08
 */
@TableName("qdh_base_product")
@ApiModel(value="BaseProduct对象", description="RBA-物模型-产品定义表")
public class BaseProduct extends BaseModel {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "产品id")
    private String productId;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "产品代号")
    private String identifier;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "BaseProduct{" +
        "id=" + id +
        ", productId=" + productId +
        ", productName=" + productName +
        ", identifier=" + identifier +
        ", creator=" + creator +
        ", createTime=" + createTime +
        ", updator=" + updator +
        ", updateTime=" + updateTime +
        "}";
    }
}
