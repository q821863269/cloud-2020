package com.kon.cloud.seata.storage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Lin Kun
 * @create 2020/3/29
 */
@MapperScan("com.kon.cloud.seata.storage.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class SeataStorageServiceMain2002 {

    public static void main(String[] args) {
        SpringApplication.run(SeataStorageServiceMain2002.class, args);
    }

}
