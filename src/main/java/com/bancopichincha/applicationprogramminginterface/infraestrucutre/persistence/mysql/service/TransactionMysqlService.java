package com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.service;

import com.bancopichincha.applicationprogramminginterface.domain.gateway.TransactionGateway;
import com.bancopichincha.applicationprogramminginterface.domain.model.Transaction;
import com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.mapper.TransactionMapper;
import com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionMysqlService implements TransactionGateway {

    @Autowired
    private TransactionRepository transactionRepository;

    private final TransactionMapper transactionMapper = TransactionMapper.TRANSACTION_INSTANCE;

    @Override
    public List<Transaction> getTransactions() {
        return transactionMapper.listTransactionDtoToListTransaction(
                transactionRepository.findAll()
        );
    }

    @Override
    public Optional<Transaction> getTransaction(String id) {
        return Optional.ofNullable(
                transactionMapper.transactionToTransactionDto(
                        transactionRepository.findById(id).get()
                )
        );
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        transactionRepository.save(transactionMapper.transactionToTransactionDto(transaction));
        return transaction;
    }

    @Override
    public void deleteTransaction(Transaction transaction) {
        transactionRepository.delete(transactionMapper.transactionToTransactionDto(transaction));
    }
}
