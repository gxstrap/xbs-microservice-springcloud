package com.xuebusi.controller;

import com.xuebusi.util.ServiceInfoUtil;
import com.xuebusi.xbs.order.vo.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    /**
     * 测试
     * @param id
     * @return
     */
    @GetMapping("/order/{id}")
    @ResponseBody
    public Order findOrderById(@PathVariable String id) {
        //模拟异常测试Hystrix短路器
        //int i = 1/0;
        Order order = new Order();
        try {
            order.setId("123");
            order.setPrice(23.5);
            order.setReceiverAddress("北京");
            order.setReceiverName("张三");
            order.setReceiverPhone("13966678766");
            System.out.println("[机器端口:" + ServiceInfoUtil.getPort() + "][" + order.toString() + "]");
        } catch (Exception e) {
            System.out.println("=================findOrderById方法调用异常:" + e.toString());
        }
        return order;
    }
}
