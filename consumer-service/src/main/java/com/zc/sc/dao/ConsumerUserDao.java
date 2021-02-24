package com.zc.sc.dao;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zc.sc.pojo.ConsumerUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(ConsumerUserDao.class);

//    @Autowired
    private RestTemplate restTemplate;

/*
    @Autowired
    DiscoveryClient discoveryClient;  // spring包下的类
*/

    @HystrixCommand(fallbackMethod = "queryUserByIdFallback")
    public ConsumerUser queryUserByIdOne(Long id){
        long begin = System.currentTimeMillis();
        String url = "http://user-service/us/user/" + id;
        ConsumerUser user = this.restTemplate.getForObject(url, ConsumerUser.class);
        long end = System.currentTimeMillis();
        // 记录访问用时：
        logger.info("访问用时：{}", end - begin);
        return user;
    }

    //这个方法与上面请求的方法返回值类型，参数列表必须一致！！！！！
    public ConsumerUser queryUserByIdFallback(Long id){
        ConsumerUser user = new ConsumerUser();
        user.setId(id);
        user.setUsername("用户信息查询出现异常！");
        return user;
    }

/*    public ConsumerUser queryUserByIdOne(Long id) {
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//        ServiceInstance instance = instances.get(0);
//        String host = instance.getHost();
//        int port = instance.getPort();
//        return restTemplate.getForObject("http://"+host+":"+port+"/us/user/"+id,ConsumerUser.class);

        return restTemplate.getForObject("http://user-service/us/user/"+id, ConsumerUser.class);
    }*/
}
