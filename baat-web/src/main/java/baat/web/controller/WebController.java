package baat.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import static baat.common.constants.Constants.X_AUTH_TOKEN;

@Controller
public class WebController {
	@RequestMapping(value = {"/", "home"})
	public String home(@CookieValue(value = X_AUTH_TOKEN, required = false) final String userToken) {
		if (validUserToken(userToken)) {
			return "home/home.html";
		} else {
			return "login/login.html";
		}
	}

	@RequestMapping(value = "/signup")
	public String signup() {
		return "signup/signup.html";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login/login.html";
	}

	@RequestMapping(value = "/logout")
	public String logout() {
		return "login/logout.html";
	}

	private boolean validUserToken(final String userToken) {
		if (userToken == null || userToken.isEmpty()) {
			return false;
		}

		return false;
	}
}