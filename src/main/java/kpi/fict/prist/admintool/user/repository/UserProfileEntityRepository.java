package kpi.fict.prist.admintool.user.repository;

import kpi.fict.prist.admintool.user.entity.UserProfileEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileEntityRepository extends MongoRepository<UserProfileEntity, String> {
}
