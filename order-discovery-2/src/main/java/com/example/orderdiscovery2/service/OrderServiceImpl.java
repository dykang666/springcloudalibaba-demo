package com.example.orderdiscovery2.service;

import com.alibaba.fastjson.JSONObject;
import com.example.orderdiscovery2.dao.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/6 15:06
 */
@Service
public class OrderServiceImpl implements OrderSerivce{
    @Autowired
    private OrderMapper orderMapper;
    /*** 
     * @description: 获取订单信息
     * @param: orderNumber 订单号
     * @author  kangdongyang
     * @date: 2024/6/6 15:31
     * @return: 
     */
    @Override
    public String getOrder(String orderNumber) {
        Map map = orderMapper.getOrder(orderNumber);
        return JSONObject.toJSONString(map);
    }
}
