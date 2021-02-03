package com.zsh.springcloud.controller;

import com.zsh.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author zhangsihang
 * @Time 2020/11/12 13:30
 */

//    全局降级:@DefaultProperties(defaultFallback = "consumerGlobalFallBack")
//    

@RestController
public class HystrixController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/hystrix/ok/{id}")
    public String info_OK(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_OK(id);
        System.out.println("********:" + result);

        return result;
    }

//    一个controller中mapping的value不能重复
    @GetMapping(value = "/hystrix/timeout/{id}")
    public String info_TimeOut(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_TimeOut(id);
        System.out.println("********:" + result);

        return result;
    }

//    熔断器
    @GetMapping(value = "/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String paymentCircuitBreaker = paymentService.paymentCircuitBreaker(id);
        return paymentCircuitBreaker;
    }
}
