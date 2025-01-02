package kpi.fict.prist.admintool.user.repository;

import kpi.fict.prist.admintool.user.entity.OrderEntity;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderEntityRepository extends MongoRepository<OrderEntity, String> {
    List<OrderEntity> findByUserExternalId(String userExternalId);
}
