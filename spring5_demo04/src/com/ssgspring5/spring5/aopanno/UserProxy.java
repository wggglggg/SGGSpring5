package com.ssgspring5.spring5.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * ClassName: UserProxy
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/28 19:08
 * @Version 1.0
 */
@Component
@Aspect
public class UserProxy{

    //前置通知
    //@Before注解表示作为前置通知
    @Before(value = "execution(* com.ssgspring5.spring5.aopanno.User.add(..))")
    public void before(){
        System.out.println("before.........");
    }
}
