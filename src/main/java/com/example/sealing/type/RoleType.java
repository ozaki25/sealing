package com.example.sealing.type;

import org.springframework.security.core.GrantedAuthority;

public enum RoleType implements GrantedAuthority  {
    USER("USER"),
    ADMIN("ADMIN");

    private final String name;

    RoleType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getAuthority() {
        return this.name;
    }
}
