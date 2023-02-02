package com.bancopichincha.applicationprogramminginterface.domain.usecase;

import com.bancopichincha.applicationprogramminginterface.domain.model.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientUseCase {
    List<Client> getClients();
    Optional<Client> getClient (String clientId);
    Client saveClient (Client client);
    void deleteClientByClientId(Client client);
}
