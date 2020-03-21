package com.kon.cloud.consul.payment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kon.cloud.common.entity.Payment;
import com.kon.cloud.consul.payment.dao.PaymentMapper;
import com.kon.cloud.consul.payment.service.IPaymentService;
import org.springframework.stereotype.Service;

/**
 * @author Lin Kun
 * @create 2020/3/12
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment>
        implements IPaymentService {

}
