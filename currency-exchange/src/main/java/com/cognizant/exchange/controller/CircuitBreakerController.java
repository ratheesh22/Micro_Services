package com.cognizant.exchange.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	Logger logger=LoggerFactory.getLogger(CircuitBreakerController.class);
	//@Retry(name = "circuit-breaker",fallbackMethod ="backupMethod" )
	@GetMapping("/circuit-breaker")
	@CircuitBreaker(name = "circuit-breaker",fallbackMethod ="backupMethod")
	//@RateLimiter(name = "",fallbackMethod = "")
	//@Bulkhead(name = "",fallbackMethod = "")
	public String connectToDummyURL() {
		logger.info("calling connectToDummyURL");
		ResponseEntity<String> entity=new RestTemplate()
				.getForEntity("localhost:3898/dummy-url", String.class);
		return entity.getBody();
	}
	
	public String backupMethod(Exception e) {
		return "backupMethod called by circuit breaker resilence 4J";
	}

}
