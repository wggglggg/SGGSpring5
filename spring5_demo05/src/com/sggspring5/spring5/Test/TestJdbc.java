package com.sggspring5.spring5.Test;

import com.sggspring5.spring5.service.BookService;
import com.sggspring5.spring5.bean.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: TestJdbc
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/28 22:04
 * @Version 1.0
 */
public class TestJdbc {

    @Test
    public void testJdbcTemplate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = context.getBean("bookService", BookService.class);

        Book book = new Book(1, "鲁迅合集", 1);

        bookService.addBook(book);

    }
}
