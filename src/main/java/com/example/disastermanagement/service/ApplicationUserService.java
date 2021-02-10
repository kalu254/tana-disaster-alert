package com.example.disastermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final ApplicationUserServiceImpl applicationUserService;

    @Autowired
    public ApplicationUserService(ApplicationUserServiceImpl applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserService
            .selectApplicationUserByUsername(username)
            .orElseThrow(() ->
                new UsernameNotFoundException(String.format("Username %s not found", username))
            );
    }
}
