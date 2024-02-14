package com.example.circuitbreakermain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerMainControllerClass {
	@Autowired
	private CircuitBreakerMainServiceClass myservice;
	@Autowired
	private MyServiceClass myserviceclass;
	
	@GetMapping(value="/gettingService")
	 public String invokeService() {
        return myserviceclass.performOperation();
    }

}
