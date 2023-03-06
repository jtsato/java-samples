package org.example;

import org.example.model.Account;
import org.example.model.AccountType;
import org.example.service.AccountCreatorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Account Creator Service Test")
class AccountCreatorServiceTest {

    @ParameterizedTest
    @DisplayName("Should create account successfully when valid bank name and account number are provided")
    @CsvSource({
            "LEGAL_ENTITY,Santander,203040506",
            "LEGAL_ENTITY,Santander,203040507",
            "INDIVIDUAL,Santander,102030405",
    })
    void shouldCreateAccount(AccountType accountType, String bankName, String accountNumber) {
        AccountCreatorService accountCreator = new AccountCreatorService();
        Account account = accountCreator.create(accountType, bankName, accountNumber);
        assertThat(account).isNotNull();
        assertThat(account.getBankName()).isEqualTo(bankName);
        assertThat(account.getAccountNumber()).isEqualTo(Integer.parseInt(accountNumber));
    }

    @ParameterizedTest
    @DisplayName("Should throw exception when invalid account number is provided")
    @CsvSource({
            "INDIVIDUAL,Santander,",
            "INDIVIDUAL,,102030405a",
            "INDIVIDUAL,Santander,203040507",
            "LEGAL_ENTITY,Santander,102030405",
            "LEGAL_ENTITY,Santander,20E040506",
    })
    void shouldThrowExceptionWhenInvalidAccountNumber(AccountType accountType, String bankName, String accountNumber) {
        AccountCreatorService accountCreator = new AccountCreatorService();
        try {
            accountCreator.create(accountType, bankName, accountNumber);
        } catch (IllegalArgumentException exception) {
            assertThat(exception.getMessage()).isEqualTo("Invalid account information");
        }
    }
}
