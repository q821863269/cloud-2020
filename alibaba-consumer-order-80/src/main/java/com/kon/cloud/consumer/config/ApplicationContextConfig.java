package com.kon.cloud.consumer.config;

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
     *      如果使用自定义的算法，可以把@LoadBalanced去除
     *
     * @return RestTemplate
     */
    @Bean
    @LoadBalanced
    public RestTemplate serviceRestTemplate() {
        return new RestTemplate();
    }

    /**
     * 专用于Http的RestTemplate
     *
     * @return RestTemplate
     */
    @Bean
    public RestTemplate httpRestTemplate() {
        return new RestTemplate();
    }

}
