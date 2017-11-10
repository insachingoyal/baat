package baat.user.repository;

import baat.user.repository.entity.UserTokenEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserTokenRepository extends CrudRepository<UserTokenEntity, Long> {
}
