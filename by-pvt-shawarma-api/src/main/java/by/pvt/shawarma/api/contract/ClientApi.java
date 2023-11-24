package by.pvt.shawarma.api.contract;

import by.pvt.shawarma.api.dto.ClientRequest;
import by.pvt.shawarma.api.dto.ClientResponse;

import java.util.List;

public interface ClientApi {
    ClientResponse register(ClientRequest clientRequest);

    ClientResponse authorise(String login, String password);

    void delete(Long id);

    List<ClientResponse> getAllClients();

    ClientResponse findClientById(Long id);

    List<ClientResponse> update(ClientRequest clientRequest);
}
