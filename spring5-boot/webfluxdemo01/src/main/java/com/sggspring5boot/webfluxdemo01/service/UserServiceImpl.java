package com.sggspring5boot.webfluxdemo01.service;

import com.sggspring5boot.webfluxdemo01.bean.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: UserServiceImpl
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/29 22:42
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService{

    //创建 map 集合存储数据
    private final Map<Integer, User> userMap = new HashMap<>();
    public UserServiceImpl(){
        this.userMap.put(1, new User("Xman", "boy", 44));
        this.userMap.put(2, new User("WuKong", "monkey", 1000));
        this.userMap.put(3, new User("ShenNong","ancient",5000));
    }

    //根据 id 查询
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
    public Mono<Void> addUserInfo(Mono<User> user) {
        return user.doOnNext(person ->{
            //向 map 集合里面放值, id自动加1
            int id = userMap.size() + 1;
            userMap.put(id, person);
        }).thenEmpty(Mono.empty());
    }
}
