package com.example.disastermanagement.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.disastermanagement.security.ApplicationUserPermission.*;


public enum ApplicationUserRole {
    CHIEF(Sets.newHashSet(DISASTER_READ,DISASTER_WRITE,COMMISSIONER_READ)),
    COMMISSIONER(Sets.newHashSet(DISASTER_READ,DISASTER_WRITE,CHIEF_READ,CHIEF_WRITE,COMMISSIONER_READ,COMMISSIONER_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
