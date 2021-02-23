package com.zc.sc.service;

import com.zc.sc.dao.ConsumerUserDao;
import com.zc.sc.pojo.ConsumerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @作者： zc
 * @时间： 2021/2/3 11:18
 * @描述： 循环查询 UserDao 信息
 */
@Service
public class ConsumerUserService {

    @Autowired
    private ConsumerUserDao consumerUserDao;

    public ConsumerUser queryUserByIdAll(Long id){
        return this.consumerUserDao.queryUserByIdOne(id);
    }

}
