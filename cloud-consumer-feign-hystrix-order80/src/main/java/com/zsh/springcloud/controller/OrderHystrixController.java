package com.zsh.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zsh.springcloud.service.PaymentHystrixService;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author zhangsihang
 * @Time 2020/11/12 15:08
 */
@RestController
@DefaultProperties(defaultFallback = "consumerGlobalFallBack")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @Resource
    DiscoveryClient discoveryClient;

    @GetMapping(value = "/consumer/hystrix/ok/{id}")
    public String info_OK(@PathVariable("id") Integer id){
        return paymentHystrixService.info_OK(id);
    }

    @GetMapping(value = "/consumer/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHa", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
//    })
    @HystrixCommand
    public String info_TimeOut(@PathVariable("id") Integer id){
//        int age = 10/0;
        return paymentHystrixService.info_TimeOut(id);
    }

    public String paymentInfo_TimeOutHa(@PathVariable("id") Integer id){
        return "consumer端超时或报错";
    }

    @GetMapping(value = "/t")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for(String service : services){
            System.out.println(service);
        }

        return this.discoveryClient;
    }

//    全局fallback方法
    public String consumerGlobalFallBack(){
        return "controller全局降级方法！！！";
    }
}
