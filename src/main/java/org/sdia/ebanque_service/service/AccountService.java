package org.sdia.ebanque_service.service;

import org.sdia.ebanque_service.dto.BankAccountRequestDTO;
import org.sdia.ebanque_service.dto.BankAccountResponseDTO;
import org.sdia.ebanque_service.entities.BankAccount;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
