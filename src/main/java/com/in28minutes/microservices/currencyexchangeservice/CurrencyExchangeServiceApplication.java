package com.in28minutes.microservices.currencyexchangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.in28minutes.errorhandler.CustomizedResponseEntityExceptionHandler;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableEurekaClient
public class CurrencyExchangeServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}
	
	@Bean
    public CustomizedResponseEntityExceptionHandler exceptionHandler() {
        return new CustomizedResponseEntityExceptionHandler();
    }
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
