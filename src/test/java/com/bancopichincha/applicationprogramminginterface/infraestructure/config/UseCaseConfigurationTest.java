package com.bancopichincha.applicationprogramminginterface.infraestructure.config;

import com.bancopichincha.applicationprogramminginterface.application.service.AccountService;
import com.bancopichincha.applicationprogramminginterface.application.service.ClientService;
import com.bancopichincha.applicationprogramminginterface.application.service.PersonService;
import com.bancopichincha.applicationprogramminginterface.application.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UseCaseConfigurationTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void testBeans() {
        assertThat(context.getBean(AccountService.class)).isNotNull();
        assertThat(context.getBean(ClientService.class)).isNotNull();
        assertThat(context.getBean(PersonService.class)).isNotNull();
        assertThat(context.getBean(TransactionService.class)).isNotNull();
    }

}

