package com.example.nginxservice2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/15 19:00
 */
@RestController
@RequestMapping("/nginx")
public class NginxController {
    @Value("${server.port}")
    private  String serverPort;
    @RequestMapping("/test")
    public String test() {
        return "hello nginx!,当前项目端口为:"+serverPort;
    }
}
