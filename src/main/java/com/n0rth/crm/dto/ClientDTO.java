package com.n0rth.crm.dto;

import com.n0rth.crm.domain.ClientStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDTO {
    private String name;
    private String phoneNumber;
    private ClientStatus status;
    private LocalDateTime created;
    private List<ClientCommentDTO> dtoList;

}
