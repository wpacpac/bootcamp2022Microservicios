package pe.com.bank.service.client.entity;

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
public class ClientEntity {
	@Id
	private String id;
	private String name;
	private Long dniOrRUC;
	private Date birthDate;
	private Long cellNumber;
	private String address;
	private String clientType;
}
