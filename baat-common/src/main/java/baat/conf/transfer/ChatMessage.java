package baat.conf.transfer;

public class ChatMessage {
	private String fromUserToken;
	private String toUserToken;
	private String message;

	public ChatMessage() {
	}

	public ChatMessage(final String fromUserToken, final String toUserToken, final String message) {
		this.fromUserToken = fromUserToken;
		this.toUserToken = toUserToken;
		this.message = message;
	}

	public String getFromUserToken() {
		return fromUserToken;
	}

	public void setFromUserToken(final String fromUserToken) {
		this.fromUserToken = fromUserToken;
	}

	public String getToUserToken() {
		return toUserToken;
	}

	public void setToUserToken(final String toUserToken) {
		this.toUserToken = toUserToken;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}
}