package com.example.rocketmqconsumerservice.Listener;

import com.example.rocketmqconsumerservice.entity.User;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/20 21:06
 */
@RocketMQMessageListener(consumerGroup = "consumer-group-4",topic = "topic4",selectorExpression = "tag1")
public class MQConsumer4  implements RocketMQListener<User> {
    Logger log= LoggerFactory.getLogger(MQConsumer4.class);
    @Override
    public void onMessage(User user) {
        log.info("MQConsumer4 收到user类型消息:{}",user);

    }
}
