package com.bancopichincha.applicationprogramminginterface.application.service;

import com.bancopichincha.applicationprogramminginterface.domain.gateway.TransactionGateway;
import com.bancopichincha.applicationprogramminginterface.domain.model.Transaction;
import com.bancopichincha.applicationprogramminginterface.domain.usecase.TransactionUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class TransactionService implements TransactionUseCase {

    private final TransactionGateway transactionGateway;

    @Override
    public List<Transaction> getTransactions() {
        return transactionGateway.getTransactions();
    }

    @Override
    public Optional<Transaction> getTransaction(String id) {
        return transactionGateway.getTransaction(id);
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionGateway.saveTransaction(transaction);
    }

    @Override
    public void deleteTransaction(Transaction transaction) {
        transactionGateway.deleteTransaction(transaction);
    }

}
