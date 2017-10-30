package baat.user.controller;

import baat.common.transfer.user.UserCredentials;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping("/authenticate")
	public String authenticate(@RequestBody final UserCredentials credentials) {
		return "Greetings from Spring Boot!";
	}
}