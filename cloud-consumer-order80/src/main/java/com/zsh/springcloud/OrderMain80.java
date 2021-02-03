package com.zsh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author zhangsihang
 * @Time 2020/10/27 14:24
 */

//负载均衡:随机
//name是application,意思就是修改本微服务访问name微服务集群的负载均衡算法,configuration就是负载算法类
//修改负载均衡算法:本微服务(cloud-consumer-order)访问cloud-provider-payment时的负载均衡算法
//@RibbonClient(name = "cloud-provider-payment", configuration = MySelfRule.class)
@SpringBootApplication
@EnableEurekaClient
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
