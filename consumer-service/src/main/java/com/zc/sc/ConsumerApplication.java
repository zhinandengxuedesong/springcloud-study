package com.zc.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @作者： zc
 * @时间： 2021/2/3 11:07
 * @描述： 启动类，注册 spring RestTemplate
 */
@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    //使用 HttpClient 或者 urlConnection 进行远程访问
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
