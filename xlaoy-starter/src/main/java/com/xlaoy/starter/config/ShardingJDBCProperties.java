package com.xlaoy.starter.config;

import io.shardingjdbc.core.yaml.masterslave.YamlMasterSlaveConfiguration;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Administrator on 2019/4/2 0002.
 */
@Data
@ConfigurationProperties(prefix = "spring.sharding-jdbc")
public class ShardingJDBCProperties extends YamlMasterSlaveConfiguration {
}
