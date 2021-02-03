package com.zc.sc.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * @作者： zc
 * @时间： 2021/2/3 10:24
 * @描述： 实体类
 */
@Table(name = "user_info")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username; // 用户账户名
    private String password; // 用户密码
    private String realname; // 用户真实名
    private String birthday; // 生日
    private Long gender; // 性别：0->男，1->女
    private String createtime; // 创建时间
    private String updatetime; // 更新时间
}
