package com.xlaoy.user.config;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/11/2 0002.
 */
@Configuration
@EnableConfigurationProperties(ZookeeperProperties.class)
public class CuratorConfig {

    @Autowired
    private ZookeeperProperties properties;

    @Bean
    public CuratorFramework curator() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(properties.getSleepTime(), properties.getMaxRetries());
        CuratorFramework curator = CuratorFrameworkFactory.newClient(properties.getHosts(), retryPolicy);
        curator.start();
        return curator;
    }

}
