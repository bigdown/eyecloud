package com.qding.eyecloud.common.data.request.crm;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * CRM工单系统回调接口数据实体
 * <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年10月23日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkOrderCallbackRequest implements Serializable {
    
    private static final long serialVersionUID = 969024071021436391L;
    
    /**
     * 工单ID
     */
    @JsonProperty("orderId")
    private String orderId;
    
    /**
     * 工单编码
     */
    @JsonProperty("orderCode")
    private String orderCode;
    
    /**
     * 工单状态枚举
     */
    @JsonProperty("orderStatus")
    private Integer orderStatus;
    
    /**
     * 原因大类
     */
    @JsonProperty("orderTypeId")
    private String orderTypeId;
    
    /**
     * 原因细类
     */
    @JsonProperty("orderTypeDetailId")
    private String orderTypeDetailId;
    
    /**
     * 报事来源
     */
    @JsonProperty("sourceTypeName")
    private String sourceTypeName;
    
    /**
     * 数据来源枚举
     */
    @JsonProperty("sourceSystem")
    private Integer sourceSystem;
    
    /**
     * 创建人人名
     */
    @JsonProperty("createUserName")
    private String createUserName;
    
    /**
     * 分派人
     */
    @JsonProperty("assignUserName")
    private String assignUserName;
    
    /**
     * 责任人
     */
    @JsonProperty("endUserName")
    private String endUserName;
    
    /**
     * 责任人id
     */
    @JsonProperty("endUserId")
    private String endUserId;
    
    /**
     * 报事房间房屋编码
     */
    @JsonProperty("ownerRoomSign")
    private String ownerRoomSign;
    
    /**
     * 报事对象房间
     */
    @JsonProperty("informRoomSign")
    private String informRoomSign;
    
    /**
     * 报事人
     */
    @JsonProperty("informUserName")
    private String informUserName;
    
    /**
     * 报事人手机
     */
    @JsonProperty("informUserMobile")
    private String informUserMobile;
    
    /**
     * 报事人电话
     */
    @JsonProperty("informPhone")
    private String informPhone;
    
    /**
     * 工单描述
     */
    @JsonProperty("orderMemo")
    private String orderMemo;
    
    /**
     * 工单创建时间
     */
    @JsonProperty("orderCreateTime")
    private String orderCreateTime;
    
    /**
     * 工单完成时间
     */
    @JsonProperty("orderFinishTime")
    private String orderFinishTime;
    
    /**
     * 回复或者催办描述
     */
    @JsonProperty("reviewMemo")
    private String reviewMemo;
    
    /**
     * 回复类型
     */
    @JsonProperty("reviewType")
    private Integer reviewType;
    
    public String getOrderId() {
        return orderId;
    }
    
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getOrderCode() {
        return orderCode;
    }
    
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
    
    public Integer getOrderStatus() {
        return orderStatus;
    }
    
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    public String getOrderTypeId() {
        return orderTypeId;
    }
    
    public void setOrderTypeId(String orderTypeId) {
        this.orderTypeId = orderTypeId;
    }
    
    public String getOrderTypeDetailId() {
        return orderTypeDetailId;
    }
    
    public void setOrderTypeDetailId(String orderTypeDetailId) {
        this.orderTypeDetailId = orderTypeDetailId;
    }
    
    public String getSourceTypeName() {
        return sourceTypeName;
    }
    
    public void setSourceTypeName(String sourceTypeName) {
        this.sourceTypeName = sourceTypeName;
    }
    
    public Integer getSourceSystem() {
        return sourceSystem;
    }
    
    public void setSourceSystem(Integer sourceSystem) {
        this.sourceSystem = sourceSystem;
    }
    
    public String getCreateUserName() {
        return createUserName;
    }
    
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }
    
    public String getAssignUserName() {
        return assignUserName;
    }
    
    public void setAssignUserName(String assignUserName) {
        this.assignUserName = assignUserName;
    }
    
    public String getEndUserName() {
        return endUserName;
    }
    
    public void setEndUserName(String endUserName) {
        this.endUserName = endUserName;
    }
    
    public String getEndUserId() {
        return endUserId;
    }
    
    public void setEndUserId(String endUserId) {
        this.endUserId = endUserId;
    }
    
    public String getOwnerRoomSign() {
        return ownerRoomSign;
    }
    
    public void setOwnerRoomSign(String ownerRoomSign) {
        this.ownerRoomSign = ownerRoomSign;
    }
    
    public String getInformRoomSign() {
        return informRoomSign;
    }
    
    public void setInformRoomSign(String informRoomSign) {
        this.informRoomSign = informRoomSign;
    }
    
    public String getInformUserName() {
        return informUserName;
    }
    
    public void setInformUserName(String informUserName) {
        this.informUserName = informUserName;
    }
    
    public String getInformUserMobile() {
        return informUserMobile;
    }
    
    public void setInformUserMobile(String informUserMobile) {
        this.informUserMobile = informUserMobile;
    }
    
    public String getInformPhone() {
        return informPhone;
    }
    
    public void setInformPhone(String informPhone) {
        this.informPhone = informPhone;
    }
    
    public String getOrderMemo() {
        return orderMemo;
    }
    
    public void setOrderMemo(String orderMemo) {
        this.orderMemo = orderMemo;
    }
    
    public String getOrderCreateTime() {
        return orderCreateTime;
    }
    
    public void setOrderCreateTime(String orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }
    
    public String getOrderFinishTime() {
        return orderFinishTime;
    }
    
    public void setOrderFinishTime(String orderFinishTime) {
        this.orderFinishTime = orderFinishTime;
    }
    
    public String getReviewMemo() {
        return reviewMemo;
    }
    
    public void setReviewMemo(String reviewMemo) {
        this.reviewMemo = reviewMemo;
    }
    
    public Integer getReviewType() {
        return reviewType;
    }
    
    public void setReviewType(Integer reviewType) {
        this.reviewType = reviewType;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("WorkOrderCallbackRequest [orderId=")
            .append(orderId)
            .append(", orderCode=")
            .append(orderCode)
            .append(", orderStatus=")
            .append(orderStatus)
            .append(", orderTypeId=")
            .append(orderTypeId)
            .append(", orderTypeDetailId=")
            .append(orderTypeDetailId)
            .append(", sourceTypeName=")
            .append(sourceTypeName)
            .append(", sourceSystem=")
            .append(sourceSystem)
            .append(", createUserName=")
            .append(createUserName)
            .append(", assignUserName=")
            .append(assignUserName)
            .append(", endUserName=")
            .append(endUserName)
            .append(", endUserId=")
            .append(endUserId)
            .append(", ownerRoomSign=")
            .append(ownerRoomSign)
            .append(", informRoomSign=")
            .append(informRoomSign)
            .append(", informUserName=")
            .append(informUserName)
            .append(", informUserMobile=")
            .append(informUserMobile)
            .append(", informPhone=")
            .append(informPhone)
            .append(", orderMemo=")
            .append(orderMemo)
            .append(", orderCreateTime=")
            .append(orderCreateTime)
            .append(", orderFinishTime=")
            .append(orderFinishTime)
            .append(", reviewMemo=")
            .append(reviewMemo)
            .append(", reviewType=")
            .append(reviewType)
            .append("]");
        return builder.toString();
    }
    
}
