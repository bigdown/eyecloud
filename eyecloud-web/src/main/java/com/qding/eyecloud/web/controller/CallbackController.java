package com.qding.eyecloud.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.qding.eyecloud.common.constants.EyecloudConstants;
import com.qding.eyecloud.common.data.base.RestResponse;
import com.qding.eyecloud.common.data.request.crm.WorkOrderCallbackRequest;
import com.qding.eyecloud.common.data.request.video.VideoCallbackRequest;
import com.qding.eyecloud.web.facade.RpcFacade;

@RestController
public class CallbackController {
    
    private static final Logger logger = LoggerFactory.getLogger(CallbackController.class);
    
    @Autowired
    private RpcFacade rpcFacade;
    
    /**
     * 阿里云视频监控平台回调接口
     */
    @RequestMapping(value = "/video/callback", consumes = "application/json")
    @ResponseBody
    public RestResponse<String> videoCallback(@RequestBody VideoCallbackRequest videoCallbackRequest,
        HttpServletResponse httpServletResponse) {
        RestResponse<String> response = new RestResponse<String>();
        response.setData(null);
        response.setMsg("success");
        logger.info(videoCallbackRequest.toString());
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("event", videoCallbackRequest.getEvent());
        jsonObj.put("deviceId", videoCallbackRequest.getDeviceId());
        jsonObj.put("deviceStatus", videoCallbackRequest.getDeviceStatus());
        jsonObj.put("gbId", videoCallbackRequest.getgBid());
        jsonObj.put("groupId", videoCallbackRequest.getGroupId());
        jsonObj.put("streamId", videoCallbackRequest.getStreamId());
        jsonObj.put("streamStatus", videoCallbackRequest.getStreamStatus());
        jsonObj.put("time", videoCallbackRequest.getTime());
        String flag = rpcFacade.iAliVideoFacade.deviceHeartBeat(videoCallbackRequest);
        if (!EyecloudConstants.COMMON_SUCCESS.equals(flag)) {
            // 写入mq不成功返回非200错误码，阿里云那边会再次推送
            httpServletResponse.setStatus(500);
        }
        return response;
    }
    
    /**
     * CRM工单系统回调接口
     */
    @RequestMapping(value = "/crm/callback", consumes = "application/json")
    @ResponseBody
    public RestResponse<String> crmCallback(HttpServletRequest request, HttpServletResponse httpServletResponse,
        @RequestBody(required = false) WorkOrderCallbackRequest workOrderCallbackRequest) {
        RestResponse<String> response = new RestResponse<String>();
        response.setData(null);
        response.setMsg("success");
        logger.info("crm工单回调success,<{}>", workOrderCallbackRequest);
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("orderId", workOrderCallbackRequest.getOrderId());
        jsonObj.put("orderStatus", workOrderCallbackRequest.getOrderStatus());
        jsonObj.put("orderFinishTime", workOrderCallbackRequest.getOrderFinishTime());
        boolean flag = true;// iCrmCallbackFacade.push(jsonObj);
        if (!flag) {
            // crm没有做推送失败处理，不会进行二次推送，这里打印一下错误日志，以便后续进行错误处理
            logger.error("do crm callback error, request data:{}", workOrderCallbackRequest);
            httpServletResponse.setStatus(500);
        }
        return response;
    }
    
    /**
     * 截图回调
     */
    @RequestMapping(value = "/screenshot/callback", consumes = "application/json")
    @ResponseBody
    public RestResponse<String> screenshotCallback(HttpServletRequest request,
        HttpServletResponse httpServletResponse) {
        RestResponse<String> response = new RestResponse<String>();
        response.setData(null);
        response.setMsg("success");
        return response;
    }
}
