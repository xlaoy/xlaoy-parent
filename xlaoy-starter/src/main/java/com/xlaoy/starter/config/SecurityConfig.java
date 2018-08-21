package com.xlaoy.starter.config;

import com.task.client.config.ServerURL;
import com.xlaoy.starter.filter.UserGuidFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * Created by xlaoy on 2016/11/3.
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String SYSTEM_API_USER_NAME = "xlaoy";
    private static final String SYSTEM_API_USER_PASSWORD = "123456";
    private static final String SYSTEM_API_ACCESS_ROLE = "XLAOY_API";

    @Autowired
    private UserGuidFilter userGuidFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .passwordEncoder(new SimplePasswordEncoder())
            .withUser(SYSTEM_API_USER_NAME)
            .password(SYSTEM_API_USER_PASSWORD)
            .roles(SYSTEM_API_ACCESS_ROLE);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .httpBasic().and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .addFilterAfter(userGuidFilter, BasicAuthenticationFilter.class)
            .authorizeRequests()
            .anyRequest().hasRole(SYSTEM_API_ACCESS_ROLE);
    }

    private class SimplePasswordEncoder implements PasswordEncoder {

        @Override
        public String encode(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override
        public boolean matches(CharSequence charSequence, String s) {
            return charSequence.equals(s);
        }
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
            ServerURL.TASK_PERMITALL_URL,
            "/actuator/**",
            "/error",
            "/favicon.ico"
        );
    }
}
