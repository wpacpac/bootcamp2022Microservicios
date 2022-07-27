package pe.com.bank.service.debit.dto;

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
@Document(collection="client")
public class ClientEntity {
	@Id
	private String id;
	private String name;
	private Long dniOrRUC;
	private String birthDate;
	private Long cellNumber;
	private String address;
	private String clientType;
}
