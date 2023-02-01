package com.bancopichincha.applicationprogramminginterface.domain.usecase;

import com.bancopichincha.applicationprogramminginterface.domain.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonUseCase {
    List<Person> getAllPeople();
    Optional<Person> getPerson (Long id);
    Person savePerson (Person person);
    void deletePerson(Person person);
}
