package com.example.customerservice.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/9 15:09
 */
@Configuration
public class FeignLogConfig {
    @Bean
    public Logger.Level feignLogLevel(){
        /**
         *   日志级别：
         *   NONE（不记录日志 (默认)）
         *   BASIC（只记录请求方法和URL以及响应状态代码和执行时间）
         *   HEADERS（记录请求和应答的头的基本信息）
         *   FULL（记录请求和响应的头信息，正文和元数据）
         */
        return Logger.Level.FULL;
    }
}
