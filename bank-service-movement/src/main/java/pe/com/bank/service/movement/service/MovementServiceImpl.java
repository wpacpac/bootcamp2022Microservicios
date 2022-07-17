package pe.com.bank.service.movement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.bank.service.movement.entity.MovementEntity;
import pe.com.bank.service.movement.repository.MovementRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovementServiceImpl implements  MovementService
{
	@Autowired
    private MovementRepository movementRepository;

    @Override
    public Mono< MovementEntity> saveMovement( MovementEntity movementEntity) {
        return movementRepository.save(movementEntity);
    }

    @Override
    public Mono< MovementEntity> findByIdMovement(String id) {
        return movementRepository.findById(id);
    }

    @Override
    public Mono< MovementEntity> updateMovement( MovementEntity movementEntity) {
        return movementRepository.save(movementEntity);
    }

    @Override
    public Mono<Void> deleteByIdMovement(String id) {
        return movementRepository.deleteById(id);
    }

    @Override
    public Flux<MovementEntity> findAllMovement() {
        return movementRepository.findAll();
    }
}
