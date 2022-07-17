package pe.com.bank.service.credit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditEntity 
{
	private String id;
	private String accountNumber;
	private Integer numberMonthlyFees;
	private Double monthlyInteresRate;
	private String idClient;
	private String tipoCliente;
	private Double loanAmount;
	private Double amortizedAmount;
}
