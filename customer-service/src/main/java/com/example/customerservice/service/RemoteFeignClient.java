package com.example.customerservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/7 18:30
 */
@FeignClient(name = "order-provider", fallback = RemoteFeignClientFallback.class)
public interface RemoteFeignClient {
    @GetMapping("/order/getOrder")
    String getOrderInfo(@RequestParam("orderNumber") String orderNumber);
}

