package com.xuebusi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Value("${clientParam}")
    private String clientParam;

    @RequestMapping("/clientParam")
    public String getParam(){
        return this.clientParam;
    }

    @RequestMapping("hello")
    public String hello() {
        return "Hello Spring Cloud Config!";
    }
}
