package com.example.rocketmqconsumerservice.Listener;

import com.example.rocketmqconsumerservice.entity.User;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/20 20:33
 */
@Component
@RocketMQMessageListener(consumerGroup = "consumer-group-3",topic = "topic3",selectorExpression = "tag1")
public class MQAsyncConsumer3 implements RocketMQListener<User> {
    Logger log= LoggerFactory.getLogger(MQAsyncConsumer3.class);

    @Override
    public void onMessage(User user) {
        log.info("MQAsyncConsumer consumer-3 收到user类型消息:{}",user);
    }
}
