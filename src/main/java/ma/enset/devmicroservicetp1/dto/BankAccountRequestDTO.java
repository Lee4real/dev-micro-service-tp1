package ma.enset.devmicroservicetp1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.devmicroservicetp1.enums.AccountType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountRequestDTO {
    private Double balance;
    private String currency;
    private AccountType type;

}