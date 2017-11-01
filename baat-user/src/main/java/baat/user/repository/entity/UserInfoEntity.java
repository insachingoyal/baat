package baat.user.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;

@Entity
public class UserInfoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String email;
	private String name;
	private byte[] avatar;

	public UserInfoEntity() {
	}

	public UserInfoEntity(final String name, final String email, final byte[] avatar) {
		this.name = name;
		this.email = email;
		this.avatar = avatar;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
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

		final UserInfoEntity that = (UserInfoEntity) o;

		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;
		if (name != null ? !name.equals(that.name) : that.name != null)
			return false;
		if (email != null ? !email.equals(that.email) : that.email != null)
			return false;
		return Arrays.equals(avatar, that.avatar);
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + Arrays.hashCode(avatar);
		return result;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("UserInfoEntity{");
		sb.append("id=").append(id);
		sb.append(", name='").append(name).append('\'');
		sb.append(", email='").append(email).append('\'');
		sb.append(", avatar=").append(Arrays.toString(avatar));
		sb.append('}');
		return sb.toString();
	}
}
