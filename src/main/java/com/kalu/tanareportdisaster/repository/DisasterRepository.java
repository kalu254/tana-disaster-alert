package com.example.disastermanagement.repository;

import com.example.disastermanagement.models.DisasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisasterRepository extends JpaRepository<DisasterEntity,Integer> {
}
