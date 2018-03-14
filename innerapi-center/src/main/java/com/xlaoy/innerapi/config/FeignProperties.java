package com.xlaoy.innerapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Administrator on 2018/2/23 0023.
 */
@ConfigurationProperties(prefix = "xlaoy.api")
public class FeignProperties {

    private BasicAuthInfo trade;

    private BasicAuthInfo user;

    public BasicAuthInfo getTrade() {
        return trade;
    }

    public void setTrade(BasicAuthInfo trade) {
        this.trade = trade;
    }

    public BasicAuthInfo getUser() {
        return user;
    }

    public void setUser(BasicAuthInfo user) {
        this.user = user;
    }

    public static class BasicAuthInfo {

        private String username;

        private String password;

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
