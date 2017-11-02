package baat.user.service;


import baat.common.transfer.user.SignupRequest;
import baat.common.transfer.user.UserCredentials;
import baat.user.repository.UserCredentialsRepository;
import baat.user.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserInfoRepository userInfoRepository;

	@Autowired
	UserCredentialsRepository userCredentialsRepository;

	public boolean authenticate(final UserCredentials userCredentials) {
		return false;
	}

	public boolean signup(final SignupRequest signupRequest) {
		return false;
	}

}
