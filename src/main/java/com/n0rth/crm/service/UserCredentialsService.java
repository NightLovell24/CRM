package com.n0rth.crm.service;

import com.n0rth.crm.domain.UserCredentials;

import java.util.List;

public interface UserCredentialsService {
    UserCredentials findByName(String name);

    List<UserCredentials> getAll();

    UserCredentials create(UserCredentials userCredentials);

    UserCredentials findById(Long id);

    void delete(Long id);
}
