package com.qding.eyecloud.web.exception;

import java.util.List;

import javax.ws.rs.BadRequestException;

import org.apache.http.HttpStatus;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.qding.eyecloud.common.data.base.RestResponse;
import com.qding.eyecloud.common.exception.BusinessException;
import com.qding.eyecloud.common.exception.CommonException;
import com.qding.eyecloud.common.exception.ParamsException;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class RExceptionHandler {
    
    private static final Logger log = LoggerFactory.getLogger(RExceptionHandler.class);
    
    @ExceptionHandler(ParamsException.class)
    public RestResponse<String> handleParamsException(ParamsException e) {
        log.error("error is {}", e.getMsg());
        return RestResponse.error(String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR), e.getMsg());
    }
    
    @ExceptionHandler(BusinessException.class)
    public RestResponse<String> handleBusinessException(BusinessException e) {
        log.error("error is {}", e.getMsg());
        return RestResponse.error(e.getCode(), e.getMsg());
    }
    
    @ExceptionHandler(CommonException.class)
    public RestResponse<String> handleRRException(CommonException e) {
        log.error("error is {}", e.getMessage());
        return RestResponse.error(e.getCode(), e.getMessage());
    }
    
    @ExceptionHandler(BadRequestException.class)
    public RestResponse<String> handleBadRequestException(BadRequestException e) {
        log.error("error is {}", e.getMessage());
        return RestResponse.error(String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR), e.getMessage());
    }
    
    @ExceptionHandler(UnauthorizedException.class)
    public RestResponse<String> handleUnauthorizedException(UnauthorizedException e) {
        log.error("error is {}", e.getMessage());
        return RestResponse.error(String.valueOf(HttpStatus.SC_UNAUTHORIZED), e.getMessage());
    }
    
    @ExceptionHandler(NullPointerException.class)
    public RestResponse<String> handleRException(NullPointerException e) {
        log.error("error is {}", e);
        return RestResponse.error(String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR), "服务器繁忙");
    }
    
    @ExceptionHandler(RuntimeException.class)
    public RestResponse<String> handleRException(RuntimeException e) {
        log.error("error is {}", e);
        return RestResponse.error(String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR), "服务器繁忙");
    }
    
    @ExceptionHandler(Exception.class)
    public RestResponse<String> handleRException(Exception e) {
        log.error("error is {}", e);
        return RestResponse.error(String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR), "服务器繁忙");
    }
    
    @ExceptionHandler(DuplicateKeyException.class)
    public RestResponse<String> handleDuplicateKeyException(DuplicateKeyException e) {
        log.error("error is {}", e);
        return RestResponse.error(String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR), "相同的数据已经存在");
    }
    
    @ExceptionHandler(BindException.class)
    public RestResponse<String> bindExceptionHandler(BindException ex) {
        log.error("error is {}", ex);
        BindingResult rs = ex.getBindingResult();
        String result = "入参错误：";
        if (rs.hasErrors()) {
            // 得到全部不合法的字段
            List<FieldError> fieldErrors = rs.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                // 获取不合法的字段名和不合法原因
                log.error("error field is : {} ,message is : {}",
                    fieldError.getField(),
                    fieldError.getDefaultMessage());
                result += fieldError.getField() + fieldError.getDefaultMessage();
            }
        }
        return RestResponse.error(String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR), result);
    }
    
}
