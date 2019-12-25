package com.qding.eyecloud.controller.auth.v1_0_0;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.qding.eyecloud.common.data.base.RestResponse;
import com.qding.eyecloud.common.data.request.crm.WorkOrderCallbackRequest;
import com.qding.eyecloud.common.data.request.video.VideoCallbackRequest;

@RestController
public class CallbackController {
    
    private static final Logger logger = LoggerFactory.getLogger(CallbackController.class);
    
    //
    // @Autowired
    // private RpcFacade rpcFacade;
    //
    /**
     * 阿里云视频监控平台回调接口
     */
    @RequestMapping(value = "/video/callback")
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
        // String flag = rpcFacade.iAliVideoFacade.deviceHeartBeat(videoCallbackRequest);
        // if (!Constants.COMMON_SUCCESS.equals(flag)) {
        // // 写入mq不成功返回非200错误码，阿里云那边会再次推送
        // httpServletResponse.setStatus(500);
        // }
        return response;
    }
    
    /**
     * CRM工单系统回调接口
     */
    @RequestMapping(value = "/crm/callback", consumes = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<String> crmCallback(HttpServletRequest request, HttpServletResponse httpServletResponse,
        @RequestBody(required = false) WorkOrderCallbackRequest workOrderCallbackRequest) {
        RestResponse<String> response = new RestResponse<>();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("orderId", workOrderCallbackRequest.getOrderId());
        jsonObj.put("orderStatus", workOrderCallbackRequest.getOrderStatus());
        jsonObj.put("orderFinishTime", workOrderCallbackRequest.getOrderFinishTime());
        return response;
    }
    
    /**
     * 截图回调
     */
    @RequestMapping(value = "/screenshot/callback")
    @ResponseBody
    public RestResponse<String> screenshotCallback(HttpServletRequest request,
        HttpServletResponse httpServletResponse) {
        RestResponse<String> response = new RestResponse<String>();
        response.setData(null);
        response.setMsg("success");
        return response;
    }
}
