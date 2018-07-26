package com.xuebusi.feign.controller;

import com.xuebusi.feign.service.UserService;
import com.xuebusi.xbs.order.vo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserById/{id}")
    @ResponseBody
    public Order getUserById(@PathVariable("id") String id) {
        return userService.findOrderById(id);
    }
}
