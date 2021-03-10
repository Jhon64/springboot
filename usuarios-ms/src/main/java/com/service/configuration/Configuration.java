package com.service.configuration;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;

@org.springframework.context.annotation.Configuration
public class Configuration {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	//Eureka
	@Autowired
	@Lazy
	private EurekaClient eurekaClient;
	
	@Value("${spring.application.name}")
	private String appName;

}
