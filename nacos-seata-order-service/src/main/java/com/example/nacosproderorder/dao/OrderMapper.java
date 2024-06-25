package com.example.nacosproderorder.dao;

import com.example.nacosproderorder.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/23 11:36
 */
@Mapper
public interface OrderMapper {

    @Insert("insert into  t_order (user_id,commodity_code,count,money) values(#{userId},#{commodityCode},#{count},#{money})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int  insert(Order order);
}
