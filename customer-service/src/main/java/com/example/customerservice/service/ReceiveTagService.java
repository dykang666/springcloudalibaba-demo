package com.example.customerservice.service;

import com.example.customerservice.channel.MySink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/12 17:45
 */
@Service
public class ReceiveTagService {

    /**
     * spring cloud stream里面通过 Sink 接收消息
     */
    @Autowired
    private MySink sink;
    /**
     * 只接收myTag标签的消息
     * @param message
     * @param headers
     */
    @StreamListener(value = MySink.INPUT2, condition = "headers['ROCKET_TAGS'] == 'myTag'")
    public void listener2(String message, @Headers Map headers, @Header(name = "ROCKET_TAGS") String name) {
        System.out.println("headers=" + headers);
        System.out.println("name=" + name);
        System.out.println("test-group2=" + message);
    }
}
