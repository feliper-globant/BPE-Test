package com.bancopichincha.applicationprogramminginterface.application.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import com.bancopichincha.applicationprogramminginterface.domain.gateway.AccountGateway;
import com.bancopichincha.applicationprogramminginterface.domain.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AccountServiceTest {

    private AccountGateway accountGateway;
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        accountGateway = Mockito.mock(AccountGateway.class);
        accountService = new AccountService(accountGateway);
    }

    @Test
    void testGetAccounts() {
        List<Account> expected = List.of(Account.builder().build());
        Mockito.when(accountGateway.getAccounts()).thenReturn(expected);
        List<Account> actual = accountService.getAccounts();
        assertEquals(expected, actual);
    }

    @Test
    void testGetAccount() {
        Long number = 123L;
        Account expected = Account.builder().build();
        Mockito.when(accountGateway.getAccount(number)).thenReturn(Optional.of(expected));
        Optional<Account> actual = accountService.getAccount(number);
        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get());
    }

    @Test
    void testGetAccountByClientClientId() {
        String clientId = "client-id";
        Account expected = Account.builder().build();
        Mockito.when(accountGateway.getAccountByClientClientId(clientId)).thenReturn(Optional.of(expected));
        Optional<Account> actual = accountService.getAccountByClientClientId(clientId);
        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get());
    }

    @Test
    void testSaveAccount() {
        Account account = Account.builder()
                .balance(Double.valueOf(100000))
                .build();
        Account expected = Account.builder()
                .balance(Double.valueOf(100000))
                .build();
        Mockito.when(accountGateway.saveAccount(account)).thenReturn(expected);
        Account actual = accountService.saveAccount(account);
        assertEquals(expected, actual);
    }

    @Test
    void testDeleteAccount() {
        Account account = Account.builder().build();
        accountService.deleteAccount(account);
        Mockito.verify(accountGateway).deleteAccount(account);
    }
}

