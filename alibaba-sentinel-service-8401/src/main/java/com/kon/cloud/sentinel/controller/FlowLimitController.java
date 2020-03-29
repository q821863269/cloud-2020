package com.kon.cloud.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author Lin Kun
 * @create 2020/3/29
 */
@Slf4j
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public Object testA() {
        return "testA";
    }

    @GetMapping("/testB")
    public Object testB() {
        log.info("{}，testB。", Thread.currentThread().getName());
        return "testB";
    }

    // 测试RT
    @SneakyThrows
    @GetMapping("/testC")
    public Object testC() {
        TimeUnit.SECONDS.sleep(1);
        return "testC";
    }

    // 测试异常比例
    @SneakyThrows
    @GetMapping("/testD")
    public Object testD() {
        int i = 1 / 0;
        return "testD";
    }

    // 测试异常数
    @GetMapping("/testE")
    public Object testE() {
        int i = 1 / 0;
        return "testE";
    }

    @SentinelResource(value = "testHotKey", blockHandler = "dealTestHotKey")
    @GetMapping("/testHotKey")
    public Object testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "testHotKey";
    }

    public Object dealTestHotKey(String p1, String p2, BlockException e) {
        return "dealTestHotKey";
    }

}
