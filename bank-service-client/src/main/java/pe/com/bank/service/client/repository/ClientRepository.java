package pe.com.bank.service.client.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import org.springframework.stereotype.Repository;
import pe.com.bank.service.client.entity.ClientEntity;
@Repository
public interface ClientRepository extends ReactiveCrudRepository<ClientEntity,String>{

}
