package baat.user.repository;

import baat.user.repository.entity.UserTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTokenRepository extends JpaRepository<UserTokenEntity, Long> {
	UserTokenEntity findByUserId(Long userId);

	UserTokenEntity findByUserToken(String userToken);
}
