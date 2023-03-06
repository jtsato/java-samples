package org.example.service;

import org.apache.commons.lang3.StringUtils;
import org.example.model.AccountType;

public class AccountValidatorService {

    private static final String INDIVIDUAL_ACCOUNT_NUMBER_PREFIX = "10";
    private static final String LEGAL_ENTITY_ACCOUNT_NUMBER_PREFIX = "20";
    private static final String INVALID_ACCOUNT_MESSAGE = "Invalid account information";

    public void validate(final AccountType accountType, final String bankName, final String accountNumber) {

        if (accountType == AccountType.INDIVIDUAL) {
            validateIndividualAccount(accountType, bankName, accountNumber);
            return;
        }

        validateLegalEntityAccount(accountType, bankName, accountNumber);
    }

    private void validateIndividualAccount(final AccountType accountType, final String bankName, final String accountNumber){

        validateRequiredFields(bankName, accountNumber);

        if (accountType == AccountType.INDIVIDUAL && (!startWithIndividualAccountNumberPrefix(accountNumber))) {
            throw new IllegalArgumentException(INVALID_ACCOUNT_MESSAGE);
        }
    }

    private void validateRequiredFields(String bankName, String accountNumber) {

        if (StringUtils.isBlank(bankName) || StringUtils.isBlank(accountNumber)) {
            throw new IllegalArgumentException(INVALID_ACCOUNT_MESSAGE);
        }

        if (!StringUtils.isNumeric(accountNumber)) {
            throw new IllegalArgumentException(INVALID_ACCOUNT_MESSAGE);
        }
    }

    private void validateLegalEntityAccount(final AccountType accountType, final String bankName, final String accountNumber){
        validateRequiredFields(bankName, accountNumber);

        if (accountType == AccountType.LEGAL_ENTITY && (!startWithLegalEntityAccountNumberPrefix(accountNumber))) {
            throw new IllegalArgumentException(INVALID_ACCOUNT_MESSAGE);
        }
    }

    private boolean startWithIndividualAccountNumberPrefix(final String accountNumber){
        return accountNumber.startsWith(INDIVIDUAL_ACCOUNT_NUMBER_PREFIX);
    }

    private boolean startWithLegalEntityAccountNumberPrefix(final String accountNumber){
        return accountNumber.startsWith(LEGAL_ENTITY_ACCOUNT_NUMBER_PREFIX);
    }
}
