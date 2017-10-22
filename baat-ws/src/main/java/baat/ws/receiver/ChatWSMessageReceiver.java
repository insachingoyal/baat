package baat.ws.receiver;

import baat.common.transfer.ChatWSMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ChatWSMessageReceiver {

	public void receiveMessage(final String rawChatWSMessage) throws IOException {
		final ObjectMapper objectMapper = new ObjectMapper();
		final ChatWSMessage chatWSMessage = objectMapper.readValue(rawChatWSMessage, ChatWSMessage.class);

		System.out.println(chatWSMessage);
	}
}
