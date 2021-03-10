package com.kalu.tanareportdisaster.service;

import com.kalu.tanareportdisaster.models.AffectedUnitEntity;
import com.kalu.tanareportdisaster.repository.AffectedUnitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AffectedUnitImpl  implements AffectedUnitService{

    private final AffectedUnitRepository affectedUnitRepository;

    public AffectedUnitImpl(AffectedUnitRepository affectedUnitRepository) {
        this.affectedUnitRepository = affectedUnitRepository;
    }

    @Override
    public List<AffectedUnitEntity> findAll() {
        return affectedUnitRepository.findAll();
    }

    @Override
    public Optional<AffectedUnitEntity> findById(int id) {
        return affectedUnitRepository.findById(id);
    }

    @Override
    public void addAffectedUnit(AffectedUnitEntity affectedUnitEntity) {
        affectedUnitRepository.saveAndFlush(affectedUnitEntity);
    }

    @Override
    public void updateAffectedUnit(int id, AffectedUnitEntity affectedUnitEntity) {
        affectedUnitRepository.saveAndFlush(affectedUnitEntity);
    }

    @Override
    public void deleteAffectedUnitById(int id) {
        affectedUnitRepository.deleteById(id);
    }
}
