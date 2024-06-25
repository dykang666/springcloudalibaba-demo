package com.example.seataservice.controller;

import com.example.seataservice.service.OrderRemoteClient;
import com.example.seataservice.service.StockRemoteClient;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/23 16:11
 */
@Slf4j
@RestController
public class BusinessController {
    @Autowired
    private OrderRemoteClient  orderRemoteClient;
    @Autowired
    private StockRemoteClient  stockRemoteClient;
    @PostMapping("/purchase")
    @GlobalTransactional(timeoutMills = 10000, name = "seata-business-service", rollbackFor = Exception.class)
    public Long  purchase(Long userId, String commodityCode, int count){
        log.info("开始全局事务，XID = " + RootContext.getXID());
        log.info("[采购服务]>------>扣减库存开始");
        stockRemoteClient.deductStorage(commodityCode,count);
        log.info("[采购服务]>------>扣减库存结束");
        log.info("[采购服务]>------>创建订单开始");
        Long orderId =  orderRemoteClient.createOrder(userId,commodityCode,count);
        log.info("[采购服务]>------>创建订单结束");
        throw  new RuntimeException("测试回滚");
        //return orderId;
    }
}
