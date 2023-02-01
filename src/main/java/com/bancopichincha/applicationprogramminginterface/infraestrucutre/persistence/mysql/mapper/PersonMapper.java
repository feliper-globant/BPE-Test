package com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.mapper;

import com.bancopichincha.applicationprogramminginterface.domain.model.Person;
import com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.entity.PersonDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PersonMapper {

    PersonMapper PERSON_INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "phone", target = "phone")
    PersonDto personToPersonDto(Person person);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "phone", target = "phone")
    Person personDtoToPerson(PersonDto personDto);

    List<PersonDto> listPersonToListPersonDto(List<Person> personList);
    List<Person> listPersonDtoToListPerson(List<PersonDto> personDtoList);

}
