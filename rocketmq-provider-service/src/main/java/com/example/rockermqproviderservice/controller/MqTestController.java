package com.example.rockermqproviderservice.controller;

import com.example.rockermqproviderservice.service.MQService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/20 19:56
 */
@RestController
@RequestMapping("/api/mq")
@Slf4j
public class MqTestController {

    @Autowired
    private MQService mqService;


    /**
     * 触发同步发送MQ消息的接口
     *
     * @return 成功时返回确认信息，失败则抛出异常
     */
    @PostMapping("/send")
    public String sendMessageToMQ() {
        try {
            mqService.syncMQMessageSend(); // 调用服务层方法发送消息
            return "Message sent to MQ successfully!";
        } catch (Exception e) {
            // 处理异常，可根据需要自定义异常处理逻辑
            return "Failed to send message to MQ: " + e.getMessage();
        }
    }

    @PostMapping("/async")
    public String asyncSendMessageToMQ() {
        try {
            mqService.asyncMQMessageSend(); // 调用服务层方法发送消息
            return "Message sent to MQ successfully!";
        } catch (Exception e) {
            // 处理异常，可根据需要自定义异常处理逻辑
            return "Failed to send message to MQ: " + e.getMessage();
        }
    }


    @PostMapping("/oneWay")
    public String oneWaySendMessageToMQ() {
        try {
            mqService.oneWaySendMQMessageSend(); // 调用服务层方法发送消息
            return "Message sent to MQ successfully!";
        } catch (Exception e) {
            // 处理异常，可根据需要自定义异常处理逻辑
            return "Failed to send message to MQ: " + e.getMessage();
        }
    }

    @PostMapping("/delayed")
    public String delayedSendMessageToMQ() {
        try {
            mqService.delayedSendMQMessageSend(); // 调用服务层方法发送消息
            return "Message sent to MQ successfully!";
        } catch (Exception e) {
            // 处理异常，可根据需要自定义异常处理逻辑
            return "Failed to send message to MQ: " + e.getMessage();
        }
    }
    /**
     * 过滤消息
     * Tag 过滤
     * Sql 过滤
     * Sql类型语法：
     * 数值比较，比如：>，>=，<，<=，BETWEEN，=；
     * 字符比较，比如：=，<>，IN；
     * IS NULL 或者 IS NOT NULL；
     * 逻辑符号 AND，OR，NOT；
     */
    @PostMapping("/selector")
    public String selectorSendMessageToMQ() {
        try {
            mqService.selectorMQSend(); // 调用服务层方法发送消息
            return "Message sent to MQ successfully!";
        } catch (Exception e) {
            // 处理异常，可根据需要自定义异常处理逻辑
            return "Failed to send message to MQ: " + e.getMessage();
        }
    }

    /**
     * 分布式事物消息
     *生产者需要一个监听自己的类
     */
    @PostMapping("/transaction")
    public String transactionSendMessageToMQ() {
        try {
            mqService.transactionMQMessageSend(); // 调用服务层方法发送消息
            return "Message sent to MQ successfully!";
        } catch (Exception e) {
            // 处理异常，可根据需要自定义异常处理逻辑
            return "Failed to send message to MQ: " + e.getMessage();
        }
    }


    @PostMapping("/orderly")
    public String orderlySendMessageToMQ() {
        try {
            mqService.orderlyMQMessageSend(); // 调用服务层方法发送消息
            return "Message sent to MQ successfully!";
        } catch (Exception e) {
            // 处理异常，可根据需要自定义异常处理逻辑
            return "Failed to send message to MQ: " + e.getMessage();
        }
    }


}

