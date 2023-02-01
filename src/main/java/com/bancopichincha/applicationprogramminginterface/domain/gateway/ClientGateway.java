package com.bancopichincha.applicationprogramminginterface.domain.gateway;

import com.bancopichincha.applicationprogramminginterface.domain.model.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientGateway {
    List<Client> getClients();
    Optional<Client> getClient (String clientId);
    Client saveClient (Client client);
    void deleteClientByClientId(Client client);
}
