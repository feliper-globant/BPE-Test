package com.bancopichincha.applicationprogramminginterface.domain.usecase;

import com.bancopichincha.applicationprogramminginterface.domain.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionUseCase {
    List<Transaction> getTransactions();
    List<Transaction> getTransactionsByAccountNumberBetweenDates(Long number, Long start, Long end);
    List<Transaction> getTransactionsByAccountNumber(Long number);
    Optional<Transaction> getTransaction(String id);
    Transaction saveTransaction (Transaction transaction);
    void deleteTransaction(Transaction transaction);
    Double getBalance(Long number) ;
}
