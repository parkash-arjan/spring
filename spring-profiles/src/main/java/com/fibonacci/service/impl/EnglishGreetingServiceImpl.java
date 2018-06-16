package com.fibonacci.service.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.fibonacci.service.IGreetingService;

@Service
@Profile(value="english")
public class EnglishGreetingServiceImpl implements IGreetingService {
	@Override
	public String greet(String greetTo) {
		return "Hello " + greetTo;

	}
}
