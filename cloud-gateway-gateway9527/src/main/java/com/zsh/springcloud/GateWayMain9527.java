package com.zsh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author zhangsihang
 * @Time 2020/11/24 14:23
 */

/**
 *      1.pom.xml中添加spring-cloud-starter-gateway和eureka-client(不要添加starter-web)
 *      2.yml中配置spring.cloud.gateway.routes
 */

@SpringBootApplication
@EnableEurekaClient
public class GateWayMain9527 {

    public static void main(String[] args) {
        SpringApplication.run(GateWayMain9527.class, args);
    }
}
