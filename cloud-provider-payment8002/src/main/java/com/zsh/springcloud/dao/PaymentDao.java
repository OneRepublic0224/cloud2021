package com.zsh.springcloud.dao;

import com.zsh.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author zhangsihang
 * @Time 2020/11/4 14:24
 */


@Mapper
public interface PaymentDao {

    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
