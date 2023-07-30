package com.sggspring5boot.webfluxdemo01.service;

import com.sggspring5boot.webfluxdemo01.bean.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * ClassName: UserService
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/29 22:42
 * @Version 1.0
 */
public interface UserService {

    //根据 id 查询用户
    Mono<User> getUserById(int id);
    //查询所有用户
    Flux<User> getAllUser();
    //添加用户
    Mono<Void> addUserInfo(Mono<User> user);
}
