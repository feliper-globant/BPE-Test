package com.bancopichincha.applicationprogramminginterface.infraestrucutre.http.rest.dto.response;

import com.bancopichincha.applicationprogramminginterface.domain.model.Account;
import com.bancopichincha.applicationprogramminginterface.domain.model.Client;
import com.bancopichincha.applicationprogramminginterface.domain.model.Transaction;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class Report {

    private Date date;
    private String name;
    private Long number;
    private String type;
    private Double initialBalance;
    private String state;
    private Double value;
    private Double balance;

    public static List<Report> listReport(Client client, Account account, List<Transaction> transactionList){
        return transactionList.stream().map(transaction ->
                    Report.builder()
                            .date(transaction.getDate())
                            .name(client.getName())
                            .number(account.getNumber())
                            .type(account.getType())
                            .initialBalance(transaction.getInitialBalance())
                            .state(account.getState())
                            .value(transaction.getValue())
                            .balance(account.getBalance())
                            .build()
        ).collect(Collectors.toList());
    }

}
