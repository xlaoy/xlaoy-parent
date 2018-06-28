package com.xlaoy.starter.config;

import com.xlaoy.common.support.JsonResponseWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Component
public class ApiAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        logger.error("系统未认证,url={}", request.getRequestURI());

        JsonResponseWriter.response(response)
                .status(HttpStatus.UNAUTHORIZED)
                .message("系统未认证").print();
    }
}
