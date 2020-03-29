package com.kon.cloud.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.kon.cloud.common.entity.Payment;
import com.kon.cloud.common.vo.R;
import com.kon.cloud.common.vo.Result;
import com.kon.cloud.sentinel.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lin Kun
 * @create 2020/3/29
 */
@RestController
public class RateLimitController {

    @SentinelResource(value = "byResource", blockHandler = "handleException")
    @GetMapping("/byResource")
    public Result byResource() {
        return R.ok("按资源名称限流测试OK", new Payment(2020L, "serial2020"));
    }

    public Result handleException(BlockException exception) {
        return R.no(exception.getClass().getCanonicalName() + "服务不可用");
    }

    @SentinelResource(value = "byUrl")
    @GetMapping("/byUrl")
    public Result byUrl() {
        return R.ok("按url限流测试OK", new Payment(2020L, "serial2020"));
    }

    @SentinelResource(value = "customerBlockHandler",
        blockHandlerClass = CustomerBlockHandler.class,
        blockHandler = "handlerException")
    @GetMapping("/customerBlockHandler")
    public Result customerBlockHandler() {
        return R.ok("按客户自定义", new Payment(2020L, "serial2020"));
    }

}
