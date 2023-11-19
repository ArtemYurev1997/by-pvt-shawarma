package by.pvt.shawarma.core.mapper;

import by.pvt.shawarma.api.dto.ClientRequest;
import by.pvt.shawarma.api.dto.ClientResponse;
import by.pvt.shawarma.core.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMappers {
    ClientResponse toResponse(Client client);
    Client toEntity(ClientRequest clientRequest);
}
