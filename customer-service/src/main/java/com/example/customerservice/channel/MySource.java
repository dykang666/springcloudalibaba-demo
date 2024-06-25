package com.example.customerservice.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/12 17:10
 */
public interface MySource {
    String OUTPUT1 = "output1";
    @Output(MySource.OUTPUT1)
    MessageChannel output1();
    String OUTPUT2 = "output2";
    @Output(MySource.OUTPUT2)
    MessageChannel output2();
}
