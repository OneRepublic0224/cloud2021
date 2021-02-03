package com.zsh.springcloud.service;

import com.zsh.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author zhangsihang
 * @Time 2020/11/10 08:54
 */

@FeignClient(value = "CLOUD-PROVIDER-PAYMENT")
@Component
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/timeout")
    public String paymentTimeOut();
}
