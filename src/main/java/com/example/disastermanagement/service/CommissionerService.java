package com.example.disastermanagement.service;

import com.example.disastermanagement.models.CommissionerEntity;

import java.util.List;
import java.util.Optional;

public interface CommissionerService {

    List<CommissionerEntity> findAll();

    Optional<CommissionerEntity> findById(String id);

    void addCommissioner(CommissionerEntity commissionerEntity);

    void updateCommissioner(CommissionerEntity commissionerEntity);

    void deleteCommissioner(int id);
}
