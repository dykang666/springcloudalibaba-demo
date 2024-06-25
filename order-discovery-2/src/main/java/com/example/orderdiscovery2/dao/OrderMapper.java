package com.example.orderdiscovery2.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;


/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/6 15:14
 */
@Mapper
public interface OrderMapper {
    @Select(" select * from  order_info where order_number =#{orderNumber} ")
    Map getOrder(String orderNumber);
}
