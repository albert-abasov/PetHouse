package ua.abasov.coursework.pethouse.user.model;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    PET_OWNER,
    EMPLOYEE,
    ADMIN;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
