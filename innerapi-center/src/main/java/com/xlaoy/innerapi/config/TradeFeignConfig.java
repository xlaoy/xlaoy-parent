package com.xlaoy.innerapi.config;

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
@EnableConfigurationProperties(FeignProperties.class)
public class TradeFeignConfig {

    @Autowired
    private FeignProperties feignProperties;

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor(feignProperties.getTrade().getUsername(), feignProperties.getTrade().getPassword());
    }

    @Bean
    public RequestHeaderInterceptor requestHeaderInterceptor() {
        return new RequestHeaderInterceptor();
    }

    @Bean
    public ErrorDecoder errorDecoder(){
        return new ResultErrorDecoder();
    }

}
