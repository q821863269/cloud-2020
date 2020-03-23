package com.kon.cloud.hystrix.payment;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * @author Lin Kun
 * @create 2020/3/21
 */
@MapperScan("com.kon.cloud.hystrix.payment.dao")
// 激活服务降级
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class HystrixProviderPaymentMain8031 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixProviderPaymentMain8031.class, args);
    }

    /**
     * 此配置是为了服务监控而配置，与服务容错本身无关，springcloud升级后的坑
     * ServletRegistrationBean因为Springboot的默认路径不是"/hystrix.stream"
     * 只要在自己的项目里配置上 下面的servlet就可以了
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}
