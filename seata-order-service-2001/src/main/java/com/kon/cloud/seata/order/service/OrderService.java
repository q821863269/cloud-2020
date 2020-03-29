package com.kon.cloud.seata.order.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kon.cloud.seata.order.entity.Order;
import com.kon.cloud.seata.order.mapper.OrderMapper;
/**
 * @author Lin Kun
 * @create 2020/3/29
 */
@Slf4j
@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> {

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    // 创建订单
    @GlobalTransactional(name = "create-order", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("开始新建订单。。。");
        this.baseMapper.insert(order);

        log.info("订单微服务开始调用库存，做扣减start。。。");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("订单微服务开始调用库存，做扣减end。。。");

        log.info("订单微服务开始调用账户，做扣减start。。。");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("订单微服务开始调用账户，做扣减end。。。");

        log.info("修改订单状态start。。。");
        order.setStatus(1);
        this.baseMapper.update(order,
            new UpdateWrapper<Order>().lambda()
                .eq(Order::getUserId, order.getUserId())
                .eq(Order::getStatus, 0));
        log.info("修改订单状态end。。。");

        log.info("下订单成功~。~");
    }

}
