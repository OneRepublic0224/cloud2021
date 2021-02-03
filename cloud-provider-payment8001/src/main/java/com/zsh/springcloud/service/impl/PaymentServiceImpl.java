package com.zsh.springcloud.service.impl;

import com.zsh.springcloud.dao.PaymentDao;
import com.zsh.springcloud.entities.Payment;
import com.zsh.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author zhangsihang
 * @Time 2020/10/23 15:04
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
