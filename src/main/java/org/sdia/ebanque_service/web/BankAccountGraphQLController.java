package org.sdia.ebanque_service.web;

import org.sdia.ebanque_service.dto.BankAccountRequestDTO;
import org.sdia.ebanque_service.dto.BankAccountResponseDTO;
import org.sdia.ebanque_service.entities.BankAccount;
import org.sdia.ebanque_service.entities.Customer;
import org.sdia.ebanque_service.repositories.BankAccountRepository;
import org.sdia.ebanque_service.repositories.CustomerRepository;
import org.sdia.ebanque_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerRepository customerRepository;
    // on ecrit le meme nom que dans le schema.graphqls
    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account with id %s not found", id)));
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
        bankAccountRepository.deleteById(id);
        return true;
    }

    @QueryMapping
    public List<Customer> customers(){
        return customerRepository.findAll();
    }

}
/*
// un objet ou on specifie les parametre de la constructeur
record BankAccountDTO(Double balance, String type, String currency){}
 */
