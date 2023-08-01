package com.sggspring5.webfluxdemo02.handler;

import com.sggspring5.webfluxdemo02.bean.User;
import com.sggspring5.webfluxdemo02.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;


/**
 * ClassName: UserHandler
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/30 9:32
 * @Version 1.0
 */
public class UserHandler {

    private UserService userService;
    public UserHandler(UserService userService){
        this.userService = userService;
    }

    //根据id查询
    public Mono<ServerResponse> getUserById(ServerRequest request){
        //获取id值
        int id = Integer.valueOf(request.pathVariable("id"));
        //空值处理, 回应不能为空
        Mono<ServerResponse> notFount = ServerResponse.notFound().build();

        //调用service方法得到数据
        Mono<User> userMono = this.userService.getUserById(id);

        //把userMono进行转换返回
        //使用Reactor操作符flatMap
        return userMono.flatMap(user -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                        .body(fromObject(user)))
                .switchIfEmpty(notFount);


    }
    //查询所有
    public Mono<ServerResponse> getAllUsers(ServerRequest request){
        //调用service得到结果
        Flux<User> allUser = this.userService.getAllUser();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(allUser, User.class);
    }
    //添加
    public Mono<ServerResponse> addUser(ServerRequest request){
        //得到user对象
        Mono<User> userMono = request.bodyToMono(User.class);

        return ServerResponse.ok().build(this.userService.addUser(userMono));
    }
}
