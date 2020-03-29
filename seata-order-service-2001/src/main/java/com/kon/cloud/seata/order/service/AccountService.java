package com.kon.cloud.seata.order.service;

import com.kon.cloud.common.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author Lin Kun
 * @create 2020/3/29
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping("/account/decrease")
    Result decrease(@RequestParam("userId") Long userId,
                    @RequestParam("money") BigDecimal money);

}
