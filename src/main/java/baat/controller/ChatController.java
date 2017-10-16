package baat.controller;

import baat.transfer.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

	@MessageMapping("/chat")
	@SendTo("/topic/chat")
	public ChatMessage chat(final ChatMessage message) throws Exception {
		Thread.sleep(1000); // simulated delay
		return new ChatMessage("Hello, " + message.getMessage() + "!");
	}
}
