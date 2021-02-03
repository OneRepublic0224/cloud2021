package com.zsh.springcloud.controller;

import com.zsh.springcloud.entities.CommonResult;
import com.zsh.springcloud.entities.Payment;
import com.zsh.springcloud.service.PaymentFeignService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author zhangsihang
 * @Time 2020/11/10 08:57
 */

@RestController
public class OrderFeignController {

    @Resource
    PaymentFeignService paymentFeignService;

    @Resource
    DiscoveryClient discoveryClient;

    @GetMapping(value = "/feign/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

//    DiscoveryClient
    @GetMapping(value = "/feign/discovery")
    public Object discovery(){
//        获取Eureka上application列表
        List<String> services = discoveryClient.getServices();
        for(String service : services){
            System.out.println(service);
        }

//        serviceId也就是 yml文件中spring.application.name
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-consumer-feign-order");
        for(ServiceInstance instance : instances){
            System.out.println(instance.getHost() +
                    " " + instance.getUri() +
                    " " + instance.getPort() +
                    " " + instance.getServiceId() +
                    " " + instance.getScheme());
        }

        return this.discoveryClient;
    }

//    超时控制
    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeOut(){
        return paymentFeignService.paymentTimeOut();
    }
}
