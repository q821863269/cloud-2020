package com.kon.cloud.sentinel.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.kon.cloud.common.vo.R;
import com.kon.cloud.common.vo.Result;
import com.kon.cloud.sentinel.consumer.feign.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 订单控制器
 *
 * @author Lin Kun
 * @create 2020/3/13
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
public class OrderController {

    private static final String PAYMENT_URL = "http://nacos-provider-payment";

    @Resource(name = "serviceRestTemplate")
    private RestTemplate restTemplate;

    // --------------------------------------------------------------------------------------------------

    //@SentinelResource(value = "fallback") // 没有配置，直接返回error
    //@SentinelResource(value = "fallback", fallback = "handlerFallback") // 只配置了fallback
    //@SentinelResource(value = "fallback", blockHandler = "blockHandler") // 只配置了fallback
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler")
    @GetMapping("/fallback/{id}")
    public Result fallback(@PathVariable("id") Long id) {
        Result result = restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, Result.class);
        if (id == 4) {
            throw new IllegalArgumentException("非法参数异常");
        } else {
            assert result != null;
            if (result.getData() == null) {
                throw new NullPointerException("该ID没有对应记录，空指针异常");
            }
        }
        return result;
    }

    // fallback方法
    public Result handlerFallback(@PathVariable("id") Long id, Throwable e) {
        return R.no(e.getMessage());
    }

    // blockHandler方法
    public Result blockHandler(@PathVariable("id") Long id, BlockException e) {
        return R.no(e.getMessage());
    }

    // --------------------------------------------------------------------------------------------------

    // --------------------------------------------------------------------------------------------------

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/{id}")
    public Result getPaymentById(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }

    // --------------------------------------------------------------------------------------------------

}
