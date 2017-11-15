package baat.user.service;


import baat.common.transfer.user.SignupRequest;
import baat.common.transfer.user.UserCredentials;
import baat.user.repository.UserCredentialsRepository;
import baat.user.repository.UserInfoRepository;
import baat.user.repository.UserTokenRepository;
import baat.user.repository.entity.UserCredentialsEntity;
import baat.user.repository.entity.UserInfoEntity;
import baat.user.repository.entity.UserTokenEntity;
import baat.user.util.Passwords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Service
public class UserService {

	@Autowired
	UserInfoRepository userInfoRepository;

	@Autowired
	UserCredentialsRepository userCredentialsRepository;

	@Autowired
	UserTokenRepository userTokenRepository;

	public String authenticate(final UserCredentials userCredentials) {
		return "token";
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

		// TODO check if not already a user with same email

		final UserInfoEntity user = userInfoRepository.save(new UserInfoEntity(signupRequest.getName(),
				signupRequest.getEmail(), signupRequest.getAvatarUrl()));

		final byte[] salt = Passwords.getNextSalt();
		userCredentialsRepository.save(new UserCredentialsEntity(user.getId(), user.getEmail(),
				new String(salt),
				new String(Passwords.hash(
						signupRequest.getPassword().toCharArray(), salt
				))));


		final UserTokenEntity userToken = userTokenRepository.save(new UserTokenEntity(user.getId(), UUID.randomUUID().toString()));
		return userToken.getUserToken();
	}

}
