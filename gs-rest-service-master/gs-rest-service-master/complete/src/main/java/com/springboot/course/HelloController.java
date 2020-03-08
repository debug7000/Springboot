package com.springboot.course;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.Greeting;

@RestController
public class HelloController {
	
	private static final String template = "Hello, %s!";
	private static final String template2 = "Hello-jee, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/hello")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@GetMapping("/greeting")
	public Greeting greeting2(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template2, name));
	}

}
