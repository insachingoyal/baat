package baat.chat.controller;

import baat.conf.transfer.ChatMessage;
import baat.conf.transfer.ChatWSMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class ChatController {

	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public void handleMessage(@RequestBody final ChatMessage chatMessage) throws IllegalAccessException {
		if (!validUserToken(chatMessage.getUserToken())) {
			throw new IllegalAccessException("Invalid user token passed");
		}

		final Set<String> recipientUserTokens = findValidUserTokens(chatMessage.getRecipientUserId());
		final ChatWSMessage chatWSMessage = new ChatWSMessage(recipientUserTokens, chatMessage.getTextMessage(), chatMessage.getBinaryMessage());

		// TODO publish to exchange
		System.out.println(chatMessage);
	}

	private Set<String> findValidUserTokens(final Long recipientUserId) {
		//TODO proper call to user service to get valid tokens
		final Set<String> tokens = new HashSet<>();
		tokens.add(recipientUserId.toString());
		return tokens;
	}

	private boolean validUserToken(final String userToken) {
		// TODO validate user token from user service

		return (userToken != null && !userToken.isEmpty());
	}
}