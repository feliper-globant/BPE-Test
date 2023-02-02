package com.bancopichincha.applicationprogramminginterface.application.service;

import com.bancopichincha.applicationprogramminginterface.domain.excepotion.BusinessException;
import com.bancopichincha.applicationprogramminginterface.domain.gateway.ClientGateway;
import com.bancopichincha.applicationprogramminginterface.domain.model.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClientServiceTest {
    private ClientGateway clientGatewayMock;
    private ClientService clientService;

    @BeforeEach
    void setUp() {
        clientGatewayMock = mock(ClientGateway.class);
        clientService = new ClientService(clientGatewayMock);
    }

    @Test
    void testGetClients() {
        List<Client> expectedClients = List.of(new Client(), new Client());
        when(clientGatewayMock.getClients()).thenReturn(expectedClients);
        List<Client> actualClients = clientService.getClients();
        assertEquals(expectedClients, actualClients);
        verify(clientGatewayMock).getClients();
    }

    @Test
    void testGetClient() {
        String clientId = UUID.randomUUID().toString();
        Client expectedClient = new Client();
        when(clientGatewayMock.getClient(clientId)).thenReturn(Optional.of(expectedClient));
        Optional<Client> actualClient = clientService.getClient(clientId);
        assertTrue(actualClient.isPresent());
        assertEquals(expectedClient, actualClient.get());
        verify(clientGatewayMock).getClient(clientId);
    }

    @Test
    void testSaveClient() {
        Client client = new Client();
        client.setPassword("password");
        Client expectedClient = new Client();
        expectedClient.setPassword("");
        when(clientGatewayMock.saveClient(client)).thenReturn(expectedClient);
        Client actualClient = clientService.saveClient(client);
        assertEquals(expectedClient, actualClient);
        verify(clientGatewayMock).saveClient(client);
    }

    @Test
    void testDeleteClientByClientId() {
        Client client = new Client();
        clientService.deleteClientByClientId(client);
        verify(clientGatewayMock).deleteClientByClientId(client);
    }

}