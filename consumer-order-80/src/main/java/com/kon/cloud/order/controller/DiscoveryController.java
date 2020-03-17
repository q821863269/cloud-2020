package com.kon.cloud.order.controller;

import com.kon.cloud.common.vo.R;
import com.kon.cloud.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private EurekaDiscoveryClient discoveryClient;

    @GetMapping("/services")
    public Result services() {
        List<String> services = discoveryClient.getServices();
        return R.ok(services);
    }

    @GetMapping("/getInstances/{name}")
    public Result getInstances(@PathVariable("name") String name) {
        List<ServiceInstance> instances = discoveryClient.getInstances(name);
        return R.ok(instances);
    }

}
