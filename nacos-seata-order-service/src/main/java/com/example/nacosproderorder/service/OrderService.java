package com.example.nacosproderorder.service;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/22 18:12
 */
public interface OrderService {
    Long createOrder(Long userId, String commodityCode, int count);
}
