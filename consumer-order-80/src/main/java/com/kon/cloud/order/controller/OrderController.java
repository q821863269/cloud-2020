package com.kon.cloud.order.controller;

import com.kon.cloud.common.entity.Payment;
import com.kon.cloud.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Lin Kun
 * @create 2020/3/13
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
public class OrderController {

    public static final String PAYMENT_URL = "http://127.0.0.1:8001";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/payment/create")
    public Result create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, Result.class);
    }

    @GetMapping("/payment/{id}")
    public Result getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, Result.class);
    }

}
