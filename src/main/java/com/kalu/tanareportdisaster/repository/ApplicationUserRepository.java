package com.example.disastermanagement.repository;

import com.example.disastermanagement.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userrepo")
public interface ApplicationUserRepository extends JpaRepository<User,Integer>{


}
