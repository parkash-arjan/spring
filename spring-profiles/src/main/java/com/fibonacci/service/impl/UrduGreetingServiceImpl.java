package com.fibonacci.service.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.fibonacci.service.IGreetingService;

@Service
@Profile(value="urdu")
public class UrduGreetingServiceImpl implements IGreetingService {

	@Override
	public String greet(String greetTo) {
		return "Aadab " + greetTo;

	}
}
