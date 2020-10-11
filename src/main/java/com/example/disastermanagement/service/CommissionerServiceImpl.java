package com.example.disastermanagement.service;

import com.example.disastermanagement.models.CommissionerEntity;
import com.example.disastermanagement.repository.CommissionerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommissionerServiceImpl implements CommissionerService {

    private final CommissionerRepository commissionerRepository;

    @Autowired
    public CommissionerServiceImpl(CommissionerRepository commissionerRepository) {
        this.commissionerRepository = commissionerRepository;
    }

    @Override
    public List<CommissionerEntity> findAll() {
        return commissionerRepository.findAll();
    }

    @Override
    public Optional<CommissionerEntity> findById(String id) {
        return commissionerRepository.findCommissionerById(id);
    }

    @Override
    public void addCommissioner(CommissionerEntity commissionerEntity) {
        commissionerRepository.saveAndFlush(commissionerEntity);
    }

    @Override
    public void updateCommissioner(CommissionerEntity commissionerEntity) {
        commissionerRepository.saveAndFlush(commissionerEntity);
    }

    @Override
    public void deleteCommissioner(int id) {
        commissionerRepository.deleteById(id);
    }

}
