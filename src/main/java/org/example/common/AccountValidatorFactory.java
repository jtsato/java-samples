package org.example.common;

import org.example.model.AccountType;
import org.example.service.IAccountValidatorService;
import org.example.service.IndividualAccountValidatorService;
import org.example.service.LegalEntityAccountValidatorService;
import org.example.service.SimpleAccountValidatorService;

// 99 Design Pattern: Factory
public class AccountValidatorFactory {

    private AccountValidatorFactory() {
    }

    // 03 LSP: Liskov Substitution Principle
    // 99 Design Pattern: Strategy
    public static IAccountValidatorService create(AccountType accountType) {
        return switch (accountType) {
            case NONE -> new SimpleAccountValidatorService();
            case LEGAL_ENTITY -> new LegalEntityAccountValidatorService();
            case INDIVIDUAL -> new IndividualAccountValidatorService();
        };
    }
}
