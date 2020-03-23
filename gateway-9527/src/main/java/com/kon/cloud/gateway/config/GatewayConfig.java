package com.kon.cloud.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lin Kun
 * @create 2020/3/23
 */
//@Configuration
public class GatewayConfig {

    //@Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route",
            r -> r.path("/guonei")
                .uri("http://news.baidu.com/guonei")
        ).build();
        return routes.build();
    }

}
