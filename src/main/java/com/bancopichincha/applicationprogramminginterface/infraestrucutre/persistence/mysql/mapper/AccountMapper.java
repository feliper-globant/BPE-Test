package com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.mapper;

import com.bancopichincha.applicationprogramminginterface.domain.model.Account;
import com.bancopichincha.applicationprogramminginterface.domain.model.Transaction;
import com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.entity.AccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper
public interface AccountMapper {

    AccountMapper ACCOUNT_INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Mapping(source = "account.number", target = "number")
    @ValueMapping(source = "account.type", target = "type")
    @Mapping(source = "account.initialBalance", target = "initialBalance")
    @ValueMapping(source = "account.state", target = "state")
    AccountDto accountToAccountDto(Account account);

    @Mapping(source = "account.number", target = "number")
    @Mapping(source = "account.type", target = "type")
    @Mapping(source = "account.initialBalance", target = "initialBalance")
    @Mapping(source = "account.state", target = "state")
    @Mapping(source = "transactions", target = "transactions")
    AccountDto accountToAccountDtoWithTransaction(Account account, Set<Transaction> transactions);

    @Mapping(source = "accountDto.number", target = "number")
    @Mapping(source = "accountDto.type", target = "type")
    @Mapping(source = "accountDto.initialBalance", target = "initialBalance")
    @Mapping(source = "accountDto.state", target = "state")
    Account accountDtoToAccount(AccountDto accountDto);

    List<Account> listAccountDtoToListAccount(List<AccountDto> accountDtoList);
    List<AccountDto> listAccountToListAccountDto(List<Account> accountList);

}
