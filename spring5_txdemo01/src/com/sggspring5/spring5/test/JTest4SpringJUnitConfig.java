package com.sggspring5.spring5.test;

import com.sggspring5.spring5.service.AccountService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * ClassName: JTest4SpringJUnitConfig
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/29 21:38
 * @Version 1.0
 */
@SpringJUnitConfig(locations = "classpath:applicationContext.xml")
public class JTest4SpringJUnitConfig {

    @Autowired
    private AccountService accountService;

    @Test
    public void testAccountMoney(){
        accountService.accountMoney();
    }
}
