package com.sggspring5.spring5.DAO.Impl;

import com.sggspring5.spring5.DAO.BookDAO;
import com.sggspring5.spring5.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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

    //添加的方法
    @Override
    public void add(Book book) {
        //1 创建 sql 语句
        String sql = "insert into t_book values(?,?,?)";
        //2 调用方法实现
        /**
         * 有两个参数
         * ⚫ 第一个参数：sql 语句
         * ⚫ 第二个参数：可变参数，设置 sql 语句值
         */
        jdbcTemplate.update(sql, book.getId(), book.getBookName(), book.getBookStatus());
    }

    //查询表记录数
    @Override
    public int selectCount() {

        String sql = "select count(*) from t_book";
        /**
         * 有两个参数
         * ⚫ 第一个参数：sql 语句
         * ⚫ 第二个参数：返回类型 Class
         */
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    // 修改
    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set bookName = ? , bookStatus = ? where id = ?";
        int count = jdbcTemplate.update(sql, book.getBookName(), book.getBookStatus(), book.getId());
        return count;
    }

    //删除
    @Override
    public int deleteBook(int id) {
        String sql = "delete from t_book where id = ?";
        int count = jdbcTemplate.update(sql, id);
        return count;
    }

    //查询返回对象
    @Override
    public Book findBookInfo(int id) {
        String sql = "select * from t_book where id = ?";
        /**
         * 有三个参数
         * ⚫ 第一个参数：sql 语句
         * ⚫ 第二个参数：RowMapper 是接口，针对返回不同类型数据，使用这个接口里面实现类完成
         * 数据封装
         * ⚫ 第三个参数：sql 语句值
         */
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book;
    }

    @Override
    public List<Book> findAllBook() {
        String sql = "select * from t_book";
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;
    }

    // 批量添加
    @Override
    public void batchAddBook(List<Object[]> batchArgs) {
        String sql = "insert into t_book values(?,?,?)";
        int[] counts = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println("添加成功 = " + Arrays.toString(counts));
    }

    // 批量删除
    @Override
    public void batchDelBook(List<Object[]> batchArgs) {
        String sql = "delete from t_book where id = ?";
        int[] count = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println("Arrays.toString(count) = " + Arrays.toString(count));
    }

    // 批量修改
    @Override
    public void batchUpdateBook(List<Object[]> batchArgs) {
        String sql = "update t_book set bookName = ? , bookStatus = ? where id = ?";
        int[] count = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println("Arrays.toString(count) = " + Arrays.toString(count));
    }


}
