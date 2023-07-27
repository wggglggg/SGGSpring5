package com.sggspring5.spring5.testdemo;

import com.sggspring5.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: TestSpring5Demo
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/27 20:59
 * @Version 1.0
 */
public class TestSpring5Demo {

    @Test
    public void testService1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

}
