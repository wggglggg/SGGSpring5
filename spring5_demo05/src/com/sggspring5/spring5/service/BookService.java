package com.sggspring5.spring5.service;

import com.sggspring5.spring5.DAO.BookDAO;
import com.sggspring5.spring5.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: BookService
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/28 21:58
 * @Version 1.0
 */
@Service
public class BookService {

    @Autowired
    private BookDAO bookDAO;

    public void addBook(Book book){
        bookDAO.add(book);
    }

    //查询返回数据个数
    public int findBookCount(){
        int count = bookDAO.selectCount();
        return count;
    }

    //查询返回对象
    public Book findBookInfo(int id){
        return bookDAO.findBookInfo(id);
    }

    //查询返回集合
    public List<Book> findAllBook(){
        return bookDAO.findAllBook();
    }

    //修改
    public int updateBook(Book book){
        return bookDAO.updateBook(book);
    }

    //删除
    public int deleteBook(int id){
        return bookDAO.deleteBook(id);
    }

    //批量添加
    public void batchAdd(List<Object[]> batchArgs){
        bookDAO.batchAddBook(batchArgs);
    }

    // 批量删除
    public void batchDelBook(List<Object[]> batchArgs){
        bookDAO.batchDelBook(batchArgs);
    }

    // 批量修改
    public void batchUpdateBook(List<Object[]> batchArgs){
        bookDAO.batchUpdateBook(batchArgs);
    }

}
