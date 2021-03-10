package com.kalu.tanareportdisaster.service;


import com.kalu.tanareportdisaster.models.ApplicationUser;

import java.util.Optional;

public interface ApplicationUserDao {

    Optional<ApplicationUser> selectApplicationUserByUsername(String username);

}
