package com.sggspring5.spring5.DAO;

import com.sggspring5.spring5.bean.Book;

import java.util.List;
import java.util.Objects;

/**
 * ClassName: BookDAO
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/28 21:33
 * @Version 1.0
 */
public interface BookDAO {
    void add(Book book);

    //查询表记录数
    int selectCount();

    //修改
    int updateBook(Book book);

    //删除
    int deleteBook(int id);

    //查询返回对象
    Book findBookInfo(int id);

    //查询返回集合
    List<Book>  findAllBook();

    //批量操作
            //批量添加
    void batchAddBook(List<Object[]> batchArgs);

            //删除
    void batchDelBook(List<Object[]> batchArgs);

            //修改
    void batchUpdateBook(List<Object[]> batchArgs);
}
