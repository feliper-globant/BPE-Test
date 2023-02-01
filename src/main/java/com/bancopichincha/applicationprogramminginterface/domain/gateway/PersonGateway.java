package com.bancopichincha.applicationprogramminginterface.domain.gateway;

import com.bancopichincha.applicationprogramminginterface.domain.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonGateway {
    List<Person> getAllPeople();
    Optional<Person> getPerson (Long id);
    Person savePerson (Person person);
    void deletePerson(Person person);
}
