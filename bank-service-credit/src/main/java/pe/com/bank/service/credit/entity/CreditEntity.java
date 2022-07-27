package pe.com.bank.service.credit.entity;

import org.springframework.data.annotation.Id;
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
public class CreditEntity{

	@Id
	private String id;
	private String accountNumber;
	private String idClient; //con la ayuda de este atributo jalo el tipo de cliente de la coleccion Client
	private String creditType;//"NORMAL" o "CARD"
	/*Datos de credito tipo NORMAL*/
	private Integer numberMonthlyFees;//numero de cuotas mensuales
	private Double monthlyInteresRate;
	private Double loanAmount;
	private Double amortizedAmount;
	private Byte state; //0=concluido, 1=activo;
	private String loanDate;//fecha del prestamo
	/*Datos de credito tipo CARD*/
	private Double creditMaxAmount;
	private Double remainingCredit;
	private String cardNumber;
}
