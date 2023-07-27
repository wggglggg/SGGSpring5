package com.sggspring5.spring5.service;

import org.springframework.stereotype.Service;

/**
 * ClassName: UserService
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/27 20:46
 * @Version 1.0
 */

// <!-- 开启注解扫描后，可通过注解自动配置 -->
//@Service(value = "userService")
@Service
public class UserService {

    public void add(){
        System.out.println("service add.......");
    }
}
