package org.sdia.ebanque_service.repositories;

import org.sdia.ebanque_service.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
