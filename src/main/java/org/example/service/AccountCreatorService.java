package org.example.service;

import org.example.model.Account;
import org.example.model.AccountType;

public class AccountCreatorService
{
    public Account create(AccountType accountType, String bankName, String accountNumber)
    {
        AccountValidatorHelper.validate(accountType, bankName, accountNumber);
        return new Account(accountType, bankName, Integer.parseInt(accountNumber));
    }
}
