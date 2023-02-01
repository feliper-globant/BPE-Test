package com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "client")
@NoArgsConstructor
public class ClientDto {

    @Id
    @Column(name = "client_id", length=36)
    private String clientId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "state", length=36, columnDefinition = "varchar(60)")
    private String state;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private PersonDto person;

}
