package com.bancopichincha.applicationprogramminginterface.domain.usecase;

import com.bancopichincha.applicationprogramminginterface.domain.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionUseCase {
    List<Transaction> getTransactions();
    Optional<Transaction> getTransaction(String id);
    Transaction saveTransaction (Transaction transaction);
    void deleteTransaction(Transaction transaction);
}
