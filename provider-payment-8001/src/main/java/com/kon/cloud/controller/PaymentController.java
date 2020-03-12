package com.kon.cloud.controller;

import com.kon.cloud.common.Result;
import com.kon.cloud.entity.Payment;
import com.kon.cloud.common.R;
import com.kon.cloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Lin Kun
 * @create 2020/3/12
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @PostMapping("/create")
    public Result create(Payment payment) {
        boolean result = paymentService.save(payment);
        if (result) {
            return R.ok("操作成功");
        } else {
            return R.no("操作失败");
        }
    }

    @GetMapping("/{id}")
    public Result getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getById(id);
        return R.ok(payment);
    }

}
