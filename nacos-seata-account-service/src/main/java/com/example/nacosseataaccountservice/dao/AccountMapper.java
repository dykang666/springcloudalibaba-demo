package com.example.nacosseataaccountservice.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/23 12:55
 */
@Mapper
public interface AccountMapper {
    @Update("update t_account set money=money-#{money} where user_id=#{userId}")
    void deductAccount(@Param("userId") Long userId, @Param("money")Long money);
}
