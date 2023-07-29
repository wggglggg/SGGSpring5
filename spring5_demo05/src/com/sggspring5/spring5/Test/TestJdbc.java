package com.sggspring5.spring5.Test;

import com.sggspring5.spring5.service.BookService;
import com.sggspring5.spring5.bean.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: TestJdbc
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/28 22:04
 * @Version 1.0
 */
public class TestJdbc {

    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private BookService bookService = context.getBean("bookService", BookService.class);
    // 添加一本图书
    @Test
    public void testJdbcTemplate(){


        Book book = new Book(1, "鲁迅合集", 1);

        bookService.addBook(book);
    }

    // 查询库中图书总数量
    @Test
    public void testBookCount(){
        int BookCount = bookService.findBookCount();
        System.out.println("BookCount多少本: = " + BookCount);
    }

    //查询返回对象
    @Test
    public void testFindBookInfo(){
        Book book = bookService.findBookInfo(1);
        System.out.println("book = " + book);
    }

    //查询返回集合
    @Test
    public void testFindAllBook(){
        List<Book> allBook = bookService.findAllBook();
        allBook.forEach(System.out::println);
    }

    //删除
    @Test
    public void testDeleteBook(){
        int count = bookService.deleteBook(3);
        System.out.println("被移除多少本： = " + count);
    }

    //修改
    @Test
    public void testUpdateBook(){
        Book book = new Book(4, "大话西游", 1);
        int count = bookService.updateBook(book);
        System.out.println("修改成功多少本： = " + count);
    }

    //批量添加
    @Test
    public void testBatchAddBook(){
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{5, "窗边的小豆豆", 1});
        batchArgs.add(new Object[]{6, "一行代码学Android", 1});

        bookService.batchAdd(batchArgs);
    }

    // 批量删除
    @Test
    public void testDelBatchBook(){
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[] {5});
        batchArgs.add(new Object[] {6});

        bookService.batchDelBook(batchArgs);
    }

    // 批量修改
    @Test
    public void testUpdateBatchBook(){
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"水浒传", 1, 2});
        batchArgs.add(new Object[]{"康师傅", 1, 6});

        bookService.batchUpdateBook(batchArgs);
    }

}
