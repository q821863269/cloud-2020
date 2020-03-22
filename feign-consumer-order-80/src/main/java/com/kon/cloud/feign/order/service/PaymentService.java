package com.kon.cloud.feign.order.service;

import com.kon.cloud.common.entity.Payment;
import com.kon.cloud.common.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @author Lin Kun
 * @create 2020/3/22
 */
@Component
@FeignClient(value = "provider-payment")
@RequestMapping("/payment")
public interface PaymentService {

    @PostMapping("/create")
    Result create(@RequestBody Payment payment);

    @GetMapping("/{id}")
    Result getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/feign/timeout")
    Result feignTimeout(@RequestParam("second") int second);

}
