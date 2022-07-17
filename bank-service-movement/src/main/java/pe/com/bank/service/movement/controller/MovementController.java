package pe.com.bank.service.movement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.bank.service.movement.entity.MovementEntity;
import pe.com.bank.service.movement.service.MovementService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/movement")
public class MovementController 
{
	@Autowired
    private MovementService movementService;

    @PostMapping("/save")
    public Mono<MovementEntity> saveMovement(@RequestBody @Valid MovementEntity movementEntity) {
        return this.movementService.saveMovement(movementEntity);
    }

    @GetMapping("/{id}")
    public Mono<MovementEntity> findByMovement(@PathVariable String id) {
        return this.movementService.findByIdMovement(id);
    }

    @PutMapping("/update")
    public Mono<MovementEntity> updateMovement(@RequestBody @Valid MovementEntity movementEntity) {
        return this.movementService.updateMovement(movementEntity);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteIdMovement(@PathVariable String id) {
        return this.movementService.deleteByIdMovement(id);
    }

    @GetMapping()
    public Flux<MovementEntity> findAllMovement() {
        return this.movementService.findAllMovement();
    }
}
