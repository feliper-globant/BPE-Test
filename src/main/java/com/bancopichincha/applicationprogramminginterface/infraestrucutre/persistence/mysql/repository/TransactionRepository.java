package com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.repository;

import com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.entity.TransactionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionDto, String> {
}
