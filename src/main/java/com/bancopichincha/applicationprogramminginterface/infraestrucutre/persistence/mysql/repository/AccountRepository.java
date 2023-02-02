package com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.repository;

import com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.entity.AccountDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountDto,Long> {
    AccountDto findByClientClientId(String clientId);
}
