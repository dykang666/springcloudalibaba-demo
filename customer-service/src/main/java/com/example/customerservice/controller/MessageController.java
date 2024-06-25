package com.example.customerservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.customerservice.service.SenderDelayService;
import com.example.customerservice.service.SenderService;
import com.example.customerservice.service.SenderTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/12 15:55
 */
@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private SenderService senderService;
    @RequestMapping("/senderService")
    public String sendNormalMsg(@RequestParam("message") String message) {
        senderService.sendMessage(message);
        return "发送普通消息成功, 流水号：" + UUID.randomUUID().toString().replaceAll("-", "");
    }

    @RequestMapping("/senderService2")
    public String sendNormalMsg2(@RequestParam("message") String message) {
        senderService.sendMessage2(message);
        return "发送普通消息成功, 流水号：" + UUID.randomUUID().toString().replaceAll("-", "");
    }
    //发送带有过滤标签的知识
    @Autowired
    private SenderTagService senderTagService;

    @RequestMapping("/senderTagService")
    public String sendTagMsg(@RequestParam("message") String message) throws Exception {
        JSONObject ss = new JSONObject();
        ss.put("name", "name");
        senderTagService.sendObject(ss, "myTag");
        return "ok";
    }

    @Autowired
    private SenderDelayService senderDelayService;

    @RequestMapping("/sendDelayMsg/{msg}")
    public String sendDelayMsg(@PathVariable("msg") String msg) {
        senderDelayService.sendDelayMsg(msg, 2, "myTag", "delayMsg");
        return "SUCCESS";
    }

}
