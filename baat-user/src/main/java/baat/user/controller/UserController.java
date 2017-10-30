package baat.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping("/authenticate")
	public String index() {
		return "Greetings from Spring Boot!";
	}
}