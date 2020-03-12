package com.kon.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Lin Kun
 * @create 2020/3/12
 */
@MapperScan("com.kon.cloud.dao")
@SpringBootApplication
public class ProviderPaymentMain {

    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentMain.class, args);
    }

}