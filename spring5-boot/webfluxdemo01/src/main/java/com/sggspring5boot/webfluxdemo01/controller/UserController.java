package com.sggspring5boot.webfluxdemo01.controller;

import com.sggspring5boot.webfluxdemo01.bean.User;
import com.sggspring5boot.webfluxdemo01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * ClassName: UserController
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/30 8:54
 * @Version 1.0
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    //id查询
    @GetMapping("/user/{id}")
    public Mono<User> getUserId(@PathVariable int id){
        return userService.getUserById(id);
    }

    //查询所有
    @GetMapping("/alluser")
    public Flux<User> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping("/adduser")
    //添加
    public Mono<Void> addUser(@RequestBody User user){
        Mono<User> userMono = Mono.just(user);
        return userService.addUserInfo(userMono);
    }
}
