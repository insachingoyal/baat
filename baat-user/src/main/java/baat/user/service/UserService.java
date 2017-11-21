package baat.user.service;


import baat.common.transfer.user.SignupRequest;
import baat.common.transfer.user.UserCredentials;
import baat.user.repository.UserCredentialsRepository;
import baat.user.repository.UserInfoRepository;
import baat.user.repository.UserTokenRepository;
import baat.user.repository.entity.UserCredentialsEntity;
import baat.user.repository.entity.UserInfoEntity;
import baat.user.repository.entity.UserTokenEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

import static baat.user.util.Passwords.getNextSalt;
import static baat.user.util.Passwords.hash;
import static baat.user.util.Passwords.isExpectedPassword;

@Service
public class UserService {

	@Autowired
	UserInfoRepository userInfoRepository;

	@Autowired
	UserCredentialsRepository userCredentialsRepository;

	@Autowired
	UserTokenRepository userTokenRepository;

	public String authenticate(final UserCredentials passedCredentials) {
		if (passedCredentials == null)
			throw new IllegalArgumentException("User Credentials must be provided");

		if (StringUtils.isEmpty(passedCredentials.getUserName()))
			throw new IllegalArgumentException("user name must be provided");

		if (StringUtils.isEmpty(passedCredentials.getPassword()))
			throw new IllegalArgumentException("password must be provided");

		final UserInfoEntity userInfoEntity = userInfoRepository.findByEmail(passedCredentials.getUserName());
		if (userInfoEntity == null)
			throw new IllegalArgumentException("Invalid user name, could not find user with such user name");

		final UserCredentialsEntity existingCredentials = userCredentialsRepository.findByUserId(userInfoEntity.getId());
		if (existingCredentials == null)
			throw new IllegalStateException("No credentials are stored for the user, please signup again");

		if (!isExpectedPassword(passedCredentials.getPassword(),
				existingCredentials.getSalt(),
				existingCredentials.getPasswordHash())) {
			throw new IllegalArgumentException("Invalid username/password");
		}

		UserTokenEntity userToken = userTokenRepository.findByUserId(userInfoEntity.getId());
		if (userToken == null || StringUtils.isEmpty(userToken.getUserToken())) {
			userToken = userTokenRepository.save(new UserTokenEntity(userInfoEntity.getId(), UUID.randomUUID().toString()));
		}

		return userToken.getUserToken();
	}

	public String signup(final SignupRequest signupRequest) {
		if (signupRequest == null)
			throw new IllegalArgumentException("signupRequest must be provided");

		if (StringUtils.isEmpty(signupRequest.getEmail()))
			throw new IllegalArgumentException("email must be provided");

		if (StringUtils.isEmpty(signupRequest.getName()))
			throw new IllegalArgumentException("name must be provided");

		if (StringUtils.isEmpty(signupRequest.getPassword()))
			throw new IllegalArgumentException("password must be provided");

		if (userInfoRepository.findByEmail(signupRequest.getEmail()) != null)
			throw new IllegalArgumentException("User with same email already exists");

		final UserInfoEntity user = userInfoRepository.save(new UserInfoEntity(signupRequest.getName(),
				signupRequest.getEmail(), signupRequest.getAvatarUrl()));

		final byte[] salt = getNextSalt();
		final byte[] hash = hash(signupRequest.getPassword(), salt);

		userCredentialsRepository.save(
				new UserCredentialsEntity(user.getId(),
						user.getEmail(),
						salt,
						hash));

		final UserTokenEntity userToken = userTokenRepository.save(new UserTokenEntity(user.getId(),
				UUID.randomUUID().toString()));
		return userToken.getUserToken();
	}

}
