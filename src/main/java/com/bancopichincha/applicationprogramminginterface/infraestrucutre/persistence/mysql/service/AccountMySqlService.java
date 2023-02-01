package com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.service;

import com.bancopichincha.applicationprogramminginterface.domain.gateway.AccountGateway;
import com.bancopichincha.applicationprogramminginterface.domain.model.Account;
import com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.mapper.AccountMapper;
import com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountMySqlService implements AccountGateway {

    @Autowired
    private AccountRepository accountRepository;

    private final AccountMapper accountMapper = AccountMapper.ACCOUNT_INSTANCE;


    @Override
    public List<Account> getAccounts() {
        return accountMapper.listAccountDtoToListAccount(
                accountRepository.findAll()
        );
    }

    @Override
    public Optional<Account> getAccount(Long number) {
        return Optional.ofNullable(
                accountMapper.accountDtoToAccount(
                        accountRepository.getById(number)
                )
        );
    }

    @Override
    public Account saveAccount(Account account) {
        accountRepository.save(accountMapper.accountToAccountDto(account));
        return account;
    }

    @Override
    public void deleteAccount(Account account) {
        accountRepository.delete(accountMapper.accountToAccountDto(account));
    }
}
