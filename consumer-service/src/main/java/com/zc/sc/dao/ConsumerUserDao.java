package com.zc.sc.dao;

import com.zc.sc.pojo.ConsumerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @作者： zc
 * @时间： 2021/2/3 11:14
 * @描述： 通过 RestTemplate 远程查询 user-service 中的接口
 */
@Component
public class ConsumerUserDao {

    @Autowired
    private RestTemplate restTemplate;

    public ConsumerUser queryUserByIdOne(Long id){
        String url = "http://localhost:8081/us/user/" + id;
        return this.restTemplate.getForObject(url, ConsumerUser.class);
    }
}
