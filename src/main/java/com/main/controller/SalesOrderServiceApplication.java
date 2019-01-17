package com.main.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import com.main.util.RibbonConfiguration;

//@EnableBinding(Sink.class) TODO For RabitMq installation problem in TechM PC wor
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "server", configuration = RibbonConfiguration.class)
@ComponentScan({"com.main.controller", "com.main.services"})
@EnableJpaRepositories("com.main.repository")
@EntityScan("com.main.entity")
public class SalesOrderServiceApplication {
	
	/* @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }*/

	/*@StreamListener(target = Sink.INPUT)
	public void processRegisterEmployees(String employee) {
		System.out.println("Employees Registered by Client " + employee);
	}*/
	
	public static void main(String[] args) {
		SpringApplication.run(SalesOrderServiceApplication.class, args);
	}
}
