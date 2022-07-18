package pe.com.bank.service.debit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MovementDto {
	private Date MovementDate;
	private String OperationType;
	private Double amount;
	private String accountNumber;
}
