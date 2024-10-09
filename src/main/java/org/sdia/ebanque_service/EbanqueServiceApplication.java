package org.sdia.ebanque_service;

import org.sdia.ebanque_service.entities.BankAccount;
import org.sdia.ebanque_service.entities.Customer;
import org.sdia.ebanque_service.enums.AccountType;
import org.sdia.ebanque_service.repositories.BankAccountRepository;
import org.sdia.ebanque_service.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbanqueServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbanqueServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository){
		return args -> {
			Stream.of("Amine","Mohamed","Ali","Salah","Hassan").forEach(name->{
				Customer customer = Customer.builder()
						.name(name)
						.build();
				customerRepository.save(customer);
			});
			customerRepository.findAll().forEach(customer -> {
				for (int i = 0; i < 10; i++) {
					BankAccount bankAccount = BankAccount.builder()
							.id(UUID.randomUUID().toString())
							.balance(Math.random()*20000)
							.currency("EUR")
							.type(Math.random()>0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
							.createdAt(new Date())
							.customer(customer)
							.build();
					bankAccountRepository.save(bankAccount);
			}

			});
		};
	}


}
