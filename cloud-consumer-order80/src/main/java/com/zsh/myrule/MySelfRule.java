package com.zsh.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhangsihang
 * @Time 2020/11/6 15:24
 */

//负载均衡:随机
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}

//1.了解负载均衡怎么用:RestTemplate + Ribbon(@LoadBalanced)
//2.修改默认的负载均衡算法:在非@ComponentScan包下(com.zsh.myrule下)创建负载均
// 衡算法,在主启动类增加@RibbonClient
