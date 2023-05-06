package com.n0rth.crm.controller;


import com.n0rth.crm.domain.*;
import com.n0rth.crm.dto.ClientCommentDTO;
import com.n0rth.crm.dto.ClientDTO;
import com.n0rth.crm.dto.DepositDTO;
import com.n0rth.crm.dto.ManagerDTO;
import com.n0rth.crm.repository.ManagerRepository;
import com.n0rth.crm.service.UserCredentialsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/admin")
@RequiredArgsConstructor
@Slf4j
public class AdminRestController {

    private final ManagerRepository managerRepository;
    private final UserCredentialsService service;

    @GetMapping
    public List<ManagerDTO> getManagers(Principal principal) {

        List<Manager> managers = managerRepository.findAll();


        return managers.stream().map(this::toDto).collect(Collectors.toList());
    }

    private ManagerDTO toDto(Manager manager) {
        UserCredentials userCredentials = manager.getUserCredentials();
        return new ManagerDTO(userCredentials.getName(),
                userCredentials.getMail(),
                manager.getClients().stream().map(this::toDto).collect(Collectors.toList()),
                manager.getDeposits().stream().map(this::toDto).collect(Collectors.toList())
        );
    }

    private ClientCommentDTO toDto(ClientComment clientComment) {
        return new ClientCommentDTO(clientComment.getInfo(), clientComment.getCreated());
    }

    private DepositDTO toDto(Deposit deposit) {
        return new DepositDTO(deposit.getSum());
    }

    private ClientDTO toDto(Client client) {
        return new ClientDTO(client.getName(),
                client.getPhoneNumber(), client.getStatus(),
                client.getCreated(),
                client.getComments().stream().map(this::toDto).toList());
    }
}

