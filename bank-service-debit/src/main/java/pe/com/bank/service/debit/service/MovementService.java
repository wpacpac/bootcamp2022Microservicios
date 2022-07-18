package pe.com.bank.service.debit.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pe.com.bank.service.debit.dto.MovementDto;
import reactor.core.publisher.Mono;

@Service
public class MovementService {

    private final WebClient webClient;


    public MovementService(@Value("${movement.service.url}") String url) {
        this.webClient = WebClient.builder().baseUrl(url).build();
    }

    public Mono<MovementDto> saveMovement(MovementDto movementDto) {
        return this.webClient.post()
                .uri("save")
                .bodyValue(movementDto)
                .retrieve()
                .bodyToMono(MovementDto.class);
    }

}
