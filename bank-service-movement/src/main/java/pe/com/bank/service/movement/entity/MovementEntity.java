package pe.com.bank.service.movement.entity;

import java.util.Date;

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
public class MovementEntity {
	@Id
	private String id;
	private Date MovementDate;
	private String OperationType;
	private Double amount;
	private String accountNumber;
}
