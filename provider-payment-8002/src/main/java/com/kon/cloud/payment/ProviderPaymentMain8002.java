package com.kon.cloud.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Lin Kun
 * @create 2020/3/12
 */
@MapperScan("com.kon.cloud.payment.dao")
@EnableEurekaClient
@SpringBootApplication
public class ProviderPaymentMain8002 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentMain8002.class, args);
    }

}
