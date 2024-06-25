package com.example.nacosproderorder.service;

import com.example.nacosproderorder.dao.OrderMapper;
import com.example.nacosproderorder.entity.Order;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/22 18:12
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private  StockRemoteFeignClient stockRemoteFeignClient;

    @Autowired
    private  AccountRemoteFeignClient accountRemoteFeignClient;

    @Autowired
    private OrderMapper orderMapper;


    @Override
    public Long createOrder(Long userId, String commodityCode, int count) {
        log.info("Seata全局事务id=================>{}", RootContext.getXID());
        log.info("[订单服务]>------>创建订单开始");
        //计算价格
        Long price = stockRemoteFeignClient.selectPrice(commodityCode);
        Long money = price * count;
        // 创建订单
        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setMoney(money);
        order.setCount(count);
        //插入订单数据
        orderMapper.insert(order);
        // 扣减账户
        log.info("[订单服务]>------>扣减账户开始");
        accountRemoteFeignClient.deductAccount(order.getUserId(), money);
        log.info("[订单服务]>------>扣减账户结束");

        log.info("[订单服务]>------>创建订单结束");
        return  order.getId();

    }
}
