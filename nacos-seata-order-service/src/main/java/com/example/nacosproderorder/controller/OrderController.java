package com.example.nacosproderorder.controller;

import com.example.nacosproderorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/23 16:03
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 创建订单。
     * 通过该接口，可以为指定用户创建一个包含特定商品和数量的订单。
     *
     * @param userId 用户ID，标识订单所属的用户。
     * @param commodityCode 商品代码，标识订单中购买的商品。
     * @param count 商品数量，表示订单中购买的商品数量。
     * @return 返回新创建订单的ID。
     */
    @PostMapping("/createOrder")
    public Long createOrder(Long userId, String commodityCode, int count) {
        return orderService.createOrder(userId, commodityCode, count);
    }
}
