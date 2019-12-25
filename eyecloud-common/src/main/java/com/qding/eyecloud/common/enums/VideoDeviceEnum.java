package com.qding.eyecloud.common.enums;

/**
 * Desc:设备同步状态
 * Info:<功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * Date:2019年11月29日 上午10:18:16
 */
public enum VideoDeviceEnum {
    
    /**
     * 待同步
     */
    WAIT_SYNC("wait_sync", "待同步"),
    /**
     * 同步中
     */
    SYNCING("syncing", "同步中"),
    /**
     * 同步完成
     */
    SYNCED("synced", "同步完成"),
    /**
     * 设备在线
     */
    ON("on", "设备在线"),
    /**
     * 设备下线
     */
    OFF("off", "设备下线");
    
    private String code;
    
    private String value;
    
    public String getCode() {
        return code;
    }
    
    public String getValue() {
        return value;
    }
    
    private VideoDeviceEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }
    
}
