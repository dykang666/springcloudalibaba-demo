package com.example.nacosproderorder.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/23 11:17
 */
@FeignClient(name = "seata-stock-service", fallback = StockRemoteFeignClientFallback.class)
public interface StockRemoteFeignClient {

    @GetMapping("/seata-stock-service/selectPrice")
    Long  selectPrice(@RequestParam("commodityCode") String  commodityCode);
}
