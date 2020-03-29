package com.kon.cloud.seata.order.controller;

import com.kon.cloud.common.vo.R;
import com.kon.cloud.common.vo.Result;
import com.kon.cloud.seata.order.entity.Order;
import com.kon.cloud.seata.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Lin Kun
 * @create 2020/3/29
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public Result create(Order order) {
        try {
            order.setStatus(0);
            orderService.create(order);
            return R.ok("创建订单成功");
        } catch (Exception e) {
            e.printStackTrace();
            return R.no("创建订单失败");
        }
    }

}
