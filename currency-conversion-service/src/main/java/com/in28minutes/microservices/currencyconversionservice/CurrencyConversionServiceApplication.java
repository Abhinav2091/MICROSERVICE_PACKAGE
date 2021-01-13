package com.in28minutes.microservices.currencyconversionservice;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
//value contain package name for feign client
@EnableFeignClients("com.in28minutes.microservices.currencyconversionservice")
//annotation to register it in Naming server
@EnableDiscoveryClient
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}

	//creating a bean to trace all the request in sleuth
	@Bean
	public Sampler defaSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
