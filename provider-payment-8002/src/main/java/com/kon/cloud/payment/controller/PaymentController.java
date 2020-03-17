package com.kon.cloud.payment.controller;

import com.kon.cloud.common.entity.Payment;
import com.kon.cloud.common.vo.R;
import com.kon.cloud.common.vo.Result;
import com.kon.cloud.payment.service.IPaymentService;
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

    @PostMapping("/create")
    public Result create(@RequestBody Payment payment) {
        boolean result = paymentService.save(payment);
        if (result) {
            return R.ok(serverPort + "操作成功");
        } else {
            return R.no(serverPort + "操作失败");
        }
    }

    @GetMapping("/{id}")
    public Result getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getById(id);
        return R.ok(serverPort + "查询成功", payment);
    }

}
