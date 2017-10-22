package baat.chat.controller;

import baat.conf.transfer.ChatMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public void handleMessage(@RequestBody final ChatMessage chatMessage) {
		System.out.println(chatMessage);
	}
}