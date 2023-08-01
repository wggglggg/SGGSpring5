package com.sggspring5.webfluxdemo02.service;

import com.sggspring5.webfluxdemo02.bean.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * ClassName: UserService
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/30 9:21
 * @Version 1.0
 */
public interface UserService {

    //根据id查询用户
    Mono<User> getUserById(int id);

    //查询所有用户
    Flux<User> getAllUser();

    //添加用户
    Mono<Void> addUser(Mono<User> user);
}
