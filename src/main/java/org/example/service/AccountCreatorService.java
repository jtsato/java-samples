package org.example.service;

import org.example.model.Account;
import org.example.model.AccountType;

public class AccountCreatorService
{
    private final IAccountValidatorService validatorService;

    // 05 DIP: Dependency Inversion Principle
    public AccountCreatorService(IAccountValidatorService validatorService)
    {
        this.validatorService = validatorService;
    }

    public Account create(AccountType accountType, String bankName, String accountNumber)
    {
        validatorService.validate(accountType, bankName, accountNumber);
        return new Account(accountType, bankName, Integer.parseInt(accountNumber));
    }
}
