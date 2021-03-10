package com.example.disastermanagement.service;

import com.example.disastermanagement.models.AffectedUnitEntity;
import java.util.List;
import java.util.Optional;

public interface AffectedUnitService {

    List<AffectedUnitEntity> findAll();

    Optional<AffectedUnitEntity> findById(int id);

    void addAffectedUnit(AffectedUnitEntity affectedUnitEntity);

    void updateAffectedUnit(int id,AffectedUnitEntity affectedUnitEntity);

    void deleteAffectedUnitById(int id);
}
