package pe.com.bank.service.debit.service;

import org.springframework.http.ResponseEntity;
import pe.com.bank.service.debit.dto.OperationDto;
import pe.com.bank.service.debit.entity.DebitEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DebitService {
    ResponseEntity<Mono<DebitEntity>> save(DebitEntity debitEntity);
    Mono<DebitEntity> findByIdDebit(String id);

    Mono<DebitEntity> updateDebit(DebitEntity debitEntity);

    Mono<Void> deleteByIdDebit(String id);

    Flux<DebitEntity> findAllDebit();

    Mono<DebitEntity> findByAccount(String account);
    Mono<DebitEntity> operationAccount(OperationDto operationDto);
}
