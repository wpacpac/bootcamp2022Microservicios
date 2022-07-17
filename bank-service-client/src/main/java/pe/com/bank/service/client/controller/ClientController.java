package pe.com.bank.service.client.controller;

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

import pe.com.bank.service.client.entity.ClientEntity;
import pe.com.bank.service.client.service.ClientService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/client")
public class ClientController {
	@Autowired
    private ClientService clientService;

    @PostMapping("/save")
    public Mono<ClientEntity> saveClient(@RequestBody @Valid ClientEntity clientEntity) {
        return this.clientService.saveClient(clientEntity);
    }

    @GetMapping("/{id}")
    public Mono<ClientEntity> findById(@PathVariable String id) {
        return this.clientService.findByIdClient(id);
    }

    @PutMapping("/update")
    public Mono<ClientEntity> updateClient(@RequestBody @Valid ClientEntity clientEntity) {
        return this.clientService.updateClient(clientEntity);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteIdClient(@PathVariable String id) {
        return this.clientService.deleteByIdClient(id);
    }

    @GetMapping()
    public Flux<ClientEntity> findAllClient() {
        return this.clientService.findAllClient();
    }
}
