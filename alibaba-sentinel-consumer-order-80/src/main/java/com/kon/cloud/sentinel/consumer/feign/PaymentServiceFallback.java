package com.kon.cloud.sentinel.consumer.feign;

import com.kon.cloud.common.vo.R;
import com.kon.cloud.common.vo.Result;
import org.springframework.stereotype.Component;

/**
 * @author Lin Kun
 * @create 2020/3/29
 */
@Component
public class PaymentServiceFallback implements PaymentService {

    @Override
    public Result getPaymentById(Long id) {
        return R.no("PaymentServiceFallback.getPaymentById");
    }

}
