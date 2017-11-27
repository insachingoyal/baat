package baat.user.controller;

import baat.common.transfer.user.SignupRequest;
import baat.common.transfer.user.UserCredentials;
import baat.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@CrossOrigin
	@RequestMapping(value = "/authenticate", method = PUT)
	public String authenticate(@RequestBody final UserCredentials credentials) {
		return userService.authenticate(credentials);
	}

	@CrossOrigin
	@RequestMapping(value = "/signup", method = PUT)
	public String signup(@RequestBody final SignupRequest signupRequest) {
		return userService.signup(signupRequest);
	}

	@CrossOrigin
	@RequestMapping(value = "/validateUserToken/{userToken}", method = GET)
	public boolean validateUserToken(@PathVariable("userToken") final String userToken) {
		return userService.validateUserToken(userToken);
	}
}