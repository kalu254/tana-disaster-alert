package com.example.disastermanagement.service;

import com.example.disastermanagement.models.ApplicationUser;
import com.example.disastermanagement.models.User;
import com.example.disastermanagement.security.ApplicationUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import static com.example.disastermanagement.security.ApplicationUserRole.*;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserDao {

    private final ChiefService chiefService;
    private final PasswordEncoder passwordEncoder;
    private ApplicationUser applicationUser;

    @Autowired
    public ApplicationUserServiceImpl(ChiefService chiefService, PasswordEncoder passwordEncoder) {
        this.chiefService = chiefService;
        this.passwordEncoder = passwordEncoder;
    }



    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
//        return Optional.of(new ApplicationUser("kalu",
//            passwordEncoder.encode("pass"),
//            CHIEF.getGrantedAuthorities(),
//            true,
//            true,
//            true,
//            true));

        User user = chiefService.findByUsername(username).get();
        applicationUser = new ApplicationUser(
            user.getUsername(),
            passwordEncoder.encode(user.getPassword()),
            CHIEF.getGrantedAuthorities(),
            true,
            true,
            true,
            true
            );


        return Optional.of(applicationUser);

    }


}
