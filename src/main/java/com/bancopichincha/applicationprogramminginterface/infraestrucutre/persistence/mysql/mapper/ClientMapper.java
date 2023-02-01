package com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.mapper;

import com.bancopichincha.applicationprogramminginterface.domain.model.Client;
import com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.entity.ClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper {

    ClientMapper CLIENT_INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(source = "client.clientId", target = "clientId")
    @Mapping(source = "client.password", target = "password")
    @Mapping(source = "client.state", target = "state")
    //Person
    @Mapping(source = "client.id", target = "person.id")
    @Mapping(source = "client.name", target = "person.name")
    @Mapping(source = "client.gender", target = "person.gender")
    @Mapping(source = "client.age", target = "person.age")
    @Mapping(source = "client.address", target = "person.address")
    @Mapping(source = "client.phone", target = "person.phone")
    ClientDto clientToClientDto(Client client);

    @Mapping(source = "clientDto.clientId", target = "clientId")
    @Mapping(source = "clientDto.password", target = "password")
    @Mapping(source = "clientDto.state", target = "state")
    //Person
    @Mapping(source = "clientDto.person.id", target = "id")
    @Mapping(source = "clientDto.person.name", target = "name")
    @Mapping(source = "clientDto.person.gender", target = "gender")
    @Mapping(source = "clientDto.person.age", target = "age")
    @Mapping(source = "clientDto.person.address", target = "address")
    @Mapping(source = "clientDto.person.phone", target = "phone")
    Client clientDtoToClient(ClientDto clientDto);

    List<Client> listClientDtoToListClient(List<ClientDto> clientDtoList);
    List<ClientDto> listClientToListClientDto(List<Client> clientList);

}
