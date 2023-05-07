package com.n0rth.crm.mapper;

import com.n0rth.crm.domain.Client;
import com.n0rth.crm.dto.ClientDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = ClientCommentMapper.class)
public interface ClientMapper {
    ClientMapper MAPPER = Mappers.getMapper(ClientMapper.class);

    Client toClient(ClientDTO dto);

    @InheritInverseConfiguration
    ClientDTO fromClient(Client client);

    List<Client> toClientList(List<ClientDTO> clientDTOS);

    List<ClientDTO> fromClientList(List<Client> clients);
}
