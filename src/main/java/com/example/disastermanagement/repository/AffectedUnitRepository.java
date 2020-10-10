package com.example.disastermanagement.repository;

import com.example.disastermanagement.models.AffectedUnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AffectedUnitRepository  extends JpaRepository<AffectedUnitEntity, Integer> {
}
