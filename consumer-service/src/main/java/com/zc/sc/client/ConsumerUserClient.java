package com.zc.sc.client;

import com.zc.sc.client.impl.ConsumerUserClientFallback;
import com.zc.sc.config.FeignConfig;
import com.zc.sc.pojo.ConsumerUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @作者： zc
 * @时间： 2021/2/24 10:18
 * @描述： Feign 的客户端,指定熔断回滚
 */

//@FeignClient("user-service")
@FeignClient(
        value = "user-service",
        fallback = ConsumerUserClientFallback.class,
        configuration = FeignConfig.class)
public interface ConsumerUserClient {
    // String url = "http://user-service/us/user/" + id
    @GetMapping("us/user/{id}")
    ConsumerUser queryUserById(@PathVariable("id") Long id);
}
