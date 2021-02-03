package com.zc.sc.controller;

import com.zc.sc.pojo.ConsumerUser;
import com.zc.sc.service.ConsumerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @作者： zc
 * @时间： 2021/2/3 11:21
 * @描述： Controller
 */
@RestController // 相当于 @Controller 和 @ResponseBody
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private ConsumerUserService consumerUserService;

    @GetMapping("{id}")
    public ConsumerUser queryUserById(@PathVariable("id") Long id) {
        return this.consumerUserService.queryUserByIdAll(id);
    }
}
