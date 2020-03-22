package com.kon.cloud.order.controller;

import com.kon.cloud.common.entity.Payment;
import com.kon.cloud.common.vo.Result;
import com.kon.cloud.order.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * 订单控制器
 *
 * @author Lin Kun
 * @create 2020/3/13
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
public class OrderController {

    private static final String PAYMENT_URL = "http://provider-payment";

    @Resource
    private EurekaDiscoveryClient discoveryClient;

    @Resource(name = "serviceRestTemplate")
    private RestTemplate restTemplate;

    @Resource(name = "httpRestTemplate")
    private RestTemplate httpRestTemplate;

    @Resource
    private LoadBalancer myLoadBalancer;

    @PostMapping("/payment/create")
    public Result create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, Result.class);
    }

    @GetMapping("/payment/{id}")
    public Result getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, Result.class);
    }

    @GetMapping("/payment/lb")
    public Result getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("provider-payment");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance instance = myLoadBalancer.instances(instances);
        URI uri = instance.getUri();
        return httpRestTemplate.getForObject(uri + "/payment/lb", Result.class);
    }

}
