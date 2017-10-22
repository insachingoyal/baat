package baat.conf.transfer;


import java.util.Arrays;
import java.util.Set;

//TODO Lombok
public class ChatWSMessage {
	//TODO
	private Set<String> recipientUserTokens;
	private String textMessage;

	//TODO
	private byte[] binaryMessage;

	public ChatWSMessage() {
	}

	public ChatWSMessage(final Set<String> recipientUserTokens, final String textMessage, final byte[] binaryMessage) {
		this.recipientUserTokens = recipientUserTokens;
		this.textMessage = textMessage;
		this.binaryMessage = binaryMessage;
	}

	public Set<String> getRecipientUserTokens() {
		return recipientUserTokens;
	}

	public void setRecipientUserTokens(final Set<String> recipientUserTokens) {
		this.recipientUserTokens = recipientUserTokens;
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

		final ChatWSMessage that = (ChatWSMessage) o;

		if (recipientUserTokens != null ? !recipientUserTokens.equals(that.recipientUserTokens) : that.recipientUserTokens != null)
			return false;
		if (textMessage != null ? !textMessage.equals(that.textMessage) : that.textMessage != null)
			return false;
		return Arrays.equals(binaryMessage, that.binaryMessage);
	}

	@Override
	public int hashCode() {
		int result = recipientUserTokens != null ? recipientUserTokens.hashCode() : 0;
		result = 31 * result + (textMessage != null ? textMessage.hashCode() : 0);
		result = 31 * result + Arrays.hashCode(binaryMessage);
		return result;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("ChatWSMessage{");
		sb.append("recipientUserTokens=").append(recipientUserTokens);
		sb.append(", textMessage='").append(textMessage).append('\'');
		sb.append(", binaryMessage=").append(Arrays.toString(binaryMessage));
		sb.append('}');
		return sb.toString();
	}
}