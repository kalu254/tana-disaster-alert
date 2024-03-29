package com.example.disastermanagement.service;

import com.example.disastermanagement.models.DisasterEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface DisasterService {

    List<DisasterEntity> findAll();

    Optional<DisasterEntity> findById(int id);

    void addDisaster(MultipartFile[] imageFiles, DisasterEntity disasterEntity);

    void updateDisaster(int id, DisasterEntity disasterEntity, MultipartFile multipartFile);
    void deleteDisaster(int id);
}
