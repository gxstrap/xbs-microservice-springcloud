package com.xuebusi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 注解 @EnableCircuitBreaker 开启断路器
 */
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class EurekaUserHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaUserHystrixApplication.class, args);
	}

	/**
	 * 实例化 RestTemplate 用户调用Http服务
	 * @return
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
