package com.kon.cloud.hystrix.order.service;

import com.kon.cloud.common.vo.Result;
import com.kon.cloud.hystrix.order.service.fallback.PaymentServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Lin Kun
 * @create 2020/3/22
 */
@Component
@FeignClient(value = "hystrix-provider-payment", fallback = PaymentServiceFallback.class)
public interface PaymentService {

    @GetMapping("/payment/hystrix/ok/{id}")
    Result paymentInfoOk(@PathVariable("id") int id);

    @GetMapping("/payment/hystrix/timeout")
    Result paymentInfoTimeout(@RequestParam("second") int second);

}
