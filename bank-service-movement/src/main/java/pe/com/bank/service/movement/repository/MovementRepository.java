package pe.com.bank.service.movement.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import pe.com.bank.service.movement.entity.MovementEntity;

public interface MovementRepository extends ReactiveCrudRepository<MovementEntity,String>{

}
