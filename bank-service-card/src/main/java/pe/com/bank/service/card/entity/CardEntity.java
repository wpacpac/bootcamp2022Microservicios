package pe.com.bank.service.card.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document
public class CardEntity {

    @Id
    private String id;
    private String accountNumber;
    private Integer creditMaxAmount;
    private Integer remainingCredit;
    private String idClient;
    private String cardNumber;
    private String typeCredit;

}
