package com.zsh.springcloud.service;

import com.zsh.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author zhangsihang
 * @Time 2020/11/4 14:26
 */
public interface PaymentService {

    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
