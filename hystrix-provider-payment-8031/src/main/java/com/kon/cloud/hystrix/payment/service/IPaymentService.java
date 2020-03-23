package com.kon.cloud.hystrix.payment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kon.cloud.common.entity.Payment;
import com.kon.cloud.common.vo.Result;

/**
 * @author Lin Kun
 * @create 2020/3/12
 */
public interface IPaymentService extends IService<Payment> {

    Result paymentInfoOk(int id);

    Result paymentInfoTimeout(int second);

    public Result paymentCircuitBreaker(int id);

}
