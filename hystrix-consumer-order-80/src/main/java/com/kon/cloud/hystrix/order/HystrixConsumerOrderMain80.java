package com.kon.cloud.hystrix.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Lin Kun
 * @create 2020/3/22
 */
@EnableHystrix
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class HystrixConsumerOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixConsumerOrderMain80.class, args);
    }

}
