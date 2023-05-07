package com.n0rth.crm.service.impl;

import com.n0rth.crm.dto.ManagerDTO;
import com.n0rth.crm.mapper.ManagerMapper;
import com.n0rth.crm.repository.ManagerRepository;
import com.n0rth.crm.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    private final ManagerRepository managerRepository;
    private final ManagerMapper managerMapper = ManagerMapper.MAPPER;

    @Override
    public List<ManagerDTO> getAll() {
        return managerMapper.fromManagerList(managerRepository.findAll());
    }
}
