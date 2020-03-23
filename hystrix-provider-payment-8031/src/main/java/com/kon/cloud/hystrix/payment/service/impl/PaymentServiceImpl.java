package com.kon.cloud.hystrix.payment.service.impl;

import cn.hutool.core.util.IdUtil;
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

    // =====================================服务熔断=========================================

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerHandler", commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), // 失败率达到多少跳闸
    })
    @Override
    public Result paymentCircuitBreaker(int id) {
        if (id < 0) {
            throw new RuntimeException("id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return R.ok(Thread.currentThread().getName() + "调用成功，流水号为：" + serialNumber);
    }

    public Result paymentCircuitBreakerHandler(int id) {
        return R.no("id不能为负数");
    }

}
