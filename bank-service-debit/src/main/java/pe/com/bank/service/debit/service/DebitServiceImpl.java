package pe.com.bank.service.debit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pe.com.bank.service.debit.dto.MovementDto;
import pe.com.bank.service.debit.dto.OperationDto;
import pe.com.bank.service.debit.entity.DebitEntity;
import pe.com.bank.service.debit.repository.DebitRepository;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.function.Function;

@Service
public class DebitServiceImpl implements DebitService {
    @Autowired
    private DebitRepository debitRepository;
    @Autowired
    private ClientService clientService;
    private Long countDebitEntitiesPerson;
    @Autowired
    private MovementService movementService;

    public ResponseEntity<Mono<DebitEntity>> save(DebitEntity debitEntity) {
        //System.out.println("Sammy punto 1: " + debitEntity.getIdClient());
        this.clientService.findById(debitEntity.getIdClient());
        String clientType = this.clientService.getClientEntity().getClientType();
        if (clientType.compareTo("PERSON") == 0)
        {
            Flux<DebitEntity> debitEntitiesPerson = this.debitRepository.findByIdClientAndDebitType(debitEntity.getIdClient(), debitEntity.getDebitType());
            debitEntitiesPerson.count()
                    .flatMap(m -> Mono.just(m))
                    .subscribe(c -> this.countDebitEntitiesPerson = c);
            if (this.countDebitEntitiesPerson == 0)
            {
                Mono<DebitEntity> debitPersonResponse = this.debitRepository.save(debitEntity);
                System.out.println("Se registro la nueva cuenta de debito de la persona exitosamente");
                return new ResponseEntity<>(debitPersonResponse , HttpStatus.OK);
            }
            else
            {
                System.out.println("El cliente ya posee una cuenta de debito de tipo: " + debitEntity.getDebitType() + "; no puede tener más de 1");
                return new ResponseEntity<>(Mono.just(new DebitEntity()) , HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
        else if (clientType.compareTo("ENTERPRISE") == 0)
        {
            String debitType = debitEntity.getDebitType();
            if (debitType.compareTo("SAVINGS") == 0 || debitType.compareTo("FIXED TERM") == 0 )
            {
                System.out.println("La empresano se le esta permitida tener una cuenta de ahorrro o una cuenta fija");
                return new ResponseEntity<>(Mono.just(new DebitEntity()) , HttpStatus.INTERNAL_SERVER_ERROR);
            }
            else if (debitType.compareTo("CURRENT ACCOUNT") == 0)
            {
                Mono<DebitEntity> debitEnterpriseResponse = this.debitRepository.save(debitEntity);
                System.out.println("Se registro la nueva cuenta de debito de la empresa exitosamente");
                return new ResponseEntity<>(debitEnterpriseResponse, HttpStatus.OK);
            }
            else
            {
                System.out.println("Error en los datos de entrada");
                return new ResponseEntity<>(Mono.just(new DebitEntity()) , HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
        else
            return new ResponseEntity<>(Mono.just(new DebitEntity()) , HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Override
    public Mono<DebitEntity> findByIdDebit(String id) {
        return debitRepository.findById(id);
    }

    @Override
    public Mono<DebitEntity> updateDebit(DebitEntity debitEntity) {
        return debitRepository.save(debitEntity);
    }

    @Override
    public Mono<Void> deleteByIdDebit(String id) {
        return debitRepository.deleteById(id);
    }

    @Override
    public Flux<DebitEntity> findAllDebit() {
        return debitRepository.findAll();
    }

    @Override
    public Mono<DebitEntity> findByAccount(String account) {
        Mono<DebitEntity> responseAccount = this.debitRepository.findByAccountNumber(account);
        return responseAccount;
    }

    @Override
    public Mono<DebitEntity> operationAccount(OperationDto operationDto) {
        Mono<DebitEntity> responseAccount = this.debitRepository.findByAccountNumber(operationDto.getAccountNumberOrigin());

        MovementDto movent = new MovementDto();
        movent.setAccountNumber(operationDto.getAccountNumberOrigin());
        movent.setAmount(operationDto.getAmount());
        movent.setMovementDate(new Date());
        movent.setOperationType(operationDto.getOperationType());

        if (operationDto.getOperationType().equals("DEPOSIT")) {
            Mono<Double> amount = responseAccount.map(deb -> {
                return deb.getBalance() + operationDto.getAmount();
            });

        } else {
            Mono<Double> amount = responseAccount.map(deb -> {
                return deb.getBalance() - operationDto.getAmount();
            });

        }
        DebitEntity debitEntity = new DebitEntity();
        debitEntity.setBalance(50.10);
        movementService.saveMovement(movent);
        return debitRepository.save(debitEntity);
    }

}
