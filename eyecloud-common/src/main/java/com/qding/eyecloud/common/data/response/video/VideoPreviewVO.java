package com.qding.eyecloud.common.data.response.video;

import com.qding.eyecloud.common.data.base.BaseRequest;

/**
 * Desc:设备预览请求类
 * Info:<功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * Date:2019年12月4日 下午3:42:51
 */
public class VideoPreviewVO extends BaseRequest {
    
    private static final long serialVersionUID = 8581942666992002658L;
    
    /**
     * outProtocol：流播放协议
     */
    private String outProtocol;
    
    private String authKey;
    
    /**
     * out time 
     */
    private Long expire;
    
    /**
     * type：流类型。live直播、vod点播
     */
    private String type;
    
    private Long startTime;
    
    private Long endTime;
    
    private String transcode;
    
    public String getOutProtocol() {
        return outProtocol;
    }
    
    public void setOutProtocol(String outProtocol) {
        this.outProtocol = outProtocol;
    }
    
    public Long getExpire() {
        return expire;
    }
    
    public void setExpire(Long expire) {
        this.expire = expire;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public Long getStartTime() {
        return startTime;
    }
    
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }
    
    public Long getEndTime() {
        return endTime;
    }
    
    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }
    
    public String getTranscode() {
        return transcode;
    }
    
    public void setTranscode(String transcode) {
        this.transcode = transcode;
    }
    
    public String getAuthKey() {
        return authKey;
    }
    
    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VideoPreviewVO [outProtocol=")
            .append(outProtocol)
            .append(", authKey=")
            .append(authKey)
            .append(", expire=")
            .append(expire)
            .append(", type=")
            .append(type)
            .append(", startTime=")
            .append(startTime)
            .append(", endTime=")
            .append(endTime)
            .append(", transcode=")
            .append(transcode)
            .append("]");
        return builder.toString();
    }
    
}
