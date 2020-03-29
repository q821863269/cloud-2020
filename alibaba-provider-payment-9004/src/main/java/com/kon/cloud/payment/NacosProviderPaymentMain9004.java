package com.kon.cloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Lin Kun
 * @create 2020/3/12
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosProviderPaymentMain9004 {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderPaymentMain9004.class, args);
    }

}
