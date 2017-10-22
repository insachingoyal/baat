package baat.conf.transfer;

public class ChatMessage {
	private String userToken;
	private String message;

	public ChatMessage(final String userToken, final String message) {
		this.userToken = userToken;
		this.message = message;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(final String userToken) {
		this.userToken = userToken;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}
}
