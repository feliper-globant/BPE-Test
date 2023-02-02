package com.bancopichincha.applicationprogramminginterface.infraestrucutre.config;

import com.bancopichincha.applicationprogramminginterface.application.service.AccountService;
import com.bancopichincha.applicationprogramminginterface.application.service.ClientService;
import com.bancopichincha.applicationprogramminginterface.application.service.PersonService;
import com.bancopichincha.applicationprogramminginterface.application.service.TransactionService;
import com.bancopichincha.applicationprogramminginterface.domain.gateway.AccountGateway;
import com.bancopichincha.applicationprogramminginterface.domain.gateway.ClientGateway;
import com.bancopichincha.applicationprogramminginterface.domain.gateway.PersonGateway;
import com.bancopichincha.applicationprogramminginterface.domain.gateway.TransactionGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public AccountService accountService(AccountGateway accountGateway){
        return new AccountService(accountGateway);
    }

    @Bean
    public ClientService clientService(ClientGateway clientGateway){
        return new ClientService(clientGateway);
    }

    @Bean
    public PersonService personService(PersonGateway personGateway){
        return new PersonService(personGateway);
    }

    @Bean
    public TransactionService transactionService(TransactionGateway transactionGateway, AccountGateway accountGateway){
        return new TransactionService(transactionGateway, accountGateway);
    }

}
