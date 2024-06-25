package com.example.seataservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/23 16:12
 */
@FeignClient(name = "seata-order-service" )
public interface OrderRemoteClient {
    @PostMapping("/seata-order-service/createOrder")
    Long  createOrder(@RequestParam("userId")Long userId, @RequestParam("commodityCode")String commodityCode, @RequestParam("count")int count);
}
