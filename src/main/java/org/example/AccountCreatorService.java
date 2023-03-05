package org.example;

public class AccountCreatorService
{
    public Account create(String bankName, String accountNumber)
    {
        AccountValidatorService accountValidator = new AccountValidatorService();
        accountValidator.validate(bankName, accountNumber);
        return new Account(bankName, accountNumber);
    }
}
