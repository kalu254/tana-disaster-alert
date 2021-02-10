package com.example.disastermanagement.repository;

import com.example.disastermanagement.models.ApplicationUser;
import com.example.disastermanagement.models.ChiefEntity;
import com.example.disastermanagement.service.ApplicationUserDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("userrepo")
public interface ApplicationUserRepository extends JpaRepository<ChiefEntity,Integer>{


}
