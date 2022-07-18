package pe.com.bank.service.credit.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class CreditEntity 
{
	private String id;
	private String accountNumber;
	private Integer numberMonthlyFees;
	private Double monthlyInteresRate;
	private String idClient; //con la ayuda de este atributo jalo el tipo de cliente de la coleccion Client
	private Double loanAmount;
	private Double amortizedAmount;
}
