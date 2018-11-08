package com.xlaoy.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Administrator on 2018/11/2 0002.
 */
@Data
@ConfigurationProperties(prefix = "zookeeper")
public class ZookeeperProperties {

    private String hosts;

    private Integer sleepTime;

    private Integer maxRetries;

}
