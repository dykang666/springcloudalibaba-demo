package com.example.customerservice.service;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.LocalDateTimeUtil;
import com.example.customerservice.channel.MySink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/12 21:09
 */
@Service
public class ReceiveDelayService {

    private Logger log = LoggerFactory.getLogger(ReceiveDelayService.class);
    /**
     * spring cloud stream里面通过 Sink 接收消息
     */
    @Autowired
    private MySink sink;

    // 监听定时/延时消息通道，只允许key = delayMsg 通过
    @StreamListener(value = MySink.INPUT2, condition = "headers['ROCKET_KEYS'] == 'delayMsg'")
    public void receiveFixTimeMsg(String payResult, @Headers Map headers) {
        log.info("headers：" + headers);
        String format = LocalDateTimeUtil.format(LocalDateTimeUtil.now(), DatePattern.NORM_DATETIME_PATTERN);
        log.info("接收时间:{}",format);
        log.info("接收到延迟消息：{}", payResult);
    }



}
