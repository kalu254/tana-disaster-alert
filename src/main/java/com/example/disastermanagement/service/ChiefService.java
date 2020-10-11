package com.example.disastermanagement.service;

import com.example.disastermanagement.models.ChiefEntity;

import java.util.List;
import java.util.Optional;

public interface ChiefService {

    List<ChiefEntity> findAll();

    Optional<ChiefEntity> findById(String id);

    void addChief(ChiefEntity chiefEntity);

    void updateChief(int id,ChiefEntity chiefEntity);

    void deleteChief(int id);
}
