package com.n0rth.crm.repository;

import com.n0rth.crm.domain.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Long> {

    UserCredentials findByName(String name);
}
