package com.bancopichincha.applicationprogramminginterface.infraestructure.http.rest.dto.response;

import com.bancopichincha.applicationprogramminginterface.domain.model.Account;
import com.bancopichincha.applicationprogramminginterface.domain.model.Client;
import com.bancopichincha.applicationprogramminginterface.domain.model.Transaction;
import com.bancopichincha.applicationprogramminginterface.infraestrucutre.http.rest.dto.response.Report;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReportTest {

    @Test
    void testListReport() {
        Client client = Client.builder()
                .id(23323L)
                .name("John Doe")
                .gender("male")
                .age(34)
                .address("Street 1")
                .password("knsfj24")
                .phone("4324234")
                .clientId("234243lnfksjn")
                .build();

        Account account = Account.builder()
                .number(1234567890L)
                .type("Checking")
                .state("Active")
                .balance(1000.0)
                .build();

        Transaction transaction1 = new Transaction();
        transaction1.setDate(new Date());
        transaction1.setInitialBalance(1000.0);
        transaction1.setValue(100.0);

        Transaction transaction2 = new Transaction();
        transaction2.setDate(new Date());
        transaction2.setInitialBalance(900.0);
        transaction2.setValue(-50.0);

        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction1);
        transactionList.add(transaction2);

        List<Report> reports = Report.listReport(client, account, transactionList);

        assertNotNull(reports);
        assertEquals(2, reports.size());

        Report report1 = reports.get(0);
        assertEquals(client.getName(), report1.getName());
        assertEquals(account.getNumber(), report1.getNumber());
        assertEquals(account.getType(), report1.getType());
        assertEquals(transaction1.getInitialBalance(), report1.getInitialBalance());
        assertEquals(account.getState(), report1.getState());
        assertEquals(transaction1.getValue(), report1.getValue());
        assertEquals(account.getBalance(), report1.getBalance());

        Report report2 = reports.get(1);
        assertEquals(client.getName(), report2.getName());
        assertEquals(account.getNumber(), report2.getNumber());
        assertEquals(account.getType(), report2.getType());
        assertEquals(transaction2.getInitialBalance(), report2.getInitialBalance());
        assertEquals(account.getState(), report2.getState());
        assertEquals(transaction2.getValue(), report2.getValue());
        assertEquals(account.getBalance(), report2.getBalance());
    }
}

