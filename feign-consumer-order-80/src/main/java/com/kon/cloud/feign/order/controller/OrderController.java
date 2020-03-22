package com.kon.cloud.feign.order.controller;

import com.kon.cloud.common.entity.Payment;
import com.kon.cloud.common.vo.Result;
import com.kon.cloud.feign.order.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public Result create(@RequestBody Payment payment) {
        return paymentService.create(payment);
    }

    @GetMapping("/payment/{id}")
    public Result getById(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/payment/feign/timeout")
    public Result feignTimeout(@RequestParam("second") int second) {
        return paymentService.feignTimeout(second);
    }

}
