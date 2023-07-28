package com.sggspring5.spring5.service;

import com.sggspring5.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserService
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/27 20:46
 * @Version 1.0
 */

// <!-- 开启注解扫描后，可通过注解自动配置 -->
//@Service(value = "userService")
@Service
public class UserService {
    @Value(value = "abc")
    private String name;

    //定义dao类型属性
    //不需要添加set方法
    //添加注入属性注解
//    @Autowired  //根据类型进行注入
//    @Qualifier(value = "userDaoImpl1") //根据名称进行注入
//    private UserDao userDao;

    //@Resource  //根据类型进行注入

    @Autowired   //根据名称进行注入, 优先使用Qualifier
    @Qualifier(value = "userDaoImpl")       // 不能单独使用
    private UserDao userDao;

    public UserService() {
    }


    public void add(){
        System.out.println("service add......." + name);
        userDao.add();

    }
}
