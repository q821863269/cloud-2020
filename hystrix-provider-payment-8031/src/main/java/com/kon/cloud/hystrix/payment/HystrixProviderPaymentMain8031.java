package com.kon.cloud.hystrix.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Lin Kun
 * @create 2020/3/21
 */
@MapperScan("com.kon.cloud.hystrix.payment.dao")
// 激活服务降级
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class HystrixProviderPaymentMain8031 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixProviderPaymentMain8031.class, args);
    }

}
