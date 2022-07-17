package pe.com.bank.service.debit.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import pe.com.bank.service.debit.entity.DebitEntity;

public interface DebitRepository extends ReactiveCrudRepository<DebitEntity,String>{

}
