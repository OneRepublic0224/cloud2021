package com.zsh.springcloud.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @Author zhangsihang
 * @Time 2021/1/7 16:55
 */

//    GlobalFilter all route(所有路由,本例为GlobalFilter)  常用
//    GateWayFilter specific-route(具体路由)  不常用
//    uri:localhost:9527/payment/get/1?name=zz
@Component
public class MyLogGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        System.out.println("*********MyLogGateWayFilter:" + new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("name");
        System.out.println("*********:" + uname);
        if(uname == null){
            System.out.println("用户名不能为空");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

//    设置filter优先级
    @Override
    public int getOrder() {
        return 0;
    }
}
