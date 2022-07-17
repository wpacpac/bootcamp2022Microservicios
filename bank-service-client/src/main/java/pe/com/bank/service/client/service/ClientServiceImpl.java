package pe.com.bank.service.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.bank.service.client.entity.ClientEntity;
import pe.com.bank.service.client.repository.ClientRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements ClientService{
	@Autowired
    private ClientRepository clientRepository;
	
	public Mono<ClientEntity> saveClient(ClientEntity clientEntity)
	{
		return clientRepository.save(clientEntity);
	}

	public Mono<ClientEntity> findByIdClient(String id)
	{
		return clientRepository.findById(id);
	}

	public Mono<ClientEntity> updateClient(ClientEntity clientEntity)
	{
		return clientRepository.save(clientEntity);
	}

	public Mono<Void> deleteByIdClient(String id)
	{
		return clientRepository.deleteById(id);
	}

	public Flux<ClientEntity> findAllClient()
	{
		return clientRepository.findAll();
	}
}
