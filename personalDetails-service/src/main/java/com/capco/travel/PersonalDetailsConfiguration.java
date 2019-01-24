package com.capco.travel;

import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.capco.travel")
public class PersonalDetailsConfiguration {
     @Bean
	 public AlwaysSampler defaultSampler() {
		 return new AlwaysSampler();
	 }
}
