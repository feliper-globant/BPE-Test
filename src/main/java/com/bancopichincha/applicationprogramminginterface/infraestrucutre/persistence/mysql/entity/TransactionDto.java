package com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "transaction")
@NoArgsConstructor
public class TransactionDto {

    @Id
    @Column(name = "id", length=36 )
    private String id;

    @Column(name = "date")
    @CreationTimestamp
    private Date date;

    @Column(name = "type", updatable = false, nullable = false)
    private String type;

    @Column(name = "value", updatable = false, nullable = false, columnDefinition = "DOUBLE default 0")
    private Double value;

    @Column(name = "balance", updatable = false, nullable = false, columnDefinition = "DOUBLE default 0")
    private Double balance;

    @ManyToOne
    @JoinColumn(name="number", nullable=false)
    private AccountDto account;
}
