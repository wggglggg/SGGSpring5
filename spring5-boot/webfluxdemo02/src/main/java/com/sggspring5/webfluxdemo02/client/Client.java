package com.sggspring5.webfluxdemo02.client;

import com.sggspring5.webfluxdemo02.bean.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * ClassName: Client
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/30 10:26
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {
        //调用服务器地址
        WebClient webClient = WebClient.create("http://127.0.0.1:63628");

        //根据id查询
        String id = "1";
        User user = webClient.get().uri("/user/{id}", id)
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(User.class)
                .block();
        System.out.println(user.getName());


        //查询所有
        Flux<User> results = webClient.get().uri("/users")
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(User.class);

        results.map(u -> u.getName()).buffer().doOnNext(System.out::println).blockFirst();
    }


}
