package baat.transfer;

import java.io.Serializable;

public class ChatMessage implements Serializable {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	public ChatMessage(final String message) {
		this.message = message;
	}

	public ChatMessage() {

	}
}
