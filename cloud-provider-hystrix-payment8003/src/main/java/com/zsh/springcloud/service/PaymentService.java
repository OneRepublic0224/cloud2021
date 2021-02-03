package com.zsh.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author zhangsihang
 * @Time 2020/11/12 13:31
 */

@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池:" + Thread.currentThread().getName() + " Info_OK,id:" + id +"\t";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHa", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id){

        int num = 4000;

//        超时异常
        try {
            TimeUnit.MILLISECONDS.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        计算异常
//        int i = 10/0;

        return "线程池:" + Thread.currentThread().getName() + " Info_TimeOut,id:" + id +"\t" + "耗时" + num +  "ms";
    }

    public String paymentInfo_TimeOutHa(Integer id){
        return "provider端超时或报错";
    }

//    服务熔断
//    circuitBreaker.xxx去  HystrixCommandProperties  方法里找
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String paymentCircuitBreaker(Integer id){
        if(id < 0){
            throw new RuntimeException("***********id 不能为负数");
        }

        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功, 流水号:" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(Integer id){
        return "id 不能为负数,请稍后再试";
    }
}
