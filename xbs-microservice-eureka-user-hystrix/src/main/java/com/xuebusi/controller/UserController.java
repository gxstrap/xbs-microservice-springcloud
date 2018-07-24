package com.xuebusi.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 使用 Ribbon 进行负载均衡
     * 使用 Hystrix 作为断路器
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallbackInfo")
    @GetMapping("/findOrdersByUser/{id}")
    public String findOrderByUser(@PathVariable String id) {
        // 模拟方法抛出异常,测试断路器功能
        //int i =1/0;
        String result = this.restTemplate.getForObject("http://microservice-eureka-order/order/" + id, String.class);
        return result;
    }

    /**
     * 当调用上面的 findOrderByUser 方法异常时，会回调该方法
     *
     * @param id
     * @return
     */
    public String fallbackInfo(@PathVariable String id) {
        return "服务器开小差，请稍后再试";
    }
}
