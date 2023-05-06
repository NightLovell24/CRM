package com.n0rth.crm.security;

import com.n0rth.crm.domain.UserCredentials;
import com.n0rth.crm.security.jwt.JwtUser;
import com.n0rth.crm.security.jwt.JwtUserFactory;
import com.n0rth.crm.service.UserCredentialsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserCredentialsService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentials userCredentials = service.findByName(username);

        if (userCredentials == null) {
            throw new UsernameNotFoundException("User with username " + username + " not found!");
        }

        JwtUser user = JwtUserFactory.create(userCredentials);

        return user;
    }
}
