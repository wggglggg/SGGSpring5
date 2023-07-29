package com.sggspring5.spring5.service;

import com.sggspring5.spring5.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName: AccountService
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/29 15:15
 * @Version 1.0
 */
@Service
// 只读:否, 连接等待:不等待, 通知:调用未开启的事务方法,就将它加入本事务, 隔离:可重读(mysql8 默认)
@Transactional(readOnly = false, timeout = -1, propagation = Propagation.REQUIRED,
isolation = Isolation.REPEATABLE_READ)
public class AccountService {

    //注入dao
    @Autowired
    private AccountDAO accountDAO;

    public void accountMoney(){
        accountDAO.addMoney();

        int a = 10 / 0;             // 模拟出现状况,测试事务运行情况
        accountDAO.reduceMoney();
    }
}
