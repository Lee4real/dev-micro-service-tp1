package ma.enset.devmicroservicetp1.mappers;

import ma.enset.devmicroservicetp1.dto.BankAccountRequestDTO;
import ma.enset.devmicroservicetp1.dto.BankAccountResponseDTO;
import ma.enset.devmicroservicetp1.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper {

    public BankAccount fromRequestDTOToBankAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount account =  new BankAccount();
        BeanUtils.copyProperties(bankAccountRequestDTO,account);

        return account;
    }

    public BankAccountResponseDTO fromBankAccountToResponseDTO(BankAccount bankAccount) {
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return  bankAccountResponseDTO;
    }
}