package com.xuebusi.feign.hystrix;

import com.xuebusi.feign.api.IUserServiceApi;
import com.xuebusi.xbs.order.vo.Order;
import org.springframework.stereotype.Component;

@Component
public class UserServiceApiHystrix implements IUserServiceApi {

    @Override
    public Order findOrderById(String id) {
        System.out.println("根据id查询订单服务熔断:" + id);
        Order order = new Order();
        return order;
    }
}
