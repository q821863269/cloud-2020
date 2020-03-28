package com.kon.cloud.stream.rabbitmq.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Lin Kun
 * @create 2020/3/28
 */
@EnableEurekaClient
@SpringBootApplication
public class CloudStreamRabbitmqConsumerMain8811 {

    public static void main(String[] args) {
        SpringApplication.run(CloudStreamRabbitmqConsumerMain8811.class, args);
    }

}
