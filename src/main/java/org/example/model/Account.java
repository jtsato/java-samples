package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Generated
public class Account {

    private AccountType accountType;
    private String bankName;
    private Integer accountNumber;

    public String toString() {
        return "Account Type: " + accountType + "Bank Name: " + bankName + " Account Number: " + accountNumber;
    }
}