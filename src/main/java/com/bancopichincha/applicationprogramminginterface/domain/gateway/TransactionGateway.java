package com.bancopichincha.applicationprogramminginterface.domain.gateway;

import com.bancopichincha.applicationprogramminginterface.domain.model.Transaction;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TransactionGateway {
    List<Transaction> getTransactions();
    List<Transaction> getTransactionsByAccountNumberBetweenDates(Long number, Date start, Date end);

    List<Transaction> getTransactionsByAccountNumber(Long number);
    Optional<Transaction> getTransaction(String id);
    Transaction saveTransaction (Transaction transaction);
    void deleteTransaction(Transaction transaction);
    Optional<Transaction> getLastTransactionByNumber(Long number);
}
