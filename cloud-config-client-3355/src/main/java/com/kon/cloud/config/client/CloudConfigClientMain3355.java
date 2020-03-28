package com.kon.cloud.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Lin Kun
 * @create 2020/3/28
 */
@EnableEurekaClient
@SpringBootApplication
public class CloudConfigClientMain3355 {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigClientMain3355.class, args);
    }

}
