package com.bancopichincha.applicationprogramminginterface.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class Account {
    @NonNull
    private Long number;
    @NonNull
    private String type;
    private Double initialBalance;
    private String state;
}
