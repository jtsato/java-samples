package org.example.service;

// 04 ISP: Interface Segregation Principle
public interface IIndividualAccountValidatorService extends IAccountValidatorService {

    default void validateIndividualAccount(final String bankName, final String accountNumber){

        validateRequiredFields(bankName, accountNumber);

        if (!startWithIndividualAccountNumberPrefix(accountNumber)) {
            throw new IllegalArgumentException(INVALID_ACCOUNT_MESSAGE);
        }
    }

    boolean startWithIndividualAccountNumberPrefix(String accountNumber);
}
