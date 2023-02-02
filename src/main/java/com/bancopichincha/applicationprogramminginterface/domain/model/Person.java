package com.bancopichincha.applicationprogramminginterface.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class Person {
    @NonNull
    private Long id = 0L;
    @NonNull
    private String name;
    @NonNull
    private String gender;
    @NonNull
    private Integer age;
    @NonNull
    private String address;
    @NonNull
    private String phone;
}
