package com.example.customerservice.service;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.example.customerservice.channel.MySource;
import org.apache.rocketmq.common.message.MessageConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * 消息在发送至服务端后，实际业务并不希望消费端马上收到这条消息，而是推迟一段时间后再被消费，这类消息统称为延时消息。
 * 实际上，延时消息可以看成是定时消息的一种特殊用法，其实现的最终效果和定时消息是一致的。
 * @date 2024/6/12 21:06
 */
@Service
public class SenderDelayService {
    private Logger log = LoggerFactory.getLogger(SenderDelayService.class);
    /**
     * spring cloud stream里面发消息通过 Source 发送
     */
    @Autowired
    private MySource source;

    /**
     * 延时消息发送
     *
     * @param message     延时消息体
     * @param delayLevel  延时级别 1~18 (1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h 【 1=1s 2=5s 3=10s】)
     * @param consumerTag 消费者TAG标识 通过TAG区分消费对象
     * @param msgKey      消息key 可以通过该字段再次区分
     * @return
     */
    public boolean sendDelayMsg(String message, int delayLevel, String consumerTag, String msgKey) {
        // 构建消息
        Message<String> messageBuild = MessageBuilder.withPayload(message)
                .setHeader(MessageConst.PROPERTY_TAGS, consumerTag)
                .setHeader(MessageConst.PROPERTY_KEYS, msgKey)
                .setHeader(MessageConst.PROPERTY_DELAY_TIME_LEVEL, delayLevel)
                .build();
        // 发送消息
        boolean sendResult = source.output2().send(messageBuild);
        if (sendResult) {
            log.info("延时消息发送成功-ConsumerTag:{}-MsgKey:{}", consumerTag, msgKey);
            String format = LocalDateTimeUtil.format(LocalDateTimeUtil.now(), "yyyy-MM-dd HH:mm:ss");
            log.info("发送时间:{}",format);
        } else {
            log.error("延时消息发送失败！：tag={}, key={}", consumerTag, msgKey);
        }
        return sendResult;
    }






}
