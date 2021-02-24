package com.zc.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @作者： zc
 * @时间： 2021/2/24 14:46
 * @描述： 启动类，注册服务网关 Zuul
 */

@SpringCloudApplication
@EnableZuulProxy // 开启 Zuul 的网关功能
@EnableDiscoveryClient // 开启 Eureka 客户端发现功能
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
