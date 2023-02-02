package com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.repository;

import com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.entity.ClientDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<ClientDto, String> {
}
