package com.xlaoy.innerapi.config;

import com.xlaoy.common.support.UserGuidHolder;
import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * Created by Administrator on 2018/2/23 0023.
 */
public class RequestHeaderInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header("guid", UserGuidHolder.getGuid());
    }
}
