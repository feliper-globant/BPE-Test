package com.bancopichincha.applicationprogramminginterface.application.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bancopichincha.applicationprogramminginterface.domain.gateway.AccountGateway;
import com.bancopichincha.applicationprogramminginterface.domain.gateway.TransactionGateway;
import com.bancopichincha.applicationprogramminginterface.domain.model.Transaction;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    @Mock
    private TransactionGateway transactionGateway;

    @Mock
    private AccountGateway accountGateway;

    @InjectMocks
    private TransactionService transactionService;

    @Test
    void testGetTransactions() {
        when(transactionGateway.getTransactions()).thenReturn(Arrays.asList(new Transaction(), new Transaction()));
        assertEquals(2, transactionService.getTransactions().size());
        verify(transactionGateway).getTransactions();
    }

    @Test
    void testGetTransactionsByAccountNumberBetweenDates() {
        when(transactionGateway.getTransactionsByAccountNumberBetweenDates(anyLong(), any(Date.class), any(Date.class))).thenReturn(Arrays.asList(new Transaction(), new Transaction()));
        assertEquals(2, transactionService.getTransactionsByAccountNumberBetweenDates(1L, 2L, 3L).size());
        verify(transactionGateway).getTransactionsByAccountNumberBetweenDates(anyLong(), any(Date.class), any(Date.class));
    }

    @Test
    void testGetTransactionsByAccountNumber() {
        when(transactionGateway.getTransactionsByAccountNumber(anyLong())).thenReturn(Arrays.asList(new Transaction(), new Transaction()));
        assertEquals(2, transactionService.getTransactionsByAccountNumber(1L).size());
        verify(transactionGateway).getTransactionsByAccountNumber(anyLong());
    }

    @Test
    void testGetTransaction() {
        when(transactionGateway.getTransaction(anyString())).thenReturn(Optional.of(new Transaction()));
        assertTrue(transactionService.getTransaction("1").isPresent());
        verify(transactionGateway).getTransaction(anyString());
    }
}
