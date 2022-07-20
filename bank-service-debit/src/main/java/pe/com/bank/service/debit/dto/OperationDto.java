package pe.com.bank.service.debit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OperationDto {
    private Double amount;
    private String operationType;
    private String accountNumberOrigin;
    private String accountNumberReference;

}
