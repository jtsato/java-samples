package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Account {

    private AccountType accountType;
    private String bankName;
    private Integer accountNumber;

    public String toString() {
        return "Account Type: " + accountType + "Bank Name: " + bankName + " Account Number: " + accountNumber;
    }
}
