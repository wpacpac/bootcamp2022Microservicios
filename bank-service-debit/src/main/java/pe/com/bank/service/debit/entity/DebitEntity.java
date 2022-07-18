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
	private Double balance;
	private String debitType;
	private String idClient;
	private String idClientTitular;
	private String idClientAuthorizedSignature;
}
