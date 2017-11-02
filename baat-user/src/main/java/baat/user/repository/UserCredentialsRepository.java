package baat.user.repository;

import baat.user.repository.entity.UserCredentialsEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserCredentialsRepository extends CrudRepository<UserCredentialsEntity, Long> {
}
