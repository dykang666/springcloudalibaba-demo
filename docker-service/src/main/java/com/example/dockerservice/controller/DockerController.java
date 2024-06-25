package com.example.dockerservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/17 12:10
 */
@RestController
public class DockerController {
    @Value("${server.port}")
    private  String serverPort;

    @RequestMapping("/helloDocker")
    public String  helloDocker(){
    return "hello docker,项目端口为:"+serverPort;
    }
}
