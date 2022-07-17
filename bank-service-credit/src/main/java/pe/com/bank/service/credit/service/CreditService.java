package pe.com.bank.service.credit.service;


import pe.com.bank.service.credit.entity.CreditEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditService {


	public Mono<CreditEntity> saveCredit(CreditEntity CreditEntity);

	public Mono<CreditEntity> findByIdCredit(String id);


	public Mono<CreditEntity> updateCredit(CreditEntity creditEntity);


	public Mono<Void> deleteByIdCredit(String id);


	public Flux<CreditEntity> findAllCredit();
}
