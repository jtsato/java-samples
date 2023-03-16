package org.example.service;

import org.example.model.AccountType;

// 04 ISP: Interface Segregation Principle Violation
public class SimpleAccountValidatorService implements IIndividualAccountValidatorService {

    private static final String INDIVIDUAL_ACCOUNT_NUMBER_PREFIX = "30";

    public void validate(final AccountType accountType, final String bankName, final String accountNumber) {
        validateIndividualAccount(bankName, accountNumber);
    }

    @Override
    public boolean startWithIndividualAccountNumberPrefix(String accountNumber) {
        return accountNumber.startsWith(INDIVIDUAL_ACCOUNT_NUMBER_PREFIX);
    }
}
