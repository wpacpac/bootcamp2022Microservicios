package pe.com.bank.service.debit.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(collection="debit_features")
public class DebitFeaturesEntity {
	private String maxNumberMovemSavingsByMonth;
	private String maxNumberMovemCurrentAccountByMonth;
	private String maxNumberMovemFixedTermByMonth;
	private Double commisAmountByMovemSaving;
	private Double commisAmountByMovemCurrentAccount;
	private Double commisAmountByMovemFixedTerm;
	
}
