package com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.service;

import com.bancopichincha.applicationprogramminginterface.domain.gateway.ClientGateway;
import com.bancopichincha.applicationprogramminginterface.domain.model.Client;
import com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.mapper.ClientMapper;
import com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.repository.ClientRepository;
import com.bancopichincha.applicationprogramminginterface.infraestrucutre.persistence.mysql.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientMysqlService implements ClientGateway {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PersonRepository personRepository;

    private final ClientMapper clientMapper = ClientMapper.CLIENT_INSTANCE;

    @Override
    public List<Client> getClients() {
        return clientMapper.listClientDtoToListClient(clientRepository.findAll());
    }

    @Override
    public Optional<Client> getClient(String clientId) {
        return Optional.ofNullable(
                clientMapper.clientDtoToClient(
                        clientRepository.findById(clientId).orElseThrow()
                )
        );
    }

    @Override
    public Client saveClient(Client client) {
        var clientDto = clientMapper.clientToClientDto(client);
        personRepository.save(clientDto.getPerson());
        clientRepository.save(clientDto);
        return client;
    }

    @Override
    public void deleteClientByClientId(Client client) {
        clientRepository.delete(clientMapper.clientToClientDto(client));
    }

}
