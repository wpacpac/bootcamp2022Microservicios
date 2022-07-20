package pe.com.bank.service.debit.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import org.springframework.stereotype.Repository;
import pe.com.bank.service.debit.entity.DebitEntity;
import reactor.core.publisher.Mono;

@Repository
public interface DebitRepository extends ReactiveCrudRepository<DebitEntity,String>{

    Mono<DebitEntity> findByAccountNumber(String account);
}
