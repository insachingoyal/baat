package baat.user.repository;

import baat.user.repository.entity.UserCredentialsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialsRepository extends JpaRepository<UserCredentialsEntity, Long> {
	UserCredentialsEntity findByUserId(Long userId);
}
