package com.example.orderdiscovery.service;

import cn.hutool.core.date.LocalDateTimeUtil;



/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/9 20:39
 */
@Deprecated
public class test {
    public static void main(String[] args) {
        String format = LocalDateTimeUtil.format(LocalDateTimeUtil.now(), "yyyy-MM-dd HH:mm:ss");
        System.out.println(format);
    }
}
