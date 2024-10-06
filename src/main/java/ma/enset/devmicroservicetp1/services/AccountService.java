package ma.enset.devmicroservicetp1.services;

import ma.enset.devmicroservicetp1.dto.BankAccountRequestDTO;
import ma.enset.devmicroservicetp1.dto.BankAccountResponseDTO;


public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
    void deleteAccount(String id);
}