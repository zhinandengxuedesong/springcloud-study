package com.zc.sc.service;

import com.zc.sc.pojo.User;

/**
 * @作者： zc
 * @时间： 2021/2/3 10:34
 * @描述： 服务层接口类
 */
public interface UserService {
    public User queryById(Long id);
}
