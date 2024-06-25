package com.example.seataservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/23 16:28
 */
@FeignClient(name = "seata-stock-service")
public interface StockRemoteClient {
    @PostMapping("/seata-stock-service/deductStorage")
    int deductStorage(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") int count);
}
