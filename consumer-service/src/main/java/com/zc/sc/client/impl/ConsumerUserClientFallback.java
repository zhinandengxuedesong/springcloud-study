package com.zc.sc.client.impl;

import com.zc.sc.client.ConsumerUserClient;
import com.zc.sc.pojo.ConsumerUser;
import org.springframework.stereotype.Component;

/**
 * @作者： zc
 * @时间： 2021/2/24 11:06
 * @描述： Feign 的客户端实现类，Fallback 回滚
 */

@Component
public class ConsumerUserClientFallback implements ConsumerUserClient {
    @Override
    public ConsumerUser queryUserById(Long id) {
        ConsumerUser user = new ConsumerUser();
        user.setId(id);
        user.setRealname("用户查询出现异常！");
        return user;
    }
}
