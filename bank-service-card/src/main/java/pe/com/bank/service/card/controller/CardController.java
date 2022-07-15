package pe.com.bank.service.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.bank.service.card.entity.CardEntity;
import pe.com.bank.service.card.service.CardService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/card")
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<CardEntity> saveClient(@RequestBody @Valid CardEntity cardEntity) {
        return this.cardService.saveCard(cardEntity);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<CardEntity> findById(@PathVariable Integer id) {
        return this.cardService.findByIdCard(id);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<CardEntity> updateCard(@RequestBody @Valid CardEntity cardEntity) {
        return this.cardService.updateCard(cardEntity);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Void> deleteCard(@PathVariable Integer id) {
        return this.cardService.deleteByCard(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<CardEntity> findAllCard() {
        return this.cardService.findAllCard();
    }
}
