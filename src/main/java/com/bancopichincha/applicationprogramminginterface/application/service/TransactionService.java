package com.bancopichincha.applicationprogramminginterface.application.service;

import com.bancopichincha.applicationprogramminginterface.domain.excepotion.BusinessException;
import com.bancopichincha.applicationprogramminginterface.domain.gateway.AccountGateway;
import com.bancopichincha.applicationprogramminginterface.domain.gateway.TransactionGateway;
import com.bancopichincha.applicationprogramminginterface.domain.model.Transaction;
import com.bancopichincha.applicationprogramminginterface.domain.model.TransactionType;
import com.bancopichincha.applicationprogramminginterface.domain.usecase.TransactionUseCase;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class TransactionService implements TransactionUseCase {

    private final TransactionGateway transactionGateway;

    private final AccountGateway accountGateway;

    @Override
    public List<Transaction> getTransactions() {
        return transactionGateway.getTransactions();
    }

    @Override
    public List<Transaction> getTransactionsByAccountNumberBetweenDates(Long number, Long start, Long end) {
        return transactionGateway.getTransactionsByAccountNumberBetweenDates(number, new Date(start), new Date(end));
    }

    @Override
    public List<Transaction> getTransactionsByAccountNumber(Long number) {
        return transactionGateway.getTransactionsByAccountNumber(number);
    }

    @Override
    public Optional<Transaction> getTransaction(String id) {
        return transactionGateway.getTransaction(id);
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {

        if (!Arrays.stream(TransactionType.values())
                .anyMatch(transactionType -> transactionType.name().equalsIgnoreCase(transaction.getType()))
        ) throw new BusinessException("Invalid transaction, the transaction type must be " + Arrays.toString(TransactionType.values()) + ".");

        var account = accountGateway.getAccount(transaction.getNumber());

        if (!account.isPresent()) throw new BusinessException("Account was not found.");

        var currentBalance = getBalance(account.get().getNumber());

        transaction.setInitialBalance(currentBalance);

        if (currentBalance <= ((double) 0) && TransactionType.DEBIT.name().equalsIgnoreCase(transaction.getType()))
            throw new BusinessException("Insufficient balance");

        if (TransactionType.CREDIT.name().equalsIgnoreCase(transaction.getType())){
            currentBalance += transaction.getValue();
        }else{
            currentBalance -= transaction.getValue();
        }

        transaction.setBalance(currentBalance);
        transaction.setId(UUID.randomUUID().toString());
        transaction.setDate(new Date());

        account.get().setBalance(currentBalance);
        accountGateway.saveAccount(account.get());
        return transactionGateway.saveTransaction(transaction);
    }

    @Override
    public void deleteTransaction(Transaction transaction) {
        transactionGateway.deleteTransaction(transaction);
    }

    @Override
    public Double getBalance(Long number) {

        Double balance;
        var lastTransaction = transactionGateway.getLastTransactionByNumber(number);
        if (lastTransaction.isPresent()) {
            balance = lastTransaction.get().getBalance();
        }else{
            var account = accountGateway.getAccount(number);
            if (account.isPresent()){
                balance = account.get().getBalance();
            }else{
                throw new RuntimeException("Error loading account balance, try again.");
            }
        }

        return balance;

    }

}
