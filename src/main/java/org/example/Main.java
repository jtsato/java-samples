package org.example;

public class Main {
    public static void main(String[] args) {

        AccountCreatorService accountCreator = new AccountCreatorService();
        Account account = accountCreator.create("Bank of America", "123456789");
        System.out.println(account);

        try {
            accountCreator.create("Bank of America", "");
        } catch (IllegalArgumentException exception) {
            System.out.println("Exception caught: " + exception.getMessage());
        }

        try {
            accountCreator.create("", "123456789");
        } catch (IllegalArgumentException exception) {
            System.out.println("Exception caught: " + exception.getMessage());
        }
    }
}
