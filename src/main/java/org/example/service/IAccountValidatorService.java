package org.example.service;

import org.apache.commons.lang3.StringUtils;
import org.example.model.AccountType;

// 02 OCP: Open-Closed Principle
public interface IAccountValidatorService {

    String INVALID_ACCOUNT_MESSAGE = "Invalid account information";

    void validate(AccountType accountType, String bankName, String accountNumber);

    default void validateRequiredFields(String bankName, String accountNumber) {

        if (StringUtils.isBlank(bankName) || StringUtils.isBlank(accountNumber)) {
            throw new IllegalArgumentException(INVALID_ACCOUNT_MESSAGE);
        }

        if (!StringUtils.isNumeric(accountNumber)) {
            throw new IllegalArgumentException(INVALID_ACCOUNT_MESSAGE);
        }
    }
}
