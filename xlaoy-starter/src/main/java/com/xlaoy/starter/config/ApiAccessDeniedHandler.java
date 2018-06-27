package com.xlaoy.starter.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ApiAccessDeniedHandler implements AccessDeniedHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {

        logger.error("访问无权限,url={}", request.getRequestURI());

        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden");
    }

}
