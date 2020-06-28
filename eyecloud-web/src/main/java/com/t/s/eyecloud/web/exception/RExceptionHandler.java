package com.t.s.eyecloud.web.exception;

import java.util.List;
import java.util.Objects;

import javax.ws.rs.BadRequestException;

import com.alibaba.dubbo.rpc.RpcException;
import com.t.s.eyecloud.common.data.base.RestResponse;
import com.t.s.eyecloud.common.exception.BusinessException;
import com.t.s.eyecloud.common.exception.CommonException;
import com.t.s.eyecloud.common.exception.ParamsException;
import org.apache.http.HttpStatus;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class RExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(RExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public RestResponse<String> handleRException(Exception e) {
        log.error("error is {}", e);
        return RestResponse.error(String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR), "系统繁忙");
    }

    @ExceptionHandler(RuntimeException.class)
    public RestResponse<String> handleRuntimeException(RuntimeException e) {
        log.error("error is {}", e);
        return RestResponse.error(String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR), "系统繁忙");
    }

    @ExceptionHandler(RpcException.class)
    public RestResponse<String> handleRpcException(RpcException e) {
        log.error("error is {}", e);
        return RestResponse.error(String.valueOf(e.getCode()), e.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public RestResponse<String> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        log.error("error is {}", e);
        return RestResponse.error(String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR), "系统异常");
    }

    @ExceptionHandler(ParamsException.class)
    public RestResponse<String> handleParamsException(ParamsException e) {
        log.error("error is {}", e.getMsg());
        return RestResponse.error(String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR), e.getMsg());
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

    @ExceptionHandler(BusinessException.class)
    public RestResponse<String> handleBusinessException(BusinessException e) {
        log.error("error is {}", e.getMsg());
        return RestResponse.error(e.getCode(), e.getMsg());
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RestResponse<String> bindMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error("error is {}", ex);
        BindingResult bindingResult = ex.getBindingResult();
        return RestResponse.error(String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR), Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
    }
}
