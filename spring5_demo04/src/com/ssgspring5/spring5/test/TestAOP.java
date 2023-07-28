package com.ssgspring5.spring5.test;

import com.ssgspring5.spring5.aopanno.User;
import com.ssgspring5.spring5.aopxml.Book;
import com.ssgspring5.spring5.config.ConfigAOP;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: TestAOP
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/28 19:17
 * @Version 1.0
 */
public class TestAOP {

    @Test
    public void testAOPAnno(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        User user = context.getBean("user", User.class);
        user.add();
    }

    @Test
    public void testXML(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        Book book = context.getBean("book", Book.class);
        book.buy();
    }

    @Test
    public void testConfig(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigAOP.class);

        User user = context.getBean("user", User.class);
        user.add();
    }
}
