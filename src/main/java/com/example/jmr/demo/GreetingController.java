package com.example.jmr.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class GreetingController {
    private static final String template = "Hello, %s! - %s!!!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name,@RequestParam(value = "lastname", defaultValue = "Earth") String lastname) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name,lastname));
	}

	@PostMapping("/greeting")
	public Greeting postGreeting(@RequestBody Greeting body){
		return new Greeting(counter.incrementAndGet(), body.getContent());
	}
}
