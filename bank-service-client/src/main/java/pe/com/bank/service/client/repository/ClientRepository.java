package pe.com.bank.service.client.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import pe.com.bank.service.client.entity.ClientEntity;

public interface ClientRepository extends ReactiveCrudRepository<ClientEntity,String>{

}
