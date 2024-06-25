package com.example.customerservice.controller;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.customerservice.service.RemoteFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/7 18:08
 */
@RestController
@RefreshScope
public class CustomerController {
    @Value("${name:}")
    private  String name;
    @Value("${redis.address:}")
    private  String redis;
    @Autowired
    private RemoteFeignClient  remoteFeignClient;

    @GetMapping("/getName")
    public String getName() {
        return name+",redis:{}"+redis;
    }
    @GetMapping("/remoteOpenFeign1")
    public String remoteOpenFeign1(String orderNumber) {
        String orderInfo = remoteFeignClient.getOrderInfo(orderNumber);
        return orderInfo;
    }
    @SentinelResource(value = "hello-Sentinel",blockHandler = "getHelloSentinelBlockHandler")
    @GetMapping("/hello-Sentinel")
    public String helloSentinel() {
        return " hello sentinel";
    }
    /**
     * 处理Sentinel阻塞异常的方法。
     * 当请求被Sentinel框架判定为受限时，会抛出BlockException异常。
     * 本方法旨在捕获此类异常，并返回一个格式化的字符串，包含当前时间及异常信息。
     *
     * @param ex BlockException实例，携带具体的阻塞异常信息。
     * @return 格式化后的字符串，描述了当前时间及异常信息。
     */
    public String getHelloSentinelBlockHandler(BlockException ex) {
        // 获取当前时间并格式化为指定的字符串格式
        String format = LocalDateTimeUtil.format(LocalDateTimeUtil.now(), "yyyy-MM-dd HH:mm:ss");
        // 构造失败信息字符串，包括当前时间和订单编号
        //return "失败,当前时间为:" + format + ",订单编号为:" + orderNumber;
        return "blockHandler：时间{}:+" +format+",错误信息为{}:"+ex;
    }

}
