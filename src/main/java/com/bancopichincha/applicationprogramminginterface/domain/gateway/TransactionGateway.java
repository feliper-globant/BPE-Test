package com.bancopichincha.applicationprogramminginterface.domain.gateway;

import com.bancopichincha.applicationprogramminginterface.domain.model.Transaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionGateway {
    List<Transaction> getTransactions();
    Optional<Transaction> getTransaction(String id);
    Transaction saveTransaction (Transaction transaction);
    void deleteTransaction(Transaction transaction);
}
