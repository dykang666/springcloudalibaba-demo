package com.example.rocketmqconsumerservice.Listener;

import com.example.rocketmqconsumerservice.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/20 19:38
 */
@Component
@RocketMQMessageListener(consumerGroup = "consumer-group-10",topic = "topic10",
        selectorExpression = "age = 9",selectorType = SelectorType.SQL92)
@Slf4j
public class MQConsumer10 implements RocketMQListener<User> {

    @Override
    public void onMessage(User user) {
        log.info("consumer-group-10 收到user类型消息:{}",user);
    }
}
