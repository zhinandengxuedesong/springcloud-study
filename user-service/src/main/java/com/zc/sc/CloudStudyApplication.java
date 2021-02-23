package com.zc.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @作者： zc
 * @时间： 2021/2/3 10:20
 * @描述： 启动类
 */

@SpringBootApplication
@EnableDiscoveryClient // 开启EurekaClient功能
@MapperScan(value = {"com.zc.sc.mapper"})
public class CloudStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudStudyApplication.class, args);
    }
}
