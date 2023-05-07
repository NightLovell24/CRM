package com.n0rth.crm.mapper;

import com.n0rth.crm.domain.Deposit;
import com.n0rth.crm.dto.DepositDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DepositMapper {
    DepositMapper MAPPER = Mappers.getMapper(DepositMapper.class);

    Deposit toDeposit(DepositDTO dto);

    @InheritInverseConfiguration
    DepositDTO fromDeposit(Deposit deposit);

    List<Deposit> toDepositList(List<DepositDTO> depositDTOS);

    List<DepositDTO> fromDepositList(List<Deposit> deposits);
}
