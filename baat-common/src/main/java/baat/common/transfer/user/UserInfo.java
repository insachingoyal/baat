package baat.common.transfer.user;

import java.util.Arrays;

public class UserInfo {

	private String name;
	private String email;
	private byte[] avatar;

	public UserInfo() {
	}

	public UserInfo(final String name, final String email, final byte[] avatar) {
		this.name = name;
		this.email = email;
		this.avatar = avatar;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(final byte[] avatar) {
		this.avatar = avatar;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		final UserInfo userInfo = (UserInfo) o;

		if (name != null ? !name.equals(userInfo.name) : userInfo.name != null)
			return false;
		if (email != null ? !email.equals(userInfo.email) : userInfo.email != null)
			return false;
		return Arrays.equals(avatar, userInfo.avatar);
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + Arrays.hashCode(avatar);
		return result;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("User{");
		sb.append("name='").append(name).append('\'');
		sb.append(", email='").append(email).append('\'');
		sb.append(", avatar=").append(Arrays.toString(avatar));
		sb.append('}');
		return sb.toString();
	}
}
