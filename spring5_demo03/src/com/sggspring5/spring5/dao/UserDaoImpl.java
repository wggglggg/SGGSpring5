package com.sggspring5.spring5.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserDaoImpl
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/27 20:48
 * @Version 1.0
 */
@Repository(value = "userDaoImpl")
public class UserDaoImpl implements UserDao{

    @Override
    public void add() {
        System.out.println("dao add.....");
    }
}
