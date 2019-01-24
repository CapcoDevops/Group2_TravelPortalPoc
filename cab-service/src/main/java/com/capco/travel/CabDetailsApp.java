package com.capco.travel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/*@SpringBootApplication
@ComponentScan({"com.capco.travel.controller","com.capco.travel.service"})
@EnableJpaRepositories("com.capco.travel.repo")
@EntityScan("com.capco.travel.model")
@EnableDiscoveryClient
@EnableEurekaClient*/
public class CabDetailsApp {

	/*public static void main(String[] args) {
		SpringApplication.run(CabDetailsApp.class, args);
	}*/
}
