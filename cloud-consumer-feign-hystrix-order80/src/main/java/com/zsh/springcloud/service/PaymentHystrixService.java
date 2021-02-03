package com.zsh.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author zhangsihang
 * @Time 2020/11/12 15:02
 */

//    @FeignClient注解在接口上

@Component
@FeignClient(value = "cloud-provider-hystrix-payment", fallback = PaymentFallBackService.class)
public interface PaymentHystrixService {

    @GetMapping(value = "/hystrix/ok/{id}")
    public String info_OK(@PathVariable("id") Integer id);

    @GetMapping(value = "/hystrix/timeout/{id}")
    public String info_TimeOut(@PathVariable("id") Integer id);
}
