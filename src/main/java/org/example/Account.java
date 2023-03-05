package org.example;

public record Account(String bankName, String accountNumber) {

    public String toString() {
        return "Bank Name: " + bankName + " Account Number: " + accountNumber;
    }
}
