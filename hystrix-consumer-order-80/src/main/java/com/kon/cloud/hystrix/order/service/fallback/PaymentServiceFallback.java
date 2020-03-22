package com.kon.cloud.hystrix.order.service.fallback;

import com.kon.cloud.common.vo.R;
import com.kon.cloud.common.vo.Result;
import com.kon.cloud.hystrix.order.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @author Lin Kun
 * @create 2020/3/22
 */
@Component
public class PaymentServiceFallback implements PaymentService {

    @Override
    public Result paymentInfoOk(int id) {
        return R.no("paymentInfoOk fallback");
    }

    @Override
    public Result paymentInfoTimeout(int second) {
        return R.no("paymentInfoTimeout fallback");
    }

}
