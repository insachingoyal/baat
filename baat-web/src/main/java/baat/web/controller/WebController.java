package baat.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import static baat.common.constants.Constants.X_AUTH_TOKEN;

@Controller
public class WebController {
	@RequestMapping(value = "/")
	public String index(@RequestHeader(value = X_AUTH_TOKEN) final String userToken) {
		if (validUserToken(userToken)) {
			return "home/home.html";
		} else {
			return "login/login.html";
		}
	}

	private boolean validUserToken(final String userToken) {
		return false;
	}
}