package com.bancopichincha.applicationprogramminginterface.application.service;

import com.bancopichincha.applicationprogramminginterface.domain.gateway.PersonGateway;
import com.bancopichincha.applicationprogramminginterface.domain.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonGateway personGateway;

    @InjectMocks
    private PersonService personService;

    @Test
    public void testGetAllPeople() {
        List<Person> expected = Collections.singletonList(new Person());
        when(personGateway.getAllPeople()).thenReturn(expected);
        List<Person> result = personService.getAllPeople();
        assertEquals(expected, result);
        verify(personGateway, times(1)).getAllPeople();
    }

    @Test
    public void testGetPerson() {
        Long id = 1L;
        Person expected = new Person();
        when(personGateway.getPerson(id)).thenReturn(Optional.of(expected));
        Optional<Person> result = personService.getPerson(id);
        assertEquals(expected, result.get());
        verify(personGateway, times(1)).getPerson(id);
    }

    @Test
    public void testSavePerson() {
        Person expected = new Person();
        when(personGateway.savePerson(expected)).thenReturn(expected);
        Person result = personService.savePerson(expected);
        assertEquals(expected, result);
        verify(personGateway, times(1)).savePerson(expected);
    }

    @Test
    public void testDeletePerson() {
        Person expected = new Person();
        personService.deletePerson(expected);
        verify(personGateway, times(1)).deletePerson(expected);
    }
}
