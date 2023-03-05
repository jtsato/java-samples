package org.example;

public class AccountValidatorService
{
    public void validate(String bankName, String accountNumber)
    {
        if (bankName == null || accountNumber == null || bankName.length() == 0 || accountNumber.length() == 0) {
            throw new IllegalArgumentException("Invalid account information");
        }
    }
}
