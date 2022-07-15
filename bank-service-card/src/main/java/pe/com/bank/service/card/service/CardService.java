package pe.com.bank.service.card.service;

import pe.com.bank.service.card.entity.CardEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CardService {
    Mono<CardEntity> saveCard(CardEntity cardEntity);

    Mono<CardEntity> findByIdCard(Integer id);

    Mono<CardEntity> updateCard(CardEntity cardEntity);

    Mono<Void> deleteByCard(Integer id);

    Flux<CardEntity> findAllCard();
}
