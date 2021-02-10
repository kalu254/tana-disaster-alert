package com.example.disastermanagement.service;

import com.example.disastermanagement.models.ApplicationUser;
import com.example.disastermanagement.models.ChiefEntity;
import com.example.disastermanagement.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserDao {

    private final ApplicationUserRepository applicationUserRepository;

    @Autowired
    public ApplicationUserServiceImpl(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        Optional<ChiefEntity> user = applicationUserRepository
            .findAll()
            .stream()
            .filter(applicationUser -> username.equals(applicationUser.getId()))
            .findFirst();

        ChiefEntity chief = user.get();
        String usn = chief.getId();
        String password = chief.getPassword();

        ApplicationUser applicationUser = new ApplicationUser(
            usn,
            password,
            null,
            true,
            true,
            true,
            true
        );

        return Optional.of(applicationUser);
    }


}
