package com.xlaoy.innerapi.config;

import com.xlaoy.common.config.SSOConstants;
import com.xlaoy.common.support.UserGuidHolder;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/2/23 0023.
 */
@Configuration
public class RequestHeaderInterceptor implements RequestInterceptor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 为了能够获取header信息，hystrix隔离只能采用SEMAPHORE（信号量）隔离方法，
     * @param template
     */
    @Override
    public void apply(RequestTemplate template) {
        template.header(SSOConstants.GUID, UserGuidHolder.getGuid());
    }
}
