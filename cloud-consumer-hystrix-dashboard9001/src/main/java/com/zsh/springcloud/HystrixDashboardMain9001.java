package com.zsh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author zhangsihang
 * @Time 2020/11/20 10:11
 */

//
//    1.hystrix监控端注解@EnableHystrixDashboard
//    2.yml中配置端口号和hystrix.dashboard.proxy-stream-allow-list: "*"
//    3.被监控的微服务主启动中 ServletRegistrationBean 函数

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class, args);
    }
}
