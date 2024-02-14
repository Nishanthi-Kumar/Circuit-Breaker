package com.example.circuitbreakermain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyServiceClass {
	@Autowired
	RestTemplate rest;

    private CircuitBreakerFactory circuitBreakerFactory;

    public MyServiceClass(Resilience4JCircuitBreakerFactory circuitBreakerFactory) {
        this.circuitBreakerFactory = circuitBreakerFactory;
    }

    public String performOperation() {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("myCircuitBreaker");

        return circuitBreaker.run(() -> {
        	String Url = "http://localhost:8081/getword";
    		ResponseEntity<String> response1 = rest.exchange(Url, HttpMethod.GET, null, String.class);
    		String word = response1.getBody();
    		
            return word;
        }, throwable -> {
            
            return "Server 2 is up";
        });
    }
}

