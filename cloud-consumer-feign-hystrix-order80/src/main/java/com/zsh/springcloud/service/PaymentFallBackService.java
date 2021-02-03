package com.zsh.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author zhangsihang
 * @Time 2020/11/17 11:29
 */

@Component
public class PaymentFallBackService implements PaymentHystrixService{
    @Override
    public String info_OK(Integer id) {
        return "OK的降级方法";
    }

    @Override
    public String info_TimeOut(Integer id) {
        return "TimeOut的降级方法";
    }
}
