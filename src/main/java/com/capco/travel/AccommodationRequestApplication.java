package com.capco.travel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * This class is used to start spring boot application
 * class name MainRequestApplication
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@CrossOrigin(origins="http://localhost:8100")
public class AccommodationRequestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccommodationRequestApplication.class, args);
	}
	
	/*@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET","POST","PUT","DELETE","HEAD")
                .allowedHeaders("header1","header2")
                .allowCredentials(true);
            }
        };
    }*/
}
