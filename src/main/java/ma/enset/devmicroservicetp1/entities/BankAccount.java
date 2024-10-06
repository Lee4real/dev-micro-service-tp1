package ma.enset.devmicroservicetp1.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.devmicroservicetp1.enums.AccountType;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount   {
    @Id
    private String accountNumber;
    private Date creationDate;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @ManyToOne
    private Customer customer;

}