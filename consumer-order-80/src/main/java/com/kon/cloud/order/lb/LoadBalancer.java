package com.kon.cloud.order.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author Lin Kun
 * @create 2020/3/22
 */public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
