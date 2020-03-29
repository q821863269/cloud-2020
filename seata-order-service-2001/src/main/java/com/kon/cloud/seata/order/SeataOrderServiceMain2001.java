package com.kon.cloud.seata.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Lin Kun
 * @create 2020/3/29
 */
@MapperScan("com.kon.cloud.seata.order.mapper")
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SeataOrderServiceMain2001 {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrderServiceMain2001.class, args);
    }

}
