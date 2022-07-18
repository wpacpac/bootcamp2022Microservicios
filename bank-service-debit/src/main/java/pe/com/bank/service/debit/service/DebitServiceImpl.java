package pe.com.bank.service.debit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.bank.service.debit.entity.DebitEntity;
import pe.com.bank.service.debit.repository.DebitRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DebitServiceImpl implements DebitService {
    @Autowired
    private DebitRepository debitRepository;

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

}
