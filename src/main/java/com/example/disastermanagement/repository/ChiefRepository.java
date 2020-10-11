package com.example.disastermanagement.repository;

import com.example.disastermanagement.models.ChiefEntity;
import com.example.disastermanagement.models.CommissionerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChiefRepository extends JpaRepository<ChiefEntity, Integer> {

    Optional<ChiefEntity> findChiefById(String id);
}
