package pe.com.bank.service.credit.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import pe.com.bank.service.credit.entity.CreditEntity;

public interface CreditRepository extends ReactiveCrudRepository<CreditEntity,String>
{

}
