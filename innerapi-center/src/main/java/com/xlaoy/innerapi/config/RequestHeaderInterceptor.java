package com.xlaoy.innerapi.config;

import com.xlaoy.common.constants.SSOConstants;
import com.xlaoy.common.support.UserGuidHolder;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2018/2/23 0023.
 */
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
