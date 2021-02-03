package com.zsh.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @Author zhangsihang
 * @Time 2020/11/11 09:57
 */

//    1.Hystrix的fallback(兜底方法)在需要降级的方法上加@HystrixCommand注解,
//      fallback方法的参数要和需要降级的方法参数保持一致
//    2.hystrix可以放在provider端,也可以放在consumer端,但是配置不同


@EnableCircuitBreaker
@SpringBootApplication
@EnableEurekaClient
public class PaymentHystrixMain8003 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8003.class, args);
    }

    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
