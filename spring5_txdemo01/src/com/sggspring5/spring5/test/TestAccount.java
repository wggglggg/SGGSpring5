package com.sggspring5.spring5.test;

import com.sggspring5.spring5.bean.User;
import com.sggspring5.spring5.config.TxConfig;
import com.sggspring5.spring5.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.function.Supplier;

/**
 * ClassName: TestAccount
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/29 15:17
 * @Version 1.0
 */
public class TestAccount {

    // 用注解方式
    @Test
    public void testAccount(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.accountMoney();
    }

    // 全配置文件
    @Test
    public void testAccount2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.accountMoney();

    }

    // 无配置文件方式
    @Test
    public void testAccount3(){

        ApplicationContext context  = new AnnotationConfigApplicationContext(TxConfig.class);

        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.accountMoney();
    }

    //函数式风格创建对象，交给 spring 进行管理
    @Test
    public void testGenericApplicationContext(){
        //1 创建GenericApplicationContext对象
        GenericApplicationContext context = new GenericApplicationContext();
        //2 调用context的方法对象注册
        context.refresh();
        context.registerBean("user", User.class, () -> new User());
        //3 获取在spring注册的对象
        User user = (User) context.getBean("user");
        System.out.println(user);
    }
}
