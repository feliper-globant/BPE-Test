package com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.mapper;

import com.bancopichincha.applicationprogramminginterface.domain.model.Transaction;
import com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.entity.TransactionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TransactionMapper {

    TransactionMapper TRANSACTION_INSTANCE = Mappers.getMapper(TransactionMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "value", target = "value")
    @Mapping(source = "balance", target = "balance")
    @Mapping(source = "initialBalance", target = "initialBalance")
    @Mapping(source = "number", target = "account.number")
    TransactionDto transactionToTransactionDto(Transaction transaction);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "value", target = "value")
    @Mapping(source = "balance", target = "balance")
    @Mapping(source = "initialBalance", target = "initialBalance")
    @Mapping(source = "account.number", target = "number")
    Transaction transactionDtoToTransaction(TransactionDto transactionDto);

    List<Transaction> listTransactionDtoToListTransaction(List<TransactionDto> transactionDtoList);
    List<TransactionDto> listTransactionToListTransactionDto(List<Transaction> transactionList);

}
