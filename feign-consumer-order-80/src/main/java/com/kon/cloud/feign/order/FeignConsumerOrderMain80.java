package com.kon.cloud.feign.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Lin Kun
 * @create 2020/3/13
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FeignConsumerOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerOrderMain80.class, args);
    }

}
