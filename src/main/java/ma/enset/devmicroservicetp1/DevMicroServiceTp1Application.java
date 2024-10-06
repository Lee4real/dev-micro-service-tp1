package ma.enset.devmicroservicetp1;

import ma.enset.devmicroservicetp1.enums.AccountType;
import ma.enset.devmicroservicetp1.entities.BankAccount;
import ma.enset.devmicroservicetp1.entities.Customer;
import ma.enset.devmicroservicetp1.repositories.BankAccountRepository;
import ma.enset.devmicroservicetp1.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class DevMicroServiceTp1Application {

    public static void main(String[] args) {
        SpringApplication.run(DevMicroServiceTp1Application.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository accountRepository, CustomerRepository customerRepository) {
        return args -> {
            Stream.of("Mohammed","Houbid","Ahmed").forEach(c->{

                Customer customer = Customer.builder()
                        .name(c)
                        .build();
                customerRepository.save(customer);

            });


            customerRepository.findAll().forEach(customer -> {
                BankAccount bankAccount = BankAccount.builder()
                        .accountNumber(UUID.randomUUID().toString())
                        .balance(679110.0)
                        .currency("USD")
                        .type(AccountType.CURRENT_ACCOUNT)
                        .creationDate(new Date())
                        .customer(customer)
                        .build();
                BankAccount bankAccount2 = BankAccount.builder()
                        .accountNumber(UUID.randomUUID().toString())
                        .balance(6800.1547)
                        .currency("DA")
                        .type(AccountType.SAVINGS_ACCOUNT)
                        .creationDate(new Date())
                        .customer(customer)
                        .build();
                BankAccount bankAccount3 = BankAccount.builder()
                        .accountNumber(UUID.randomUUID().toString())
                        .balance(6000.0)
                        .currency("USD")
                        .type(AccountType.CURRENT_ACCOUNT)
                        .creationDate(new Date())
                        .customer(customer)
                        .build();
                accountRepository.save(bankAccount);
                accountRepository.save(bankAccount2);
                accountRepository.save(bankAccount3);
            });
        };
    }


}