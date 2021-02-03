package com.zsh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author zhangsihang
 * @Time 2020/11/12 15:00
 */

//    1.@EnableHystrix和@EnableCircuitBreaker区别?
//    @EnableHystrix继承了@EnableCircuitBreaker

//    2.全局降级方法,在controller上加注解
//    @DefaultProperties(defaultFallback = "consumerGlobalFallBack")
//    3.全局降级方法,实现service接口,然后在@FeignClient上添加service的实现类

//    @FeignClient(value = "cloud-provider-hystrix-payment",
//    fallback = PaymentFallBackService.class),此降级方法不涉及到payment端(比如payment端宕机)

//    4.目前用到降级的场景:(1)调用时间超时. (2)异常. (3)Payment端宕机.

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix
public class OrderHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class, args);
    }
}
