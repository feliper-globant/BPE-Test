package com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.repository;

import com.bancopichincha.applicationprogramminginterface.domain.model.Transaction;
import com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.entity.TransactionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionDto, String> {
    List<TransactionDto> findAllByAccountNumber(Long number);
    TransactionDto findFirstByAccountNumberOrderByDateDesc(Long number);
    @Query( value = "SELECT * FROM `transaction` WHERE `transaction`.`number` = :number AND `transaction`.`date` BETWEEN :end AND :start ;", nativeQuery = true)
    List<TransactionDto> getTransactionsByAccountNumberBetweenDates(Long number, Date start, Date end);

}
