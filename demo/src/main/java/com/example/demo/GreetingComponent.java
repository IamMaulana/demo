package com.example.demo;

import org.springframework.stereotype.Component;
@Component
public class GreetingComponent {
	public String getMessage() {
		return "Hello from GreetingComponent";
}

	public String postMessage() {
		return "Post message from GreetingComponent";
}

	public String putMessage() {
		return "Put message from GreetingComponent";
}

	public String deleteMessage() {
		return "Delete this message from GreetingComponent";
}

}