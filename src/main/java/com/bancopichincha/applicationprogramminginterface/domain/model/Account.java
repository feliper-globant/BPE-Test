package com.bancopichincha.applicationprogramminginterface.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class Account {
    private Long number;
    private String type;
    private Double balance;
    private String state;
    private String clientId;
}
