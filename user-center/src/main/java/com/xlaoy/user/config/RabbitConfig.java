package com.xlaoy.user.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/7/11 0011.
 */
@Configuration
public class RabbitConfig {

    public static final String WO_CAO = "wocao";

    @Bean
    public Queue queue() {
        return new Queue(WO_CAO);
    }
}
