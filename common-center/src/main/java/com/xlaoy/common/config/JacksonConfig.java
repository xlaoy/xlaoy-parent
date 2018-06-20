package com.xlaoy.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xlaoy.common.utils.JSONUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/6/20 0020.
 */
@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper serializingObjectMapper() {
        return JSONUtil.getObjectMapper();
    }

}
