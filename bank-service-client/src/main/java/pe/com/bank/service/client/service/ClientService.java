package pe.com.bank.service.client.service;

import pe.com.bank.service.client.entity.ClientEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {
	Mono<ClientEntity> saveClient(ClientEntity cardEntity);

    Mono<ClientEntity> findByIdClient(String id);

    Mono<ClientEntity> updateClient(ClientEntity cardEntity);

    Mono<Void> deleteByIdClient(String id);

    Flux<ClientEntity> findAllClient();
}
