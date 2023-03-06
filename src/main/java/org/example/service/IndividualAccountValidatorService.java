package org.example.service;

import org.example.model.AccountType;

// SRP: Single Responsibility Principle
public class IndividualAccountValidatorService implements IAccountValidatorService {

    private static final String INDIVIDUAL_ACCOUNT_NUMBER_PREFIX = "10";

    public void validate(final AccountType accountType, final String bankName, final String accountNumber) {
        validateIndividualAccount(accountType, bankName, accountNumber);
    }

    private void validateIndividualAccount(final AccountType accountType, final String bankName, final String accountNumber){

        validateRequiredFields(bankName, accountNumber);

        if (accountType == AccountType.INDIVIDUAL && (!startWithIndividualAccountNumberPrefix(accountNumber))) {
            throw new IllegalArgumentException(INVALID_ACCOUNT_MESSAGE);
        }
    }

    private boolean startWithIndividualAccountNumberPrefix(final String accountNumber){
        return accountNumber.startsWith(INDIVIDUAL_ACCOUNT_NUMBER_PREFIX);
    }
}
