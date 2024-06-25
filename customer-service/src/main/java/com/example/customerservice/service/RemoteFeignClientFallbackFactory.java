package com.example.customerservice.service;

import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/8 15:12
 */
@Deprecated
public class RemoteFeignClientFallbackFactory implements FallbackFactory<RemoteFeignClient> {
    public RemoteFeignClient create(Throwable cause) {
        return new RemoteFeignClient() {
            public String getOrderInfo(String orderNumber) {
                // 自定义错误处理逻辑，可以根据cause打印日志或返回特定的错误信息
                return "Order service is unavailable";
            }
        };
    }
}