package com.capco.travel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * This class is used to start spring boot application
 * class name MainRequestApplication
 *  created by Rafik Pinjari
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@CrossOrigin(origins="http://localhost:8100")
public class MainRequestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainRequestApplication.class, args);
	}
}
