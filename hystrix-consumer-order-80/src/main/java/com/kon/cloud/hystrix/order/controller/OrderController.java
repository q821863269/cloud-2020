package com.kon.cloud.hystrix.order.controller;

import com.kon.cloud.common.vo.R;
import com.kon.cloud.common.vo.Result;
import com.kon.cloud.hystrix.order.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 这里将配置在Controller的fallback改到了feign层，不用每个方法都去处理
 *
 * @author Lin Kun
 * @create 2020/3/22
 */
@Slf4j
//@DefaultProperties(defaultFallback = "globalFallBackHandler")
@RestController
@RequestMapping("/consumer")
public class OrderController {

    @Resource
    private PaymentService paymentService;

    //@HystrixCommand
    @GetMapping("/payment/hystrix/ok/{id}")
    public Result ok(@PathVariable("id") int id) {
        if (id == 0) {
            // 测试全局降级
            id = 1 / 0;
        }
        return paymentService.paymentInfoOk(id);
    }

    /*@HystrixCommand(fallbackMethod = "timeoutHandler",
        commandProperties = {
            // 设置自身调用超时时间，超时调用fallbackMethod
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
        })*/
    @GetMapping("/payment/hystrix/timeout")
    public Result timeout(@RequestParam("second") int second) {
        return paymentService.paymentInfoTimeout(second);
    }

    public Result timeoutHandler(int second) {
        return R.no("消费者被降级了：" + second);
    }

    public Result globalFallBackHandler() {
        return R.no("消费者全局降级处理");
    }

}
