package com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.service;

import com.bancopichincha.applicationprogramminginterface.domain.gateway.PersonGateway;
import com.bancopichincha.applicationprogramminginterface.domain.model.Person;
import com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.mapper.PersonMapper;
import com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonMysqlService implements PersonGateway {

    @Autowired
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.PERSON_INSTANCE;

    @Override
    public List<Person> getAllPeople() {
        return personMapper.listPersonDtoToListPerson(personRepository.findAll());
    }

    @Override
    public Optional<Person> getPerson(Long id) {
        return Optional.ofNullable(
                personMapper.personDtoToPerson(
                        personRepository.getById(id)
                )
        );
    }

    @Override
    public Person savePerson(Person person) {
        personRepository.save(personMapper.personToPersonDto(person));
        return person;
    }

    @Override
    public void deletePerson(Person person) {
        personRepository.delete(personMapper.personToPersonDto(person));
    }
}
