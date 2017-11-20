package baat.common.transfer.user;

public class UserInfo {
	private String email;
	private String name;
	private String avatarUrl;

	public UserInfo() {
	}

	public UserInfo(final String email, final String name, final String avatarUrl) {
		this.email = email;
		this.name = name;
		this.avatarUrl = avatarUrl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(final String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		final UserInfo userInfo = (UserInfo) o;

		if (email != null ? !email.equals(userInfo.email) : userInfo.email != null)
			return false;
		if (name != null ? !name.equals(userInfo.name) : userInfo.name != null)
			return false;
		return avatarUrl != null ? avatarUrl.equals(userInfo.avatarUrl) : userInfo.avatarUrl == null;
	}

	@Override
	public int hashCode() {
		int result = email != null ? email.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (avatarUrl != null ? avatarUrl.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("UserInfo{");
		sb.append("email='").append(email).append('\'');
		sb.append(", name='").append(name).append('\'');
		sb.append(", avatarUrl='").append(avatarUrl).append('\'');
		sb.append('}');
		return sb.toString();
	}
}