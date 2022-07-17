package pe.com.bank.service.debit.controller;


@RestController
@RequestMapping("/api/debit")
public class DebitController {
	@Autowired
    private CardService cardService;

    @PostMapping("/save")
    public Mono<CardEntity> saveClient(@RequestBody @Valid CardEntity cardEntity) {
        return this.cardService.saveCard(cardEntity);
    }

    @GetMapping("/{id}")
    public Mono<CardEntity> findById(@PathVariable String id) {
        return this.cardService.findByIdCard(id);
    }

    @PutMapping("/update")
    public Mono<CardEntity> updateCard(@RequestBody @Valid CardEntity cardEntity) {
        return this.cardService.updateCard(cardEntity);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteIdCard(@PathVariable String id) {
        return this.cardService.deleteByIdCard(id);
    }

    @GetMapping()
    public Flux<CardEntity> findAllCard() {
        return this.cardService.findAllCard();
    }
}
