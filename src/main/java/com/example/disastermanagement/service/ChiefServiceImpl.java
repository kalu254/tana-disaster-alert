package com.example.disastermanagement.service;

import com.example.disastermanagement.models.ApplicationUser;
import com.example.disastermanagement.models.ChiefEntity;
import com.example.disastermanagement.repository.ChiefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChiefServiceImpl implements ChiefService {

    private final ChiefRepository chiefRepository;

    @Autowired
    public ChiefServiceImpl(ChiefRepository chiefRepository) {
        this.chiefRepository = chiefRepository;
    }

    @Override
    public List<ChiefEntity> findAll() {
        return chiefRepository.findAll();
    }

    @Override
    public Optional<ChiefEntity> findById(String id) {
        return Optional.ofNullable(chiefRepository.findChiefById(id)
            .orElseThrow(() ->
                new UsernameNotFoundException(String.format("Username %s not found", id))
            ));
    }

    @Override
    public void addChief(ChiefEntity chiefEntity) {
        chiefRepository.saveAndFlush(chiefEntity);
    }

    @Override
    public void updateChief(int id, ChiefEntity chiefEntity) {
        chiefRepository.save(chiefEntity);
    }

    @Override
    public void deleteChief(int id) {
        chiefRepository.deleteById(id);
    }


}
