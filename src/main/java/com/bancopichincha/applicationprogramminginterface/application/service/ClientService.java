package com.bancopichincha.applicationprogramminginterface.application.service;

import com.bancopichincha.applicationprogramminginterface.domain.gateway.ClientGateway;
import com.bancopichincha.applicationprogramminginterface.domain.model.Client;
import com.bancopichincha.applicationprogramminginterface.domain.usecase.ClientUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class ClientService implements ClientUseCase {

    private final ClientGateway clientGateway;

    @Override
    public List<Client> getClients() {
        return clientGateway.getClients();
    }

    @Override
    public Optional<Client> getClient(String clientId) {
        return clientGateway.getClient(clientId);
    }

    @Override
    public Client saveClient(Client client) {
        return clientGateway.saveClient(client);
    }

    @Override
    public void deleteClientByClientId(Client client) {
        clientGateway.deleteClientByClientId(client);
    }
}
