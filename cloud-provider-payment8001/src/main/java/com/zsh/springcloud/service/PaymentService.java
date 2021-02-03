package com.zsh.springcloud.service;

import com.zsh.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author zhangsihang
 * @Time 2020/10/23 15:03
 */
public interface PaymentService {

    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
