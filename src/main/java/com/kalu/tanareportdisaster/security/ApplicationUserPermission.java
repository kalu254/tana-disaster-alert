package com.kalu.tanareportdisaster.security;

public enum ApplicationUserPermission {
    DISASTER_READ("disaster:read"),
    DISASTER_WRITE("disaster:write"),
    CHIEF_READ("chief:read"),
    CHIEF_WRITE("chief:write"),
    COMMISSIONER_READ("commissioner:read"),
    COMMISSIONER_WRITE("commissioner:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
