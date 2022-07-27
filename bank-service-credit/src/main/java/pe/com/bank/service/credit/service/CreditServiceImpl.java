package pe.com.bank.service.credit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pe.com.bank.service.credit.dto.ClientEntity;
import pe.com.bank.service.credit.entity.CreditEntity;
import pe.com.bank.service.credit.repository.CreditRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditServiceImpl implements CreditService{
	@Autowired
	private CreditRepository creditRepository;
	@Autowired
	private ClientService clientService;
	private Long countNormalActivesCreditsByPerson;
	@Override
	public ResponseEntity<Mono<CreditEntity>> saveCredit(CreditEntity creditEntity) {
		this.clientService.findById(creditEntity.getIdClient());
		ClientEntity client = this.clientService.getClientEntity();
		if (creditEntity.getCreditType().compareTo("NORMAL") == 0 && client.getClientType().compareTo("PERSON") == 0) {
			Flux<CreditEntity> normalActivesCreditsByPerson = this.creditRepository.findByIdClientAndCreditTypeAndState(
					creditEntity.getIdClient(), creditEntity.getCreditType(), (byte) 1);
			normalActivesCreditsByPerson.count()
					.flatMap(m -> Mono.just(m))
					.subscribe(c -> this.countNormalActivesCreditsByPerson = c);
			if (this.countNormalActivesCreditsByPerson != 0) {
				System.out.println("El cliente persona ya tiene un prestamo activo.");//hacerlo con log
				return new ResponseEntity<>(Mono.just(new CreditEntity()), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return ResponseEntity.ok(creditRepository.save(creditEntity));
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
