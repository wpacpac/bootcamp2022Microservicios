package pe.com.bank.service.debit.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.reactive.function.client.WebClientResponseException;
import pe.com.bank.service.debit.dto.OperationDto;
import pe.com.bank.service.debit.entity.DebitEntity;
import pe.com.bank.service.debit.service.DebitService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/debit")
public class DebitController {
    @Autowired
    private DebitService debitService;

    @PostMapping("/save")
    public Mono<DebitEntity> saveDebit(@RequestBody @Valid DebitEntity debitEntity) {
        return this.debitService.saveDebit(debitEntity);
    }

    @PostMapping("/operation-account")
    public Mono<ResponseEntity<DebitEntity>> operationDebit(@RequestBody @Valid OperationDto operationDto) {

        return this.debitService.operationAccount(operationDto)
                .map(ResponseEntity::ok)
                .onErrorReturn(WebClientResponseException.class, ResponseEntity.badRequest().build())
                .onErrorReturn(WebClientResponseException.class, ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build());
    }

    @GetMapping("/{id}")
    public Mono<DebitEntity> findById(@PathVariable String id) {
        return this.debitService.findByIdDebit(id);
    }

    @PutMapping("/update")
    public Mono<DebitEntity> updateDebit(@RequestBody @Valid DebitEntity debitEntity) {
        return this.debitService.updateDebit(debitEntity);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteIdDebit(@PathVariable String id) {
        return this.debitService.deleteByIdDebit(id);
    }

    @GetMapping()
    public Flux<DebitEntity> findAllDebit() {
        return this.debitService.findAllDebit();
    }
}
