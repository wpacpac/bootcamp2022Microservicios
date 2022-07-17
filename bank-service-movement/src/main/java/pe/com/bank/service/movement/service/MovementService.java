package pe.com.bank.service.movement.service;

import pe.com.bank.service.movement.entity.MovementEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovementService {
	Mono<MovementEntity> saveMovement(MovementEntity movementEntity);
    Mono<MovementEntity> findByIdMovement(String id);

    Mono<MovementEntity> updateMovement(MovementEntity movementEntity);

    Mono<Void> deleteByIdMovement(String id);

    Flux<MovementEntity> findAllMovement();
}
