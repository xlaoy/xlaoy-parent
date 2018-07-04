package com.xlaoy.starter.handler;

import com.xlaoy.common.exception.BizException;
import com.xlaoy.common.exception.ExceptionResponse;
import com.xlaoy.common.utils.JSONUtil;
import com.xlaoy.innerapi.config.BizHystrixBadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.NestedServletException;

import javax.servlet.http.HttpServletRequest;

/**
 */
@RestControllerAdvice
public class RestExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BizException.class)
    public ExceptionResponse excetpion(BizException exception, HttpServletRequest request) {
        logger.error("业务逻辑异常，url={{}}，参数={}",request.getRequestURI(),
                JSONUtil.toJsonString(request.getParameterMap()), exception);
        if(!StringUtils.isEmpty(exception.getErrorKey())) {
            return new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), exception.getErrorKey());
        } else {
            return new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
        }
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public ExceptionResponse excetpion(Exception exception, HttpServletRequest request) {
        logger.error("系统异常，url={{}}，参数={}",request.getRequestURI(),
                JSONUtil.toJsonString(request.getParameterMap()), exception);
        return new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "系统异常");
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = NestedServletException.class)
    public ExceptionResponse excetpion(NestedServletException exception, HttpServletRequest request) {
        logger.error("参数异常，url={{}}，参数={}",request.getRequestURI(),
                JSONUtil.toJsonString(request.getParameterMap()), exception);
        return new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), "参数异常");
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BizHystrixBadRequestException.class)
    public ExceptionResponse excetpion(BizHystrixBadRequestException exception, HttpServletRequest request) {
        logger.error("调用Fegin异常，url={{}}，参数={}",request.getRequestURI(),
                JSONUtil.toJsonString(request.getParameterMap()), exception);
        if(!StringUtils.isEmpty(exception.getErrorKey())) {
            return new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), exception.getErrorKey());
        } else {
            return new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
        }
    }

}