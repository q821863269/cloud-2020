package com.kon.cloud.consul.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Lin Kun
 * @create 2020/3/21
 */
@MapperScan("com.kon.cloud.consul.payment.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class ConsulProviderPaymentMain8021 {

    public static void main(String[] args) {
        SpringApplication.run(ConsulProviderPaymentMain8021.class, args);
    }

}
