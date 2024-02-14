package com.example.circuitbreakermain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CircuitBreakerMainServiceClass {
	@Autowired
	RestTemplate rest;
    
    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "fallbackMethod")
	public String gettingServiceClass() {
		String Url = "http://localhost:8081/getword";
		ResponseEntity<String> response1 = rest.exchange(Url, HttpMethod.GET, null, String.class);
		String word = response1.getBody();
		return word;

	}
	public String fallbackMethod(Throwable throwable) {
		return "backup service is on";
	}
	
	   


}
