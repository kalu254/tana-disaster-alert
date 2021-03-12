package com.kalu.tanareportdisaster.models;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.kalu.tanareportdisaster.models.ApplicationUserPermission.*;


public enum ApplicationUserRole {
    CHIEF(Sets.newHashSet(DISASTER_READ,DISASTER_WRITE,COMMISSIONER_READ)),
    COMMISSIONER(Sets.newHashSet(DISASTER_READ,DISASTER_WRITE,CHIEF_READ,CHIEF_WRITE,COMMISSIONER_READ,COMMISSIONER_WRITE)),
    ADMIN(Sets.newHashSet(DISASTER_READ,DISASTER_WRITE,COMMISSIONER_READ,DISASTER_READ,DISASTER_WRITE,CHIEF_READ,CHIEF_WRITE,COMMISSIONER_READ,COMMISSIONER_WRITE));




    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
            .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
            .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
