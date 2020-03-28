package com.kon.cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Lin Kun
 * @create 2020/3/28
 */
@EnableConfigServer
@SpringBootApplication
public class CloudConfigServerMain3344 {

    /**
     * 刷新client配置（curl -X POST "http://config3344.com:3344/actuator/bus-refresh"）
     * 刷新client配置（curl -X POST "http://config3344.com:3344/actuator/bus-refresh/服务名:端口"）
     */
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigServerMain3344.class, args);
    }

}
