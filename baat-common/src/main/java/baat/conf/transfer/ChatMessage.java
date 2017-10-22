package baat.conf.transfer;


import java.util.Arrays;

//TODO Lombok
public class ChatMessage {
	private String userToken;

	//TODO
	private Long recipientChannelId;

	private Long recipientUserId;
	private String textMessage;

	//TODO
	private byte[] binaryMessage;

	public ChatMessage() {
	}

	public ChatMessage(final String userToken, final Long recipientChannelId, final Long recipientUserId, final String textMessage, final byte[] binaryMessage) {
		this.userToken = userToken;
		this.recipientChannelId = recipientChannelId;
		this.recipientUserId = recipientUserId;
		this.textMessage = textMessage;
		this.binaryMessage = binaryMessage;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(final String userToken) {
		this.userToken = userToken;
	}

	public Long getRecipientChannelId() {
		return recipientChannelId;
	}

	public void setRecipientChannelId(final Long recipientChannelId) {
		this.recipientChannelId = recipientChannelId;
	}

	public Long getRecipientUserId() {
		return recipientUserId;
	}

	public void setRecipientUserId(final Long recipientUserId) {
		this.recipientUserId = recipientUserId;
	}

	public String getTextMessage() {
		return textMessage;
	}

	public void setTextMessage(final String textMessage) {
		this.textMessage = textMessage;
	}

	public byte[] getBinaryMessage() {
		return binaryMessage;
	}

	public void setBinaryMessage(final byte[] binaryMessage) {
		this.binaryMessage = binaryMessage;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		final ChatMessage that = (ChatMessage) o;

		if (userToken != null ? !userToken.equals(that.userToken) : that.userToken != null)
			return false;
		if (recipientChannelId != null ? !recipientChannelId.equals(that.recipientChannelId) : that.recipientChannelId != null)
			return false;
		if (recipientUserId != null ? !recipientUserId.equals(that.recipientUserId) : that.recipientUserId != null)
			return false;
		if (textMessage != null ? !textMessage.equals(that.textMessage) : that.textMessage != null)
			return false;
		return Arrays.equals(binaryMessage, that.binaryMessage);
	}

	@Override
	public int hashCode() {
		int result = userToken != null ? userToken.hashCode() : 0;
		result = 31 * result + (recipientChannelId != null ? recipientChannelId.hashCode() : 0);
		result = 31 * result + (recipientUserId != null ? recipientUserId.hashCode() : 0);
		result = 31 * result + (textMessage != null ? textMessage.hashCode() : 0);
		result = 31 * result + Arrays.hashCode(binaryMessage);
		return result;
	}


	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("ChatMessage{");
		sb.append("userToken='").append(userToken).append('\'');
		sb.append(", recipientChannelId=").append(recipientChannelId);
		sb.append(", recipientUserId=").append(recipientUserId);
		sb.append(", textMessage='").append(textMessage).append('\'');
		sb.append(", binaryMessage=").append(Arrays.toString(binaryMessage));
		sb.append('}');
		return sb.toString();
	}
}