package com.example.customerservice.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/8 15:23
 */
@Component
public class RemoteFeignClientFallback implements RemoteFeignClient{

    public String getOrderInfo(@RequestParam("orderNumber")String orderNumber) {
            // 自定义错误处理逻辑，可以根据cause打印日志或返回特定的错误信息
            return "Order service is unavailable";
        }

}
