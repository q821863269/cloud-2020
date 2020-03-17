package com.kon.cloud.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Lin Kun
 * @create 2020/3/13
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 重点：@LoadBalanced开启RestTemplate的负载均衡
     *      在使用服务名调用时，如果不配置会报错
     *
     * @return RestTemplate
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
