package pe.com.bank.service.credit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.bank.service.credit.entity.CreditEntity;
import pe.com.bank.service.credit.repository.CreditRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditServiceImpl implements CreditService{
	@Autowired
	private CreditRepository creditRepository;

	@Override
	public Mono<CreditEntity> saveCredit(CreditEntity creditEntity) {
		return creditRepository.save(creditEntity);
	}

	@Override
	public Mono<CreditEntity> findByIdCredit(String id) {
		return creditRepository.findById(id);
	}

	@Override
	public Mono<CreditEntity> updateCredit(CreditEntity creditEntity) {
		return creditRepository.save(creditEntity);
	}

	@Override
	public Mono<Void> deleteByIdCredit(String id) {
		return creditRepository.deleteById(id);
	}

	@Override
	public Flux<CreditEntity> findAllCredit() {
		return creditRepository.findAll();
	}

}
