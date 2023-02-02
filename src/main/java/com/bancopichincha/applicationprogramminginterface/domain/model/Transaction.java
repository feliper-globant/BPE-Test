package com.bancopichincha.applicationprogramminginterface.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Transaction {
    @NonNull
    private String id = UUID.randomUUID().toString();
    @NonNull
    private Long number;
    private Date date = new Date();
    private String type;
    private Double value;
    private Double balance;
    private Double initialBalance;
}
