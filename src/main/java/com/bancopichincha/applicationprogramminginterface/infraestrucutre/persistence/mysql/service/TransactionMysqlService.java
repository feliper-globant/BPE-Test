package com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.service;

import com.bancopichincha.applicationprogramminginterface.domain.gateway.TransactionGateway;
import com.bancopichincha.applicationprogramminginterface.domain.model.Transaction;
import com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.mapper.TransactionMapper;
import com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public List<Transaction> getTransactionsByAccountNumberBetweenDates(Long number, Date start, Date end) {
        return transactionMapper.listTransactionDtoToListTransaction(
                transactionRepository.getTransactionsByAccountNumberBetweenDates(number, start, end)
        );
    }

    @Override
    public List<Transaction> getTransactionsByAccountNumber(Long number) {
        return transactionMapper.listTransactionDtoToListTransaction(transactionRepository.findAllByAccountNumber(number));
    }

    @Override
    public Optional<Transaction> getTransaction(String id) {
        return Optional.ofNullable(
                transactionMapper.transactionDtoToTransaction(
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

    @Override
    public Optional<Transaction> getLastTransactionByNumber(Long number) {
        return Optional.ofNullable(
                transactionMapper.transactionDtoToTransaction(
                        transactionRepository.findFirstByAccountNumberOrderByDateDesc(number)
                )
        );
    }
}
