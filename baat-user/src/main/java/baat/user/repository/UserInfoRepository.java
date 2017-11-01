package baat.user.repository;

import baat.user.repository.entity.UserInfoEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfoEntity, Long> {
}
