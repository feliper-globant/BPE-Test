package com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.repository;

import com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.entity.PersonDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonDto,Long> {
}
