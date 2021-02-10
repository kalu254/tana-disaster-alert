package com.example.disastermanagement.service;

import com.example.disastermanagement.models.ApplicationUser;

import java.util.Optional;

public interface ApplicationUserDao {

    Optional<ApplicationUser> selectApplicationUserByUsername(String username);

}
