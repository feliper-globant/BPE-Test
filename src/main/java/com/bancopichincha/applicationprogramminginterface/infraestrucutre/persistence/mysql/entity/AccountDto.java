package com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@Entity
@Table(name = "account")
public class AccountDto {

    @Id
    @Column(name = "number", updatable = false, nullable = false, unique = true)
    private Long number;

    @Column(name = "type", updatable = false, nullable = false)
    private String type;

    @Column(name = "initial_balance", nullable = false)
    private Double initialBalance;

    @Column(name = "state", updatable = false, nullable = false)
    private String state;

    @OneToMany(mappedBy="account")
    private Set<TransactionDto> transactions;

}
