package com.kalu.tanareportdisaster.service;


import com.kalu.tanareportdisaster.models.User;

import java.util.List;
import java.util.Optional;

public interface ChiefService {

    List<User> findAll();

    Optional<User> findById(Integer id);

    Optional<User> findByUsername(String username);

    void addChief(User user);

    void updateChief(int id, User user);

    void deleteChief(int id);
}
