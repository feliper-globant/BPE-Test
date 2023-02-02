package com.bancopichincha.applicationprogramminginterface.domain.gateway;

import com.bancopichincha.applicationprogramminginterface.domain.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountGateway {
    List<Account> getAccounts();
    Optional<Account> getAccount (Long number);
    Optional<Account> getAccountByClientClientId (String clientId);

    Account saveAccount (Account account);
    void deleteAccount(Account account);
}
