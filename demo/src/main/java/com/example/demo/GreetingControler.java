package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
	public class GreetingControler {
		private static final String template = "Hello, %s!";
		private final AtomicLong counter = new AtomicLong();
		
		// define a GreetingComponent variable without initialization
		private GreetingComponent g;
		// inject/initialize GreetingComponent in the constructor
		
		@Autowired
		public GreetingControler(GreetingComponent g) {
			this.g = g;
		}
		
@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
			return new Greeting(counter.incrementAndGet(), String.format(template,name));
		}

//test the get greeting component
@GetMapping("/testgreeting")
public ResponseEntity<String> getMessage() {
	return ResponseEntity.ok(g.getMessage());
}

//test the post greeting component
@PostMapping("/testgreeting")
public ResponseEntity<String> postMessage() {
	return ResponseEntity.ok(g.postMessage());
}

//test the post greeting component
@PutMapping("/testgreeting")
public ResponseEntity<String> putMessage() {
	return ResponseEntity.ok(g.putMessage());
}

//test the post greeting component
@DeleteMapping("/testgreeting")
public ResponseEntity<String> deleteMessage() {
	return ResponseEntity.ok(g.deleteMessage());
}

}
