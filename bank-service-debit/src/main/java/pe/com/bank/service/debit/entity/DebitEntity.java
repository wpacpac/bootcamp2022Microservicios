package pe.com.bank.service.debit.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(collection = "debit_account")
public class DebitEntity
{
	@Id
	private String id;
	private Double balance;
	private String idClient;
	private String accountNumber;
	private String cardNumber;
	private Integer cardAssociationOrder;
	private String debitType;
}
