package com.example.nacosproderstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosProderStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosProderStockApplication.class, args);
	}

}
