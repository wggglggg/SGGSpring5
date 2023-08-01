package com.sggspring5.webfluxdemo02.server;

import com.sggspring5.webfluxdemo02.handler.UserHandler;
import com.sggspring5.webfluxdemo02.service.UserService;
import com.sggspring5.webfluxdemo02.service.impl.UserServiceImpl;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.*;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

/**
 * ClassName: route
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/30 9:56
 * @Version 1.0
 */
public class Server {

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.createReactorServer();

        System.out.println("enter to exit");
        System.in.read();
    }

    //1 创建Router路由
    public RouterFunction<ServerResponse> routerFunction(){
        //创建handler对象
        UserService userService = new UserServiceImpl();
        UserHandler handler = new UserHandler(userService);

        //设置路由
        return RouterFunctions.
                route(GET("/user/{id}").and(accept(APPLICATION_JSON)),handler::getUserById)
                .andRoute(GET("/users").and(accept(APPLICATION_JSON)), handler::getAllUsers);

    }

    //2 创建服务器完成适配
    public void createReactorServer(){
        //路由和handler适配
        // 1 获取路由
        RouterFunction<ServerResponse> route = routerFunction();
        // 2 路由绑定HttpHandler
        HttpHandler httpHandler = toHttpHandler(route);
        // 3 生成reactor handler adapter适配器
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);

        //创建服务器并装配适配器在服务器在上
        HttpServer httpServer = HttpServer.create();
        httpServer.handle(adapter).bindNow();
    }
}
