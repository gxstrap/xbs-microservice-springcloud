package com.xuebusi.feign.service;

import com.xuebusi.feign.api.IUserServiceApi;
import com.xuebusi.xbs.order.vo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserServiceApi userServiceApi;

    public Order findOrderById(String id) {
        return userServiceApi.findOrderById(id);
    }

}
