package com.kon.cloud.stream.rabbitmq.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Lin Kun
 * @create 2020/3/28
 */
@EnableEurekaClient
@SpringBootApplication
public class CloudStreamRabbitmqProviderMain8801 {

    public static void main(String[] args) {
        SpringApplication.run(CloudStreamRabbitmqProviderMain8801.class, args);
    }

}
