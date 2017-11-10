package baat.user.controller;

import baat.common.transfer.user.SignupRequest;
import baat.common.transfer.user.UserCredentials;
import baat.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/authenticate")
	public String authenticate(@RequestBody final UserCredentials credentials) {
		userService.authenticate(credentials);
		return "OK";
	}

	@RequestMapping("/signup")
	public String signup(@RequestBody final SignupRequest signupRequest) {
		return userService.signup(signupRequest);
	}
}