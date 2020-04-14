package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.example.demo.config.RibbonConfiguration;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@RibbonClient(name="order-service",configuration=RibbonConfiguration.class)
public class SpringbootfeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootfeignApplication.class, args);
	}

}
