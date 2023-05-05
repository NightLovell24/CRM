package com.n0rth.crm.security.jwt;

import com.n0rth.crm.domain.UserCredentials;
import com.n0rth.crm.domain.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(UserCredentials userCredentials) {
        return new JwtUser(userCredentials.getId(),
                userCredentials.getName(),
                userCredentials.getPassword(),
                userCredentials.getMail(),
                userCredentials.isEnabled(),
                null
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<UserRole> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
    }
}
