package ma.enset.devmicroservicetp1.repositories;

import ma.enset.devmicroservicetp1.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    BankAccount findByAccountNumber(String accountNumber);

}
