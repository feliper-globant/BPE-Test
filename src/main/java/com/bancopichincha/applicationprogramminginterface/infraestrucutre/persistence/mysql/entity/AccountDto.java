package com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

    @Column(name = "balance", nullable = false)
    private Double balance;

    @Column(name = "state", updatable = false, nullable = false)
    private String state;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private ClientDto client;

    @OneToMany(mappedBy="account")
    private Set<TransactionDto> transactions;

}
