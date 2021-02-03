package com.zc.sc.controller;

import com.zc.sc.pojo.User;
import com.zc.sc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @作者： zc
 * @时间： 2021/2/3 10:41
 * @描述： 控制层，添加一个对外查询的接口
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/{id}")
    @ResponseBody
    public User selectUser(@PathVariable("id") Long id) {
        User user = userService.queryById(id);
        return user;
    }
}
