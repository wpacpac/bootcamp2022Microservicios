package pe.com.bank.service.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.bank.service.card.entity.CardEntity;
import pe.com.bank.service.card.repository.CardRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CardServiceImpl implements CardService {


    @Autowired
    private CardRepository cardRepository;

    @Override
    public Mono<CardEntity> saveCard(CardEntity cardEntity) {
        return cardRepository.save(cardEntity);
    }

    @Override
    public Mono<CardEntity> findByIdCard(Integer id) {
        return cardRepository.findById(id);
    }

    @Override
    public Mono<CardEntity> updateCard(CardEntity cardEntity) {
        return cardRepository.save(cardEntity);
    }

    @Override
    public Mono<Void> deleteByCard(Integer id) {
        return cardRepository.deleteById(id);
    }

    @Override
    public Flux<CardEntity> findAllCard() {
        return cardRepository.findAll();
    }
}
