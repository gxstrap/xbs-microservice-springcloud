package com.xuebusi.controller;

import com.xuebusi.po.Order;
import com.xuebusi.util.ServiceInfoUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping("/order/{id}")
    public String findOrderById(@PathVariable String id) {
        int i = 1/0;
        Order order = new Order();
        order.setId("123");
        order.setPrice(23.5);
        order.setReceiverAddress("北京");
        order.setReceiverName("张三");
        order.setReceiverPhone("13966678766");
        String result = "[机器端口:" + ServiceInfoUtil.getPort() + "][" + order.toString() + "]";
        System.out.println(result);
        return result;
    }
}
