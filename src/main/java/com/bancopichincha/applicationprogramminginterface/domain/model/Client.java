package com.bancopichincha.applicationprogramminginterface.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Client extends Person {
    @NonNull
    private String clientId = UUID.randomUUID().toString();
    @NonNull
    private String password;
    private String state;
}
