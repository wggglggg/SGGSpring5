package com.sggspring5.spring5.dao.impl;

import com.sggspring5.spring5.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * ClassName: AccountDAOImpl
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/29 15:11
 * @Version 1.0
 */
@Repository
public class AccountDAOImpl implements AccountDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void addMoney() {
        String sql = "update t_account set money=money+? where userName = ?";
        jdbcTemplate.update(sql, 100, "lucy");
    }

    @Override
    public void reduceMoney() {
        String sql = "update t_account set money=money-? where userName = ?";
        jdbcTemplate.update(sql, 100, "mary");
    }
}
