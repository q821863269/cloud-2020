package com.kon.cloud.sentinel.consumer.feign;

import com.kon.cloud.common.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Lin Kun
 * @create 2020/3/29
 */
@FeignClient(value = "nacos-provider-payment", fallback = PaymentServiceFallback.class)
public interface PaymentService {

    @GetMapping("/payment/{id}")
    Result getPaymentById(@PathVariable("id") Long id);

}
