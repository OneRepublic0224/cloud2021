package com.zsh.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhangsihang
 * @Time 2020/11/24 15:24
 */

@Configuration
public class GateWayConfig {

    /**
     * 当访问localhost:9527/qq 时会自动转发到地址 https://qq.com
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator routes(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("route1",
                r -> r.path("/qq").uri("https://qq.com")).build();

        return routes.build();
    }
}
