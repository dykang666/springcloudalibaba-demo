package com.example.nacosproderorder.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/8 15:23
 */
@Component
public class StockRemoteFeignClientFallback implements StockRemoteFeignClient{


    @Override
    public Long selectPrice(@RequestParam("commodityCode")String commodityCode) {
        //打印下异常
        throw new RuntimeException("seata-stock-service服务端异常！");
    }
}
