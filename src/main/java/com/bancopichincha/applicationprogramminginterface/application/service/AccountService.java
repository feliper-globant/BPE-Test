package com.bancopichincha.applicationprogramminginterface.application.service;

import com.bancopichincha.applicationprogramminginterface.domain.gateway.AccountGateway;
import com.bancopichincha.applicationprogramminginterface.domain.model.Account;
import com.bancopichincha.applicationprogramminginterface.domain.usecase.AccountUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class AccountService implements AccountUseCase {

    private final AccountGateway accountGateway;

    @Override
    public List<Account> getAccounts() {
        return accountGateway.getAccounts();
    }

    @Override
    public Optional<Account> getAccount(Long number) {
        return accountGateway.getAccount(number);
    }

    @Override
    public Optional<Account> getAccountByClientClientId(String clientId) {
        return accountGateway.getAccountByClientClientId(clientId);
    }

    @Override
    public Account saveAccount(Account account) {
        return accountGateway.saveAccount(account);
    }

    @Override
    public void deleteAccount(Account account) {
        accountGateway.deleteAccount(account);
    }
}
