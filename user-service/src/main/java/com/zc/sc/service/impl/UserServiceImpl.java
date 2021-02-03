package com.zc.sc.service.impl;

import com.zc.sc.mapper.UserMapper;
import com.zc.sc.pojo.User;
import com.zc.sc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @作者： zc
 * @时间： 2021/2/3 10:36
 * @描述： 服务层接口实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
