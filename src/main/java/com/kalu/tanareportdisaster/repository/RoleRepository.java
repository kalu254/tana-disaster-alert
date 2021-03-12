package com.kalu.tanareportdisaster.repository;

import com.kalu.tanareportdisaster.models.ApplicationUserRole;
import com.kalu.tanareportdisaster.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ApplicationUserRole name);

}
