package com.example.customerservice.service;

import com.example.customerservice.channel.MySink;
import com.example.customerservice.entity.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.stereotype.Service;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/12 15:38
 */
@Service
public class ReceiveService {
//    @Autowired
//    private Sink sink;
//    @StreamListener(value = Sink.INPUT)
//    public void getListener(String message) {
//        System.out.println("test-group=" + message);
//    }
//
//    @StreamListener(value = MySink.INPUT1)
//    public void listener(Message<byte[]> message) throws UnsupportedEncodingException {
//        System.out.println("headers：" + message.getHeaders());
//        byte[] payload = message.getPayload();
//        System.out.println("接收到的消息：" + new String(payload, "utf-8"));
//    }
        @Value("${server.port}")
        private String port;
    /**
     * spring cloud stream里面通过 Sink 接收消息
     */
    @Autowired
    private MySink mysink;
    private Logger log = LoggerFactory.getLogger(ReceiveService.class);

    /**
     * 接收消息
     *
     * @param message
     */
    @StreamListener(MySink.INPUT1)
    public void listener1(@Payload MessageDto message) {
        log.info("receiver port:{}, test-group1 -- [onMessage][线程编号:{} 消息内容：{}]", port, Thread.currentThread().getId(), message.toString());
    }


//    @StreamListener(value = MySink.INPUT1)
//    public void listener1(String message) {
//        System.out.println("test-group1=" + message);
//        throw new IllegalArgumentException("抛异常"); //模拟异常
//    }


    @StreamListener(value = MySink.INPUT2)
    public void listener2(String message) {
        System.out.println("test-group2=" + message);
    }
    /**
     * 局部异常处理
     * inputChannel格式：${topic-name}.{group-name}.errors
     * 分别对应我们在配置文件配置的destination和group
     *
     * @param message
     */
    @ServiceActivator(inputChannel = "test-topic1.test-group1.errors")
    public void handleError(ErrorMessage message) {
        Throwable throwable = message.getPayload();
        System.out.println("截获异常" + throwable);

        Message<?> originalMessage = message.getOriginalMessage();
        assert originalMessage != null;
        System.out.println("原始消息体 = " + new String((byte[]) originalMessage.getPayload()));
    }

    /**
     * 全局异常处理
     *
     * @param message
     */
    @StreamListener("errorChannel")
    public void error(Message<?> message) {
        ErrorMessage errorMessage = (ErrorMessage) message;
        System.out.println("Handling ERROR: " + errorMessage);
    }





}
