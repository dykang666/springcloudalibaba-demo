package com.example.nacosproderstock.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/23 11:04
 */
@Mapper
public interface StorageMapper {
    @Select(" select  price from t_storage where  commodity_code=#{commodityCode}")
    Long selectPrice(@Param("commodityCode")String commodityCode);

    @Update("update t_storage set count=count-#{countNew} where commodity_code=#{commodityCode}")
    void deductStorage(@Param("commodityCode")String commodityCode, @Param("countNew")int countNew);
}
