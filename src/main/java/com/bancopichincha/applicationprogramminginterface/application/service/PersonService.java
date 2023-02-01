package com.bancopichincha.applicationprogramminginterface.application.service;

import com.bancopichincha.applicationprogramminginterface.domain.gateway.PersonGateway;
import com.bancopichincha.applicationprogramminginterface.domain.model.Person;
import com.bancopichincha.applicationprogramminginterface.domain.usecase.PersonUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PersonService implements PersonUseCase {

    private final PersonGateway personGateway;

    @Override
    public List<Person> getAllPeople() {
        return personGateway.getAllPeople();
    }

    @Override
    public Optional<Person> getPerson(Long id) {
        return personGateway.getPerson(id);
    }

    @Override
    public Person savePerson(Person person) {
        return personGateway.savePerson(person);
    }

    @Override
    public void deletePerson(Person person) {
        personGateway.deletePerson(person);
    }
}
