package org.example.service;

import org.example.model.AccountType;

// 01 SRP: Single Responsibility Principle
public class IndividualAccountValidatorService implements IIndividualAccountValidatorService {

    private static final String INDIVIDUAL_ACCOUNT_NUMBER_PREFIX = "10";

    public void validate(final AccountType accountType, final String bankName, final String accountNumber) {
        validateIndividualAccount(bankName, accountNumber);
    }

    @Override
    public boolean startWithIndividualAccountNumberPrefix(final String accountNumber){
        return accountNumber.startsWith(INDIVIDUAL_ACCOUNT_NUMBER_PREFIX);
    }
}
