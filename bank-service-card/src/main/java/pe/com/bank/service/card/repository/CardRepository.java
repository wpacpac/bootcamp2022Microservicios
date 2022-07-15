package pe.com.bank.service.card.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import pe.com.bank.service.card.entity.CardEntity;

@Repository
public interface CardRepository extends ReactiveCrudRepository<CardEntity,Integer> {
}
