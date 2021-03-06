package com.kon.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Lin Kun
 * @create 2020/3/13
 */
// 修改某个服务的，访问策略
//@RibbonClient(name = "provider-payment", configuration = MySelfRule.class)
@EnableEurekaClient
@SpringBootApplication
public class ConsumerOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderMain80.class, args);
    }

}
