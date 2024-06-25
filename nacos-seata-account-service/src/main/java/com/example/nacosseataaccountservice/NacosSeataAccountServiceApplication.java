package com.example.nacosseataaccountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosSeataAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosSeataAccountServiceApplication.class, args);
    }

}
