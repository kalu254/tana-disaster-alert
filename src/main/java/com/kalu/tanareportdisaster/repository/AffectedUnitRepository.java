package com.kalu.tanareportdisaster.repository;

import com.kalu.tanareportdisaster.models.AffectedUnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AffectedUnitRepository  extends JpaRepository<AffectedUnitEntity, Integer> {
}
