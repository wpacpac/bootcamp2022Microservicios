package pe.com.bank.service.debit.service;

import org.springframework.beans.factory.annotation.Autowired;
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
    private MovementService movementService;

    @Override
    public Mono<DebitEntity> saveDebit(DebitEntity debitEntity) {
        return debitRepository.save(debitEntity);
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
