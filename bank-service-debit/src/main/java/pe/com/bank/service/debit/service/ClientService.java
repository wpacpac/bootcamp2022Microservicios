package pe.com.bank.service.debit.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.Data;
import pe.com.bank.service.debit.dto.ClientEntity;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

@Data
@Service
public class ClientService{
    private final WebClient webClient;
    private ClientEntity clientEntity;

    public ClientService(@Value("${client.service.url}") String url) {
        this.webClient = WebClient.builder().baseUrl(url).build();
    }

    public Disposable findById(String idClient) 
    {
		return this.webClient.get()
                .uri(idClient)
                .retrieve()
                .bodyToMono(ClientEntity.class)
                .flatMap(p -> Mono.just(p))
                .subscribe(k -> 
                {
                	this.clientEntity = k;
                });
                
    }
}
