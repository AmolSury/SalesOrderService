package com.main.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;


@EnableCircuitBreaker
@SpringBootApplication
@ComponentScan({"com.main.controller", "com.main.services"})
@EnableJpaRepositories("com.main.repository")
@EntityScan("com.main.entity")
public class SalesOrderServiceApplication {
	
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

	public static void main(String[] args) {
		SpringApplication.run(SalesOrderServiceApplication.class, args);
	}
}
