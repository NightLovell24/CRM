package com.n0rth.crm.mapper;

import com.n0rth.crm.domain.Manager;
import com.n0rth.crm.dto.ManagerDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {ClientMapper.class, DepositMapper.class})
public interface ManagerMapper {
    ManagerMapper MAPPER = Mappers.getMapper(ManagerMapper.class);

    @Mappings({@Mapping(target = "userCredentials.name", source = "username"),
            @Mapping(target = "userCredentials.mail", source = "email")})
    Manager toManager(ManagerDTO dto);

    @InheritInverseConfiguration
    ManagerDTO fromManager(Manager manager);

    List<Manager> toManagerList(List<ManagerDTO> managerDTOS);

    List<ManagerDTO> fromManagerList(List<Manager> managers);


}
