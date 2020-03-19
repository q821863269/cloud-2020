package com.kon.cloud.zk.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Lin Kun
 * @create 2020/3/13
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ZkConsumerOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ZkConsumerOrderMain80.class, args);
    }

}
