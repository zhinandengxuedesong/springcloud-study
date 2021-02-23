package com.zc.sc.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zc.sc.pojo.ConsumerUser;
import com.zc.sc.service.ConsumerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @作者： zc
 * @时间： 2021/2/3 11:21
 * @描述： Controller
 */
@RestController // 相当于 @Controller 和 @ResponseBody
@RequestMapping("consumer")
@DefaultProperties(defaultFallback = "defaultFallback")
public class ConsumerController {
//    @Autowired
//    private ConsumerUserService consumerUserService;
//
//    @GetMapping("{id}")
//    public ConsumerUser queryUserById(@PathVariable("id") Long id) {
//        return this.consumerUserService.queryUserByIdAll(id);
//    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("{id}")
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
//                    value = "3000")
//    })
    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
            })
    public String queryById(@PathVariable("id") Long id) {
        // 逻辑手动指定熔断
        if(id % 2 == 0) {
            throw new RuntimeException("");
        }
        String url = "http://user-service/us/user/" + id;
        String user = restTemplate.getForObject(url, String.class);
        return user;
    }

    public String defaultFallback() {
        return "抱歉，服务器很忙！";
    }
}
