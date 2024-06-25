package com.example.nacosconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/19 21:37
 */
@RestController
@RefreshScope
public class NacosConfigController {


    @Value("${verify-url:}")
    private String jwtKey;

    @RequestMapping("testConfig")
    public String testConfig(){
        return jwtKey;
    }
}
