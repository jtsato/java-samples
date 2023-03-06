package org.example.common;

import org.example.model.AccountType;
import org.example.service.IAccountValidatorService;
import org.example.service.IndividualAccountValidatorService;
import org.example.service.LegalEntityAccountValidatorService;

// Factory Pattern
public class AccountValidatorFactory {

    private AccountValidatorFactory() {
    }

    // Strategy Pattern
    public static IAccountValidatorService create(AccountType accountType) {
        return switch (accountType) {
            case LEGAL_ENTITY -> new LegalEntityAccountValidatorService();
            case INDIVIDUAL -> new IndividualAccountValidatorService();
        };
    }
}
