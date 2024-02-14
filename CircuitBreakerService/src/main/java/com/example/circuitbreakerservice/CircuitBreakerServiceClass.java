package com.example.circuitbreakerservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CircuitBreakerServiceClass {
	@GetMapping(value = "/getword")
	public String getword() {
		return "server 1 is up";
	}

}
