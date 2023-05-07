package com.n0rth.crm.controller;


import com.n0rth.crm.dto.ManagerDTO;
import com.n0rth.crm.service.ManagerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/admin")
@RequiredArgsConstructor
@Slf4j
public class AdminRestController {

    private final ManagerService managerService;

    @GetMapping
    public List<ManagerDTO> getManagers() {

        return managerService.getAll();
    }
}

