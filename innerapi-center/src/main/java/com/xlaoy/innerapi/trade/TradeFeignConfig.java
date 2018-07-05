package com.xlaoy.innerapi.trade;

import com.xlaoy.common.config.ApiBasicAuthProperties;
import com.xlaoy.innerapi.config.ApplactionName;
import com.xlaoy.innerapi.config.RequestHeaderInterceptor;
import com.xlaoy.innerapi.config.ResultErrorDecoder;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/2/23 0023.
 */
@Configuration
@EnableConfigurationProperties(ApiBasicAuthProperties.class)
public class TradeFeignConfig {

    @Autowired
    private ApiBasicAuthProperties apiBasicAuthProperties;

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        ApiBasicAuthProperties.BasicAuthInfo basicAuthInfo = apiBasicAuthProperties.getService(ApplactionName.TRADE_SERVER);
        return new BasicAuthRequestInterceptor(basicAuthInfo.getUsername(), basicAuthInfo.getPassword());
    }

    @Bean
    public RequestHeaderInterceptor requestHeaderInterceptor() {
        return new RequestHeaderInterceptor();
    }

    @Bean
    public ErrorDecoder errorDecoder(){
        return new ResultErrorDecoder();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
