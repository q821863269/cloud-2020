package com.kon.cloud.consul.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Lin Kun
 * @create 2020/3/13
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsulConsumerOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsulConsumerOrderMain80.class, args);
    }

}
