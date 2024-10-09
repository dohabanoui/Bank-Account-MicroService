package org.sdia.ebanque_service.entities;

import org.sdia.ebanque_service.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types=BankAccount.class, name="p1")
public interface AccountProjection {
    // pour retourner juste Id et le type
    public String getId();
    public AccountType getType();
}
