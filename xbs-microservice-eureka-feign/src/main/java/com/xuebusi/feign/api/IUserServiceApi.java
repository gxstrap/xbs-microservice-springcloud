package com.xuebusi.feign.api;

import com.xuebusi.feign.config.FeignConfig;
import com.xuebusi.xbs.order.vo.Order;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "microservice-eureka-order", configuration = FeignConfig.class)
public interface IUserServiceApi {

    @GetMapping("/order/{id}")
    @ResponseBody
    Order findOrderById(@PathVariable("id") String id);
}
