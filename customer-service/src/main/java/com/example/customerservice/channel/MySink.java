package com.example.customerservice.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/12 17:10
 */
public interface MySink {
    String INPUT1 = "input1";

    @Input(MySink.INPUT1)
    SubscribableChannel input1();

    String INPUT2 = "input2";

    @Input(MySink.INPUT2)
    SubscribableChannel input2();
}
