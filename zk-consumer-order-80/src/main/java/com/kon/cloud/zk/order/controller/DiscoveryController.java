package com.kon.cloud.zk.order.controller;

import com.kon.cloud.common.vo.R;
import com.kon.cloud.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取服务信息控制器
 *
 * @author Lin Kun
 * @create 2020/3/16
 */
@Slf4j
@RestController
@RequestMapping("/discovery")
public class DiscoveryController {

    @GetMapping("/services")
    public Result services() {
        return R.ok();
    }

    @GetMapping("/getInstances/{name}")
    public Result getInstances(@PathVariable("name") String name) {
        return R.ok();
    }

}
