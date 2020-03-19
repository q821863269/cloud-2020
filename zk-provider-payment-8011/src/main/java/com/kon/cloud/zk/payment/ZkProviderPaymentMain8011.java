package com.kon.cloud.zk.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Lin Kun
 * @create 2020/3/12
 */
@MapperScan("com.kon.cloud.zk.payment.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class ZkProviderPaymentMain8011 {

    public static void main(String[] args) {
        SpringApplication.run(ZkProviderPaymentMain8011.class, args);
    }

}
