package com.zc.sc.pojo;

import lombok.Data;

@Data
public class ConsumerUser {
    private Long id;
    private String username; // 用户账户名
    private String password; // 用户密码
    private String realname; // 用户真实名
    private String birthday; // 生日
    private Long gender; // 性别：0->男，1->女
    private String createtime; // 创建时间
    private String updatetime; // 更新时间
}
