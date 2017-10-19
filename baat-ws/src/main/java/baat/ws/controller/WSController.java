package baat.ws.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WSController {

	@RequestMapping("/")
	public String index() {
		return "WebSockets Rule!";
	}
}