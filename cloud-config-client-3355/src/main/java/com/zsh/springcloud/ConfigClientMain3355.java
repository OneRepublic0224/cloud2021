package com.zsh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author zhangsihang
 * @Time 2021/2/5 16:34
 *
 * 1.pom中增加actuator依赖
 * 2.controller中增加@RefreshScope
 * 3.配置文件中增加management.endpoints.web.exposure.include:"*"
 * 4.当github中修改配置文件时,需要再运行curl -X POST "http://localhost:3355/actuator/refresh"
 */

@EnableEurekaClient
@SpringBootApplication
public class ConfigClientMain3355 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3355.class, args);
    }
}


