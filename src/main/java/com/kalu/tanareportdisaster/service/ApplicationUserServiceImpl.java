package com.kalu.tanareportdisaster.service;

import com.kalu.tanareportdisaster.models.ApplicationUser;
import com.kalu.tanareportdisaster.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.kalu.tanareportdisaster.security.ApplicationUserRole.CHIEF;


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
