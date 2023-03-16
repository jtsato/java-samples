package org.example.service;

import org.example.model.AccountType;

// 01 SRP: Single Responsibility Principle
public class LegalEntityAccountValidatorService implements IAccountValidatorService {

    private static final String LEGAL_ENTITY_ACCOUNT_NUMBER_PREFIX = "20";

    public void validate(final AccountType accountType, final String bankName, final String accountNumber) {
        validateLegalEntityAccount(accountType, bankName, accountNumber);
    }

    private void validateLegalEntityAccount(final AccountType accountType, final String bankName, final String accountNumber){
        validateRequiredFields(bankName, accountNumber);

        if (accountType == AccountType.LEGAL_ENTITY && (!startWithLegalEntityAccountNumberPrefix(accountNumber))) {
            throw new IllegalArgumentException(INVALID_ACCOUNT_MESSAGE);
        }
    }

    private boolean startWithLegalEntityAccountNumberPrefix(final String accountNumber){
        return accountNumber.startsWith(LEGAL_ENTITY_ACCOUNT_NUMBER_PREFIX);
    }
}
