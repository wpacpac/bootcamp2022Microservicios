package pe.com.bank.service.credit.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.bank.service.credit.entity.CreditEntity;
import pe.com.bank.service.credit.service.CreditServiceImpl;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/credit")
public class CreditController {
	@Autowired
    private CreditServiceImpl creditService;
	
	@PostMapping("/save")
    public Mono<CreditEntity> saveCredit(@RequestBody @Valid CreditEntity creditEntity) {
        return this.creditService.saveCredit(creditEntity);
    }

    @GetMapping("/{id}")
    public Mono<CreditEntity> findById(@PathVariable String id) {
        return this.creditService.findByIdCredit(id);
    }

    @PutMapping("/update")
    public Mono<CreditEntity> updateCredit(@RequestBody @Valid CreditEntity creditEntity) {
        return this.creditService.updateCredit(creditEntity);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCredit(@PathVariable String id) {
        return this.creditService.deleteByIdCredit(id);
    }

    @GetMapping()
    public Flux<CreditEntity> findAllCredit() {
        return this.creditService.findAllCredit();
    }
}
