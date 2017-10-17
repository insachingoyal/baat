package baat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
}