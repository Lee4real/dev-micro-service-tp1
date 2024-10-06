package ma.enset.devmicroservicetp1.web;

import lombok.AllArgsConstructor;
import ma.enset.devmicroservicetp1.dto.BankAccountRequestDTO;
import ma.enset.devmicroservicetp1.dto.BankAccountResponseDTO;
import ma.enset.devmicroservicetp1.entities.BankAccount;
import ma.enset.devmicroservicetp1.repositories.BankAccountRepository;
import ma.enset.devmicroservicetp1.services.AccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class AccountGraphQlController {

    private BankAccountRepository accountRepository;
    private AccountService accountService;


    @QueryMapping
    public List<BankAccount> accounts() {
        return accountRepository.findAll();

    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccount){
        return accountService.updateAccount(id,bankAccount);
    }
    @MutationMapping
    public Boolean deleteAccount(@Argument String id){
        accountService.deleteAccount(id);
        return true;
    }


}