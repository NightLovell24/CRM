package com.n0rth.crm.service.impl;

import com.n0rth.crm.domain.UserCredentials;
import com.n0rth.crm.repository.UserCredentialsRepository;
import com.n0rth.crm.service.UserCredentialsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserCredentialsServiceImpl implements UserCredentialsService {

    private final UserCredentialsRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserCredentials findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<UserCredentials> getAll() {
        return repository.findAll();
    }

    @Override
    public UserCredentials create(UserCredentials userCredentials) {
        userCredentials.setPassword(passwordEncoder.encode(userCredentials.getPassword()));
        return repository.save(userCredentials);
    }

    @Override
    public UserCredentials findById(Long id) {
        Optional<UserCredentials> credentials = repository.findById(id);
        return credentials.orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
