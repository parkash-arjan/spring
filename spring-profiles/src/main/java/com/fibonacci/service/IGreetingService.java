package com.fibonacci.service;

import org.springframework.stereotype.Service;

@Service
public interface IGreetingService {

	public String greet(String greetTo);

}
