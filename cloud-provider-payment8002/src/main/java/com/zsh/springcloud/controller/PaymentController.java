package com.zsh.springcloud.controller;

import com.oracle.tools.packager.Log;
import com.zsh.springcloud.entities.CommonResult;
import com.zsh.springcloud.entities.Payment;
import com.zsh.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author zhangsihang
 * @Time 2020/11/4 14:24
 */

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create/")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        Log.info("******插入结果:" + payment);

        if(result > 0){
            return new CommonResult(200, "插入成功:" + serverPort, result);
        }else{
            return new CommonResult(444, "插入失败:" + serverPort, null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        Log.info("******查询结果:" + payment);

        if(payment != null){
            return new CommonResult(200, "查询成功:" + serverPort, payment);
        }else{
            return new CommonResult(444, "查询失败:" + serverPort, null);
        }
    }
}