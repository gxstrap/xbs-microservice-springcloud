package com.xuebusi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    /*@GetMapping("/findOrdersByUser/{id}")
    public String findOrderByUser() {
        int oid = 123;
        return this.restTemplate.getForObject("http://localhost:7900/order/" + oid, String.class);
    }*/

    /**
     * RestTemplate结合Ribbon实现负载均衡
     * @return
     */
    @GetMapping("/findOrdersByUser/{id}")
    public String findOrderByUser(@PathVariable String id) {
        String result = this.restTemplate.getForObject("http://microservice-eureka-order/order/" + id, String.class);
        return result;
    }
}
