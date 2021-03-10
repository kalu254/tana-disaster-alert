package com.kalu.tanareportdisaster.repository;

import com.kalu.tanareportdisaster.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userrepo")
public interface ApplicationUserRepository extends JpaRepository<User,Integer>{


}
