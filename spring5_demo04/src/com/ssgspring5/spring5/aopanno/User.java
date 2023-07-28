package com.ssgspring5.spring5.aopanno;

import org.springframework.stereotype.Component;

/**
 * ClassName: User
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/28 19:07
 * @Version 1.0
 */
@Component
public class User {
    public void add(){
        System.out.println("add.......");
    }
}
