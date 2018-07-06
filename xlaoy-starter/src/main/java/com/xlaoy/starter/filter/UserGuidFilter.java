package com.xlaoy.starter.filter;

import com.xlaoy.common.constants.SSOConstants;
import com.xlaoy.common.support.UserGuidHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2018/3/2 0002.
 */
@Component
public class UserGuidFilter extends OncePerRequestFilter {

    private Logger logger = LoggerFactory.getLogger(UserGuidFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String guid = request.getHeader(SSOConstants.GUID);
            if(!StringUtils.isEmpty(guid)) {
                UserGuidHolder.setGuid(guid);
            }
        } catch (Exception e) {
            logger.error("获取guid异常", e);
        }
        filterChain.doFilter(request, response);
    }
}
