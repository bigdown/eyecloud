package com.qding.eyecloud.common.exception;

import com.qding.eyecloud.common.constants.EyecloudConstants;

/**
 * Desc: 检查并抛出异常封装工具类
 * Info: <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年11月28日
 */
public class A {
    
    public static void checkParams(boolean result) {
        if (result) {
            throw new ParamsException("入参为空");
        }
    }
    
    public static void checkParams(boolean result, String msg) {
        if (result) {
            throw new ParamsException(msg);
        }
    }
    
    public static void checkBusiness(boolean result, String code, String msg) {
        if (result) {
            throw new BusinessException(code, msg);
        }
    }
    
    public static void checkBusiness(boolean result, String msg) {
        if (result) {
            throw new BusinessException(EyecloudConstants.COMMON_FAIL, msg);
        }
    }
}
