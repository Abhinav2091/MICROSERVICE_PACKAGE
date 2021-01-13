package com.in28minutes.microservices.netflixzuulapigatewayserver;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

//Enable Zuul API GATEWAY
@EnableZuulProxy
//Enable it for Naming server Eureka
@EnableDiscoveryClient
@SpringBootApplication
public class NetflixZuulApiGatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
    }

    //creating a bean to trace all the request in sleuth
    @Bean
    public Sampler defaSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

}
