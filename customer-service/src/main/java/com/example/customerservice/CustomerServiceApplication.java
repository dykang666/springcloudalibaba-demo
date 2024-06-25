package com.example.customerservice;

import com.example.customerservice.channel.MySink;
import com.example.customerservice.channel.MySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@EnableBinding(value = {Sink.class, Source.class})
@EnableBinding(value = {MySink.class, MySource.class})
/**
 * 记得添加@EnableBinding注解指定消息信道
 * Sink.class 表示信道 input , Source.class 表示信道 output
 * 这两个分别与application.yml中的spring.cloud.stream.bindings.input和spring.cloud.stream.bindings.output对应
 * 如果信道名称换成是sender和receiver，就得配置spring.cloud.stream.bindings.sender和spring.cloud.stream.bindings.receiver
 */
public class CustomerServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(CustomerServiceApplication.class, args);
	}
}