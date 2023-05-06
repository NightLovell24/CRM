package com.n0rth.crm.dto;


import com.n0rth.crm.domain.Client;
import com.n0rth.crm.domain.Deposit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ManagerDTO {
    private String username;
    private String email;
    private List<ClientDTO> clients;
    private List<DepositDTO> deposits;
}
