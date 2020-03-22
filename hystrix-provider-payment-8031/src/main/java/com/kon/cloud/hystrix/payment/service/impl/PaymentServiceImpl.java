package com.kon.cloud.hystrix.payment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kon.cloud.common.entity.Payment;
import com.kon.cloud.common.vo.R;
import com.kon.cloud.common.vo.Result;
import com.kon.cloud.hystrix.payment.dao.PaymentMapper;
import com.kon.cloud.hystrix.payment.service.IPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Lin Kun
 * @create 2020/3/12
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment>
    implements IPaymentService {

    @Override
    public Result paymentInfoOk(int id) {
        return R.ok(baseMapper.selectById(id));
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler",
        commandProperties = {
            // 设置自身调用超时时间，超时调用fallbackMethod
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
        })
    @SneakyThrows
    @Override
    public Result paymentInfoTimeout(int second) {
        if (second == 3) {
            // 等于3故意报错
            second = 1 / 0;
        }
        TimeUnit.SECONDS.sleep(second);
        return R.ok(second);
    }

    public Result paymentInfoTimeoutHandler(int second) {
        return R.no("提供者被降级：" + second);
    }

}
