package com.sggspring5.spring5.test;

import com.sggspring5.spring5.service.AccountService;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * ClassName: JTest4
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/29 21:15
 * @Version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class) //单元测试框架
@ContextConfiguration("classpath:applicationContext.xml")
public class JTest4 {

    @Autowired
    private AccountService accountService;
    @Test
    public void testAccountMoney(){
        accountService.accountMoney();
    }

}
