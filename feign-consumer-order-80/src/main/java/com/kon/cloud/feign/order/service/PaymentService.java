package com.kon.cloud.feign.order.service;

import com.kon.cloud.common.entity.Payment;
import com.kon.cloud.common.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author Lin Kun
 * @create 2020/3/22
 */
@FeignClient(value = "provider-payment")
public interface PaymentService {

    @PostMapping("/payment/create")
    Result create(@RequestBody Payment payment);

    @GetMapping("/payment/{id}")
    Result getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    Result feignTimeout(@RequestParam("second") int second);

}
