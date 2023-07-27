package com.sggspring5.spring5.testdemo;

import com.sggspring5.spring5.bean.Book;
import com.sggspring5.spring5.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: TestSpring5
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/27 10:50
 * @Version 1.0
 */
public class TestSpring5 {

    @Test
    public void testAdd(){
     ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        User user = context.getBean("user", User.class);
        System.out.println("user = " + user);
        user.add();
    }

    @Test
    public void testBook1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Book book = context.getBean("book", Book.class);

        System.out.println("book = " + book);
        System.out.println(book.toString());
    }
}
