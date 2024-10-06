package ma.enset.devmicroservicetp1.services;

import lombok.AllArgsConstructor;
import ma.enset.devmicroservicetp1.dto.BankAccountRequestDTO;
import ma.enset.devmicroservicetp1.dto.BankAccountResponseDTO;
import ma.enset.devmicroservicetp1.entities.BankAccount;
import ma.enset.devmicroservicetp1.mappers.BankAccountMapper;
import ma.enset.devmicroservicetp1.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final BankAccountRepository accountRepository;
    private  BankAccountMapper bankAccountMapper;




    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount account = bankAccountMapper.fromRequestDTOToBankAccount(bankAccountDTO);
        account.setAccountNumber(UUID.randomUUID().toString());
        account.setCreationDate(new Date());
        BankAccount savedBankAccount = accountRepository.save(account);

        return bankAccountMapper.fromBankAccountToResponseDTO(savedBankAccount);
    }
    @Override
    public BankAccountResponseDTO updateAccount(String id,BankAccountRequestDTO bankAccountDTO) {
        BankAccount account = bankAccountMapper.fromRequestDTOToBankAccount(bankAccountDTO);
        account.setAccountNumber(id);
        account.setCreationDate(new Date());
        account.setCurrency(bankAccountDTO.getCurrency());
        account.setType(bankAccountDTO.getType());
        BankAccount savedBankAccount = accountRepository.save(account);

        return bankAccountMapper.fromBankAccountToResponseDTO(savedBankAccount);
    }

    @Override
    public void deleteAccount(String id) {
        accountRepository.deleteById(id);
    }


}