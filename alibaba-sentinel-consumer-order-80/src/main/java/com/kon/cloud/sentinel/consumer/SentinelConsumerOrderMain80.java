package com.kon.cloud.sentinel.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Lin Kun
 * @create 2020/3/29
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SentinelConsumerOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(SentinelConsumerOrderMain80.class, args);
    }

}
