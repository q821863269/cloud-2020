package com.kon.cloud.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Lin Kun
 * @create 2020/3/12
 */
@MapperScan("com.kon.cloud.payment.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class NacosProviderPaymentMain9002 {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderPaymentMain9002.class, args);
    }

}
