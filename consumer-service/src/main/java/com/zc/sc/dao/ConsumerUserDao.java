package com.zc.sc.dao;

import com.zc.sc.pojo.ConsumerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @作者： zc
 * @时间： 2021/2/3 11:14
 * @描述： 通过 RestTemplate 远程查询 user-service 中的接口
 */
@Component
public class ConsumerUserDao {

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    DiscoveryClient discoveryClient;  // spring包下的类

    public ConsumerUser queryUserByIdOne(Long id) {
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//        ServiceInstance instance = instances.get(0);
//        String host = instance.getHost();
//        int port = instance.getPort();
//        return restTemplate.getForObject("http://"+host+":"+port+"/us/user/"+id,ConsumerUser.class);

        return restTemplate.getForObject("http://user-service/us/user/"+id, ConsumerUser.class);
    }
}
