package com.example.disastermanagement.repository;

import com.example.disastermanagement.models.CommissionerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CommissionerRepository extends JpaRepository<CommissionerEntity,Integer> {

    Optional<CommissionerEntity> findCommissionerById(String id);
}
