package com.example.customerservice.service;

import com.example.customerservice.channel.MySource;
import com.example.customerservice.entity.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/12 15:35
 */
@Service
public class SenderService {

//    /**
//     * spring cloud stream里面发消息通过 Source 发送
//     */
//    @Autowired
//    private Source source;
//    /**
//     * 发送消息的方法
//     *
//     * @param message
//     */
//    public void sendMessage(String message) {
//        boolean send = source.output().send(MessageBuilder.withPayload(message).build());
//        System.out.println(send);
//    }

    /**
     * spring cloud stream里面发消息通过 Source 发送
     */
    @Autowired
    private MySource source1;

    /**
     * 发送消息的方法
     *
     * @param message
     */
    public void sendMessage2(String message) {
        boolean send1 = source1.output1().send(MessageBuilder.withPayload(message).build());
        System.out.println("output1 result : " + send1);
        boolean send2 = source1.output2().send(MessageBuilder.withPayload(message).build());
        System.out.println("output2 result : " + send2);
    }



    /**
     * 发送消息的方法
     *
     * @param message
     */
    public void sendMessage(String message) {
        // 发送 3 条相同 id 的消息
        for (int i = 1; i <= 10; i++) {
            MessageDto messageDto = new MessageDto();
            messageDto.setId(String.valueOf(i));
            messageDto.setMessage(message);
            Message<MessageDto> payload = MessageBuilder.withPayload(messageDto)
                    .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                    .build();
            boolean send1 = source1.output1().send(payload);
            System.out.println("output1 result (第" + i + "条消息): " + send1);
        }

    }
}
