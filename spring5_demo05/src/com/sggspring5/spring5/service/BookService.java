package com.sggspring5.spring5.service;

import com.sggspring5.spring5.DAO.BookDAO;
import com.sggspring5.spring5.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
