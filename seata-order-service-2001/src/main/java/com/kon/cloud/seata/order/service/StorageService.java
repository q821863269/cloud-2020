package com.kon.cloud.seata.order.service;

import com.kon.cloud.common.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Lin Kun
 * @create 2020/3/29
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping("/storage/decrease")
    Result decrease(@RequestParam("productId") Long productId,
                    @RequestParam("count") Integer count);

}
