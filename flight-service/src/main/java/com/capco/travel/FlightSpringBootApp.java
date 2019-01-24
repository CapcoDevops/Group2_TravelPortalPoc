package com.capco.travel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*import org.springframework.boot.autoconfigure.domain.EntityScan;*/
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
/*import org.springframework.cloud.netflix.feign.FeignClient;*/
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/*@ComponentScan({ "com.capco.travel.controller", "com.capco.travel.service" })*/
/*@EnableJpaRepositories("com.capco.travel.repository")*/
/*@EntityScan("com.capco.travel.model")*/
/*@FeignClient*/
/*@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients*/
//@EnableEurekaClient
public class FlightSpringBootApp {

	/*public static void main(String[] args) {
		SpringApplication.run(FlightSpringBootApp.class, args);
	}*/

}
