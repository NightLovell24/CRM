package com.n0rth.crm.mapper;

import com.n0rth.crm.domain.ClientComment;
import com.n0rth.crm.dto.ClientCommentDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientCommentMapper {
    ClientCommentMapper MAPPER = Mappers.getMapper(ClientCommentMapper.class);

    ClientComment toClientComment(ClientCommentDTO dto);

    @InheritInverseConfiguration
    ClientCommentDTO fromClientComment(ClientComment clientComment);

    List<ClientComment> toClientCommentList(List<ClientCommentDTO> clientCommentDTOS);

    List<ClientCommentDTO> fromClientCommentList(List<ClientComment> clientComments);
}
