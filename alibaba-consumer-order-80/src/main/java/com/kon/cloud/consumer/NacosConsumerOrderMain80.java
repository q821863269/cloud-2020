package com.kon.cloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Lin Kun
 * @create 2020/3/28
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConsumerOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerOrderMain80.class, args);
    }

}
