package pe.com.bank.service.debit.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document
public class DebitEntity 
{
	@Id
	private String id;
	private String accountNumber;
	private Integer maxLimOfMonthlyMovemFreeOfCommissions;
	private Double costPerMovement;
	private Double monthlyMaintenanceCost;
	private Double balance; //saldo
	private String debitType; /*FIX_TERM, SAVINGS, CURRENT_ACCOUNT*/
	private String idClient;//con la ayuda de este atributo jalo el tipo de cliente de la coleccion Client
	private String idClient_titular; //0 o mas
	private String idClient_authorizedSignature; // 0 o mas	
}
