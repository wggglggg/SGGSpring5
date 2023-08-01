package com.sggspring5.webfluxdemo02.service.impl;

import com.sggspring5.webfluxdemo02.bean.User;
import com.sggspring5.webfluxdemo02.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * ClassName: UserServiceImpl
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/30 9:21
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    //创建map集合存储数据
    private final Map<Integer, User> userMap = new HashMap<>();


    public UserServiceImpl(){
        this.userMap.put(1, new User("蔡幸娟", "female", 40));
        this.userMap.put(2, new User("凤飞飞", "female", 50));
        this.userMap.put(3, new User("林晏如", "female", 45));
    }

    //根据id查询
    @Override
    public Mono<User> getUserById(int id) {
        return Mono.justOrEmpty(this.userMap.get(id));
    }

    //查询多个用户
    @Override
    public Flux<User> getAllUser() {
        return Flux.fromIterable(this.userMap.values());
    }

    //添加用户
    @Override
    public Mono<Void> addUser(Mono<User> userMono) {
        return userMono.doOnNext(user -> {
            //向map集合里面放值
                int id = userMap.size() + 1;
                userMap.put(id, user);
        }).thenEmpty(Mono.empty());
    }
}
