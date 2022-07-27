package pe.com.bank.service.credit.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import org.springframework.stereotype.Repository;
import pe.com.bank.service.credit.entity.CreditEntity;
import reactor.core.publisher.Flux;

@Repository
public interface CreditRepository extends ReactiveCrudRepository<CreditEntity,String>
{
    Flux<CreditEntity> findByIdClientAndCreditTypeAndState(String idClient, String creditType, Byte state);

}
