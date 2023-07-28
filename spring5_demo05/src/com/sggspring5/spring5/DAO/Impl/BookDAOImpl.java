package com.sggspring5.spring5.DAO.Impl;

import com.sggspring5.spring5.DAO.BookDAO;
import com.sggspring5.spring5.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * ClassName: BookDAOImpl
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/28 21:32
 * @Version 1.0
 */

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Book book) {
        String sql = "insert into t_book values(?,?,?)";
        jdbcTemplate.update(sql, book.getId(), book.getBookName(), book.getBookStatus());
    }
}
