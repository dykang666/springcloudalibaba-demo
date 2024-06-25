package com.example.orderdiscovery.controller;

import com.example.orderdiscovery.service.OrderSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/6 14:50
 */
@RestController

public class OrderController {
    @Autowired
    private OrderSerivce orderSerivce;
    @Value("${server.port}")
    private int port;

    @RequestMapping("/getOrder")
    public String getOrder(String orderNumber) {
        String str = orderSerivce.getOrder(orderNumber);
        return str+"----------服务端口:"+port;
    }


}
