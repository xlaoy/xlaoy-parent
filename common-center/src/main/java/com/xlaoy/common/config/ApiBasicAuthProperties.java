package com.xlaoy.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/2/23 0023.
 */
@ConfigurationProperties(prefix = "apibasicauth")
public class ApiBasicAuthProperties {

    private Map<String, BasicAuthInfo> services = new HashMap<>();

    public Map<String, BasicAuthInfo> getServices() {
        return services;
    }

    public BasicAuthInfo getService(String serviceId) {
        Map<String, BasicAuthInfo> map = getServices();
        return map.get(serviceId);
    }

    public void setServices(Map<String, BasicAuthInfo> services) {
        this.services = services;
    }

    public static class BasicAuthInfo {

        private String username;

        private String password;

        private String prefix;

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

}
