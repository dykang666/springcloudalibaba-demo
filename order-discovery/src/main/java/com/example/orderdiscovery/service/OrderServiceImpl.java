package com.example.orderdiscovery.service;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSONObject;
import com.example.orderdiscovery.dao.OrderMapper;
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
    private static final Log log = LogFactory.get(OrderServiceImpl.class);
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
    @SentinelResource(value = "getOrder",blockHandler = "getOrderBlockHandler")
    public String getOrder(String orderNumber) {
        Map map = orderMapper.getOrder(orderNumber);
        return JSONObject.toJSONString(map);
    }


    /**
     * 处理订单块的异常情况。
     * 当订单处理遇到异常时，此方法用于生成一个包含当前时间和服务端订单号的错误信息。
     *
     * @param orderNumber 订单编号，用于标识哪个订单发生了错误。
     * @param ex 抛出的异常，记录了错误的详细信息。
     * @return 返回一个字符串，包含当前时间、订单编号和失败的标记信息。
     */
    public String getOrderBlockHandler(String orderNumber, BlockException ex) {
        // 获取当前时间并格式化为指定的字符串格式
        String format = LocalDateTimeUtil.format(LocalDateTimeUtil.now(), "yyyy-MM-dd HH:mm:ss");
        // 构造失败信息字符串，包括当前时间和订单编号
        //return "失败,当前时间为:" + format + ",订单编号为:" + orderNumber;
        log.error( "blockHandler：" + orderNumber,format, ex);
        return "blockHandler：时间{}:+" +format+",订单编号为{}:"+ orderNumber+",错误信息为{}:"+ex;
    }

}
