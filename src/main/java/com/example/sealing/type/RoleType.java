package com.example.sealing.type;

import org.springframework.security.core.GrantedAuthority;

public enum RoleType implements GrantedAuthority {
    USER("ROLE_USER", "一般", 0),
    ADMIN("ROLE_ADMIN", "管理者", 1),
    ACTUATOR("ROLE_ACTUATOR", "運用者", 2);

    private final String name;
    private final String label;
    private final Integer value;

    RoleType(String name, String label, Integer value) {
        this.name = name;
        this.label = label;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String getAuthority() {
        return this.name;
    }

    public static RoleType getRoleTypeByValue(Integer value) {
        return value == 0 ? RoleType.USER :
               value == 1 ? RoleType.ADMIN :
               value == 2 ? RoleType.ACTUATOR : null;
    }
}
