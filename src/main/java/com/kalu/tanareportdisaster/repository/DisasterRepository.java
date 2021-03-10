package com.kalu.tanareportdisaster.repository;

import com.kalu.tanareportdisaster.models.DisasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisasterRepository extends JpaRepository<DisasterEntity,Integer> {
}
