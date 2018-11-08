package com.xlaoy.starter;

import com.spring4all.swagger.EnableSwagger2Doc;
import com.task.client.config.EnableTaskClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by Administrator on 2018/2/1 0001.
 */
//@EnableTaskClient
@EnableSwagger2Doc
@EnableEurekaClient
@EnableCircuitBreaker
@EnableFeignClients(basePackages = "com.xlaoy.innerapi")
@SpringBootApplication(scanBasePackages = {"com.xlaoy"})
public class StarterApplaction {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(StarterApplaction.class);
        springApplication.addListeners(new ApplicationSetup());
        springApplication.run(args);
    }

}
