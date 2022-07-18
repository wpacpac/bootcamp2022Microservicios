package pe.com.bank.service.movement.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import org.springframework.stereotype.Repository;
import pe.com.bank.service.movement.entity.MovementEntity;
@Repository
public interface MovementRepository extends ReactiveCrudRepository<MovementEntity,String>{

}
