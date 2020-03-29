package com.kon.cloud.seata.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Lin Kun
 * @create 2020/3/29
 */
@MapperScan("com.kon.cloud.seata.account.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class SeataAccountServiceMain2003 {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccountServiceMain2003.class, args);
    }

}
