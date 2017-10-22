package baat.chat.controller;

import baat.common.transfer.ChatMessage;
import baat.common.transfer.ChatWSMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

import static baat.chat.application.ChatApplication.CHAT_WS_EXCHANGE_NAME;

@RestController
public class ChatController {

	@Autowired
	private RabbitTemplate wsChatMessagePublisher;

	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public void handleMessage(@RequestBody final ChatMessage chatMessage) throws IllegalAccessException, JsonProcessingException {
		if (!validUserToken(chatMessage.getUserToken())) {
			throw new IllegalAccessException("Invalid user token passed");
		}

		final String rawChatWSMessage = createRawChatWSMessage(chatMessage);

		wsChatMessagePublisher.convertAndSend(CHAT_WS_EXCHANGE_NAME, "", rawChatWSMessage);
	}

	private String createRawChatWSMessage(final ChatMessage chatMessage) throws JsonProcessingException {
		final Set<String> recipientUserTokens = findValidUserTokens(chatMessage.getRecipientUserId());

		final ChatWSMessage chatWSMessage = new ChatWSMessage(recipientUserTokens,
				chatMessage.getTextMessage(), chatMessage.getBinaryMessage());

		final ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(chatWSMessage);
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