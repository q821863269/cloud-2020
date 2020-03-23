package com.kon.cloud.hystrix.payment.controller;

import com.kon.cloud.common.vo.Result;
import com.kon.cloud.hystrix.payment.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Lin Kun
 * @create 2020/3/12
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private IPaymentService paymentService;

    @GetMapping("/hystrix/ok/{id}")
    public Result paymentInfoOk(@PathVariable("id") int id) {
        return paymentService.paymentInfoOk(id);
    }

    @GetMapping("/hystrix/timeout")
    public Result paymentInfoTimeout(@RequestParam("second") int second) {
        return paymentService.paymentInfoTimeout(second);
    }

    @GetMapping("/circuit/{id}")
    public Result paymentCircuit(@PathVariable("id") int id) {
        return paymentService.paymentCircuitBreaker(id);
    }

}
