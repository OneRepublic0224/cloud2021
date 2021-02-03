package com.zsh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author zhangsihang
 * @Time 2020/11/10 08:52
 */
//pom.xml中spring-cloud-starter-netflix-eureka-client
//和spring-cloud-netflix-eureka-client不是一个东西

//    1.feign的默认负载均衡算法不知道怎么改变,只知道默认的是轮询算法
//    2.超时控制可以实现,就是consumer端访问provider端,处理时间超过默认时间(貌似是1s),就会报错
//      在consumer端的yml文件中设置connectTimeOut和ReadTimeOut来修改默认时间
//    3.日志增强可以实现,在配置类中返回Logger.Level.FULL,在yml文件中设置service接口的级别(DEBUG)
//    4.简化client增删改查可以实现,直接在service接口中调用provider端中controller类的方法(基本功能)

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableDiscoveryClient
public class OrderFeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class, args);
    }
}
